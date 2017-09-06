package com.anext.fitbitmodule.service;


import com.anext.fitbitmodule.model.activity.Activity;
import com.anext.fitbitmodule.model.activity.ActivityResponse;
import com.anext.fitbitmodule.model.activity.SleepLogResponse;
import com.anext.fitbitmodule.model.activity.SleepResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Jiri on 19/07/17.
 */

public interface ActivityService {

    @GET("1/user/-/activities/list.json")
    Call<ActivityResponse> getActivities(
            @Query("beforeDate") String beforeDate,
            @Query("afterDate") String afterDate,
            @Query("sort") String sort,
            @Query("limit") int limit,
            @Query("offset") int offset);

    @GET
    Call<ActivityResponse> getActivitiesNextPage(@Url String url);

    @POST("1/user/-/activities.json")
    Call<Activity> postActivityLog(@Query("activityId") Long activityId,
                                   @Query("activityName") String activityName,
                                   @Query("manualCalories") int manualCalories,
                                   @Query("startTime") String startTame,
                                   @Query("durationMillis") int durationMillis,
                                   @Query("date") String date,
                                   @Query("distance") float distance);

    @GET("1.2/user/-/sleep/list.json")
    Call<SleepResponse> getSleepLogs(@Query("beforeDate") String beforeDate,
                                     @Query("afterDate") String afterDate,
                                     @Query("sort") String sort,
                                     @Query("limit") int limit,
                                     @Query("offset") int offset);

    @GET
    Call<SleepResponse> getSleepLogPage(@Url String url);

    @POST("1.2/user/-/sleep.json")
    Call<SleepLogResponse> postSleepLog(@Query("startTime") String startTime,
                                        @Query("duration") Long duration,
                                        @Query("date") String date);

}
