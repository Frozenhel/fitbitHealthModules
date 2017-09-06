package com.anext.jiri.healthmodule;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anext.fitbitmodule.FitbitManager;
import com.anext.fitbitmodule.exception.HttpCodeException;
import com.anext.fitbitmodule.model.activity.Activity;
import com.anext.fitbitmodule.model.activity.Sleep;
import com.anext.fitbitmodule.model.body.BodyFat;
import com.anext.fitbitmodule.model.body.BodyWeight;
import com.anext.fitbitmodule.model.food.FoodLog;
import com.anext.fitbitmodule.model.food.Meal;
import com.anext.ihealthmodule.IHealthManager;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, View.OnClickListener {
    private FitbitManager fitbitManager;
    private IHealthManager iHealthManager;

    private EditText editTextStartDate;
    private EditText editTextEndDate;
    private EditText editTextPeriod;

    private Button btnConnect;
    private Button btnConnectToIhealth;

    private Button btnGetActivities;
    private Button btnLogActivity;

    private Button btnFatForDay;
    private Button btnFatForPeriod;
    private Button btnFatForRange;

    private Button btnWeightForDay;
    private Button btnWeightForPeriod;
    private Button btnWeightForRange;

    private Button btnFoodForDay;
    private Button btnMeals;

    private Button btnLogFood;
    private Button btnLogMeal;

    private Button btnGetSleep;
    private Button btnLogSleep;

    private TextView textViewResult;

    private Date startDate;
    private Date endDate;

    Handler handler = new Handler();

    private ConnectionStatus connectionStatus = ConnectionStatus.DISCONNECTED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fitbitManager = FitbitManager.getInstance();
        iHealthManager = IHealthManager.getInstance();

        initComponents();
    }

    private void initComponents() {
        editTextStartDate = (EditText) findViewById(R.id.date_picker_start);
        editTextEndDate = (EditText) findViewById(R.id.date_picker_end);
        editTextPeriod = (EditText) findViewById(R.id.date_picker_period);

        btnConnect = (Button) findViewById(R.id.btnConnect);
        btnConnectToIhealth = (Button) findViewById(R.id.btnConnectIHealth);

        btnGetActivities = (Button) findViewById(R.id.btnGetActivityList);
        btnLogActivity = (Button) findViewById(R.id.btnLogActivity);

        btnFatForDay = (Button) findViewById(R.id.btnFatForDay);
        btnFatForPeriod = (Button) findViewById(R.id.btnFatForPeriod);
        btnFatForRange = (Button) findViewById(R.id.btnFatForRange);

        btnWeightForDay = (Button) findViewById(R.id.btnWeightForDay);
        btnWeightForPeriod = (Button) findViewById(R.id.btnWeightForPeriod);
        btnWeightForRange = (Button) findViewById(R.id.btnWeightForRange);

        btnFoodForDay = (Button) findViewById(R.id.btnGetFoodForDay);
        btnMeals = (Button) findViewById(R.id.btnGetMeals);

        btnLogFood = (Button) findViewById(R.id.btnLogFood);
        btnLogMeal = (Button) findViewById(R.id.btnLogMeal);

        btnGetSleep = (Button) findViewById(R.id.btnGetSleep);
        btnLogSleep = (Button) findViewById(R.id.btnLogSleep);

        textViewResult = (TextView) findViewById(R.id.textViewResult);

        enableButtons(false);
        initButtons();
    }

    private void enableButtons(boolean enable){
        btnGetActivities.setEnabled(enable);
        btnLogActivity.setEnabled(enable);

        btnFatForDay.setEnabled(enable);
        btnFatForPeriod.setEnabled(enable);
        btnFatForRange.setEnabled(enable);

        btnWeightForDay.setEnabled(enable);
        btnWeightForPeriod.setEnabled(enable);
        btnWeightForRange.setEnabled(enable);

        btnFoodForDay.setEnabled(enable);
        btnMeals.setEnabled(enable);

        btnLogFood.setEnabled(enable);
        btnLogMeal.setEnabled(enable);

        btnGetSleep.setEnabled(enable);
        btnLogSleep.setEnabled(enable);
    }

    private void initButtons() {
        initDateFields();
        initConnectionButtons();
        initButtonsListeners();
    }

    private void initDateFields() {
        Calendar calendar = new GregorianCalendar();
        final DatePickerDialog datePickerDialog = new DatePickerDialog(
                MainActivity.this, MainActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        editTextStartDate.setInputType(InputType.TYPE_NULL);
        editTextStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.getDatePicker().setTag(editTextStartDate.getId());
                datePickerDialog.show();
            }
        });

        editTextEndDate.setInputType(InputType.TYPE_NULL);
        editTextEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.getDatePicker().setTag(editTextEndDate.getId());
                datePickerDialog.show();
            }
        });
    }

    private void initConnectionButtons() {
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, fitbitManager.getAuthenticationUrl());
                startActivity(intent);
            }
        });


        btnConnectToIhealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, iHealthManager.getAuthenticationUrl());
                startActivity(intent);
            }
        });
    }
    
    private void initButtonsListeners(){
        btnGetActivities.setOnClickListener(this);
        btnLogActivity.setOnClickListener(this);

        btnFatForDay.setOnClickListener(this);
        btnFatForPeriod.setOnClickListener(this);
        btnFatForRange.setOnClickListener(this);

        btnWeightForDay.setOnClickListener(this);
        btnWeightForPeriod.setOnClickListener(this);
        btnWeightForRange.setOnClickListener(this);

        btnFoodForDay.setOnClickListener(this);
        btnMeals.setOnClickListener(this);

        btnLogFood.setOnClickListener(this);
        btnLogMeal.setOnClickListener(this);

        btnGetSleep.setOnClickListener(this);
        btnLogSleep.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Uri uri = intent.getData();
        if (uri != null && uri.toString().startsWith(FitbitManager.CALLBACK_URL)) {
            fitbitManager.authenticate(uri);
            Toast.makeText(this, "Callback Fitbit succesfull", Toast.LENGTH_SHORT).show();
            showResult("Connected to FITBIT");
            enableButtons(true);
            connectionStatus = ConnectionStatus.CONNECTED_TO_FITBIT;
        }else if(uri != null && uri.toString().startsWith(IHealthManager.CALLBACK_URL)) {
            iHealthManager.authenticate(uri);
            Toast.makeText(this, "Callback IHealt succesfull", Toast.LENGTH_SHORT).show();
            showResult("Connected to IHEALTH");
            enableButtons(true);
            connectionStatus = ConnectionStatus.CONNECTED_TO_IHEALTH;
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        if ((int) datePicker.getTag() == editTextStartDate.getId()) {
            startDate = getDateFromDatePicker(datePicker);
            editTextStartDate.setText(i + "-" + i1 + "-" + i2);
        } else if ((int) datePicker.getTag() == editTextEndDate.getId()) {
            endDate = getDateFromDatePicker(datePicker);
            editTextEndDate.setText(i + "-" + i1 + "-" + i2);
        }
    }

    private Date getDateFromDatePicker(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

    private void showResult(final String result) {
        handler.post(new Runnable() {
            public void run() {
                textViewResult.setText(result);
            }
        });
    }

    @Override
    public void onClick(final View view) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        boolean success;
                        switch (connectionStatus) {
                            case DISCONNECTED:
                                showResult("NOT CONNECTED");
                                break;
                            case CONNECTED_TO_FITBIT:
                                switch (view.getId()){
                                    case R.id.btnGetActivityList:
                                        List<Activity> summary = fitbitManager.getActivityManager().downloadActivities();
                                        showResult(summary.toString());
                                        break;
                                    case R.id.btnLogActivity:
                                        success = fitbitManager.getActivityManager().logActivity("MyActivity",500,"10:20:30",500000, startDate, 100);
                                        if(success)
                                            showResult("Activity Log Successful");
                                        else
                                            showResult("Activity Log Failed");
                                        break;
                                    case R.id.btnGetSleep:
                                        List<Sleep> sleeps = fitbitManager.getActivityManager().downloadSleeps();
                                        showResult(sleeps.toString());
                                        break;
                                    case R.id.btnLogSleep:
                                        success = fitbitManager.getActivityManager().logSleep(startDate);
                                        if(success)
                                            showResult("Sleep Log Successful");
                                        else
                                            showResult("Sleep Log Failed");
                                        break;
                                    case R.id.btnFatForDay:
                                        List<BodyFat> fatForDay = fitbitManager.getBodyManager().downloadBodyFatForDay(startDate);
                                        showResult(fatForDay.toString());
                                        break;
                                    case R.id.btnFatForPeriod:
                                        List<BodyFat> fatForPeriod = fitbitManager.getBodyManager().downloadBodyFatForPeriod(startDate, editTextPeriod.getText().toString());
                                        showResult(fatForPeriod.toString());
                                        break;
                                    case R.id.btnFatForRange:
                                        List<BodyFat> fatForRange = fitbitManager.getBodyManager().downloadBodyFatForRange(startDate, endDate);
                                        showResult(fatForRange.toString());
                                        break;
                                    case R.id.btnWeightForDay:
                                        List<BodyWeight> weightForDay = fitbitManager.getBodyManager().downloadBodyWeightForDay(startDate);
                                        showResult(weightForDay.toString());
                                        break;
                                    case R.id.btnWeightForPeriod:
                                        List<BodyWeight> weightForPeriod = fitbitManager.getBodyManager().downloadBodyWeightForPeriod(startDate, editTextPeriod.getText().toString());
                                        showResult(weightForPeriod.toString());
                                        break;
                                    case R.id.btnWeightForRange:
                                        List<BodyWeight> weightForRange = fitbitManager.getBodyManager().downloadBodyWeightForRange(startDate, endDate);
                                        showResult(weightForRange.toString());
                                        break;
                                    case R.id.btnGetFoodForDay:
                                        List<FoodLog> foodsForDay = fitbitManager.getFoodManager().downloadFoodsForDay(startDate);
                                        showResult(foodsForDay.toString());
                                        break;
                                    case R.id.btnGetMeals:
                                        List<Meal> meals = fitbitManager.getFoodManager().downloadMeals();
                                        showResult(meals.toString());
                                        break;
                                    case R.id.btnLogFood:
                                        success = fitbitManager.getFoodManager().logFood();
                                        if(success)
                                            showResult("Food Log Successful");
                                        else
                                            showResult("Food Log Failed");
                                        break;
                                    case R.id.btnLogMeal:
                                        success = fitbitManager.getFoodManager().logMeal();
                                        if(success)
                                            showResult("Meal Log Successful");
                                        else
                                            showResult("Meal Log Failed");
                                        break;
                                    default:
                                        showResult("UNKNOWN FITBIT BUTTON CLICK");
                                }
                                break;
                            case CONNECTED_TO_IHEALTH:
                                switch (view.getId()){
                                    case R.id.btnGetActivityList:
                                        List<com.anext.ihealthmodule.model.Activity> activities = iHealthManager.getDataManager().downloadActivities();
                                        showResult(activities.toString());
                                        break;
                                    case R.id.btnLogActivity:
                                        List<com.anext.ihealthmodule.model.BloodPressure> bloodPressures = iHealthManager.getDataManager().downloadBloodPressures();
                                        showResult(bloodPressures.toString());
                                        break;
                                    case R.id.btnGetSleep:
                                        List<com.anext.ihealthmodule.model.BloodOxygen> bloodOxygens = iHealthManager.getDataManager().downloadBloodOxygen();
                                        showResult(bloodOxygens.toString());
                                        break;
                                    case R.id.btnLogSleep:
                                        //TODO
                                        break;
                                    case R.id.btnFatForDay:
                                        //TODO
                                        break;
                                    case R.id.btnFatForPeriod:
                                        //TODO
                                        break;
                                    case R.id.btnFatForRange:
                                        //TODO
                                        break;
                                    case R.id.btnWeightForDay:
                                        //TODO
                                        break;
                                    case R.id.btnWeightForPeriod:
                                        //TODO
                                        break;
                                    case R.id.btnWeightForRange:
                                        //TODO
                                        break;
                                    case R.id.btnGetFoodForDay:
                                        //TODO
                                        break;
                                    case R.id.btnGetMeals:
                                        //TODO
                                        break;
                                    case R.id.btnLogFood:
                                        //TODO
                                        break;
                                    case R.id.btnLogMeal:
                                        //TODO
                                        break;
                                    default:
                                        showResult("UNKNOWN IHEALTH BUTTON CLICK");
                                }
                                break;
                            default:
                                showResult("Unknown result");
                        }
                    } catch (IOException e) {
                        showResult(e.getMessage());
                    } catch (HttpCodeException e) {
                        showResult(e.getCode() + ":" + e.getMessage());
                    } catch (com.anext.ihealthmodule.exception.HttpCodeException e) {
                        showResult(e.getCode() + ":" + e.getMessage());
                    }
                }
            }).start();
    }
}
