package com.anext.fitbitmodule;

import android.net.Uri;


import com.anext.fitbitmodule.exception.HttpCodeException;
import com.anext.fitbitmodule.manager.ActivityManager;
import com.anext.fitbitmodule.manager.BodyManager;
import com.anext.fitbitmodule.manager.FoodManager;
import com.anext.fitbitmodule.model.AccessInfo;
import com.anext.fitbitmodule.service.ActivityService;
import com.anext.fitbitmodule.service.BodyService;
import com.anext.fitbitmodule.service.FoodService;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jiri on 19/07/17.
 */

public class FitbitManager {
    private static final String CLIENT_ID = "228NYD";
    public static final String CALLBACK_URL = "mytestapp://callback";

    private static FitbitManager instance;

    private Uri authenticationUrl;
    private AccessInfo accessInfo;

    private ActivityManager activityManager;
    private BodyManager bodyManager;
    private FoodManager foodManager;

    private FitbitManager()
    {
        accessInfo = new AccessInfo();
        authenticationUrl = generateAuthentizationUrl();
    }

    public static FitbitManager getInstance(){
        if(instance == null){
            instance = new FitbitManager();
        }
        return instance;
    }

    public Uri getAuthenticationUrl(){
        return authenticationUrl;
    }

    public ActivityManager getActivityManager() {
        return activityManager;
    }

    public BodyManager getBodyManager() {
        return bodyManager;
    }

    public FoodManager getFoodManager() {
        return foodManager;
    }

    private Uri generateAuthentizationUrl(){

        String url = "https://www.fitbit.com/oauth2/authorize" +
                "?client_id=" + CLIENT_ID +
                "&response_type=token" +
                "&expires_in=86400" + // token expires in 1 day
                "&scope=activity heartrate location nutrition profile settings sleep social weight";
       // url = url.replaceAll(" ", "%20");

        return Uri.parse(url);
    }

    public void authenticate(Uri uri){
        accessInfo = new AccessInfo(uri);

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient().newBuilder();
        okHttpBuilder.addInterceptor(new Interceptor() {
            @Override public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer " + accessInfo.getAccessToken()).build();
                return chain.proceed(request);
            }
        });

        OkHttpClient okHttpClient = okHttpBuilder.build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.fitbit.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        ActivityService activityService = retrofit.create(ActivityService.class);
        BodyService bodyService = retrofit.create(BodyService.class);
        FoodService foodService = retrofit.create(FoodService.class);

        activityManager = new ActivityManager(activityService);
        bodyManager = new BodyManager(bodyService);
        foodManager = new FoodManager(foodService);
    }

    public static void validateResponseCode(@NotNull Response response) throws HttpCodeException, IOException {
        if(response.code() != 200 && response.code() != 201){
            throw new HttpCodeException(response.code(), response.errorBody().string());
        }
    }
}
