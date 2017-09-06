package com.anext.fitbitmodule.manager;


import com.anext.fitbitmodule.FitbitManager;
import com.anext.fitbitmodule.exception.HttpCodeException;
import com.anext.fitbitmodule.model.activity.Activity;
import com.anext.fitbitmodule.model.activity.ActivityResponse;
import com.anext.fitbitmodule.model.activity.Sleep;
import com.anext.fitbitmodule.model.activity.SleepLogResponse;
import com.anext.fitbitmodule.model.activity.SleepResponse;
import com.anext.fitbitmodule.service.ActivityService;
import com.anext.fitbitmodule.util.DateConvertor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Jiri on 31/07/17.
 */

public class ActivityManager {
    private ActivityService service;

    public ActivityManager(ActivityService service){
        this.service = service;
    }

    public List<Activity> downloadActivities() throws HttpCodeException, IOException {
        List<Activity> activities = new ArrayList<>();

        Call<ActivityResponse> call = service.getActivities(DateConvertor.convertDateToString(new Date()),null,"desc",20,0);
        Response<ActivityResponse> response = call.execute();
        FitbitManager.validateResponseCode(response);

        if(response.body() != null){
            activities.addAll(response.body().getActivities());
        }

        while (response.body().getPagination().getNext().length() > 0){
            Call<ActivityResponse> pageCall = service.getActivitiesNextPage(response.body().getPagination().getNext());
            response = pageCall.execute();
            FitbitManager.validateResponseCode(response);

            if(response.body() != null){
                activities.addAll(response.body().getActivities());
            }
        }

        return activities;
    }

    public boolean logActivity(String activityName, int manualCalories, String startTime, int durationMillis, Date date, float distance) throws IOException, HttpCodeException {
        if(date == null) date = new Date();

        Call<Activity> call = service.postActivityLog(null,activityName, manualCalories, startTime, durationMillis, DateConvertor.convertDateToString(date) ,distance);
        Response<Activity> response = call.execute();

        if(response.isSuccessful()){
            return true;
        }else{
            FitbitManager.validateResponseCode(response);
            return false;
        }
    }


    public List<Sleep> downloadSleeps() throws IOException, HttpCodeException {
        List<Sleep> sleeps = new ArrayList<>();

        Call<SleepResponse> call = service.getSleepLogs(DateConvertor.convertDateToString(new Date()),null,"desc", 10, 0);
        Response<SleepResponse> response = call.execute();
        FitbitManager.validateResponseCode(response);

        if(response.body() != null){
            sleeps.addAll(response.body().getSleep());

        }

        while (response.body().getPagination().getNext().length() > 0){
            Call<SleepResponse> pageCall = service.getSleepLogPage(response.body().getPagination().getNext());
            response = pageCall.execute();
            FitbitManager.validateResponseCode(response);

            if(response.body() != null){
                sleeps.addAll(response.body().getSleep());
            }
        }

        return sleeps;
    }

    public boolean logSleep(Date date) throws IOException, HttpCodeException {
        if(date == null) date = new Date();

        Call<SleepLogResponse> call = service.postSleepLog("10:20", 600000L, DateConvertor.convertDateToString(date));
        Response<SleepLogResponse> response = call.execute();
        FitbitManager.validateResponseCode(response);

        return response.isSuccessful();
    }


}
