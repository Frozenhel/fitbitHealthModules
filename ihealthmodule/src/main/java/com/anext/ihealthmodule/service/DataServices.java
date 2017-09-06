package com.anext.ihealthmodule.service;

import com.anext.ihealthmodule.model.Activity;
import com.anext.ihealthmodule.model.ActivityResult;
import com.anext.ihealthmodule.model.BloodPressureResult;
import com.anext.ihealthmodule.model.GlucoseResult;
import com.anext.ihealthmodule.model.SleepResult;
import com.anext.ihealthmodule.model.WeightResult;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by Jiri on 02/08/17.
 */

public interface DataServices {
    @GET("/openapiv2/user/{userID}/activity.json/")
    Call<ActivityResult> getActivities(@Path("userID") String userId,
                                       @QueryMap Map<String, String> requiredParams,
                                       @Query("sc") String sc,
                                       @Query("sv") String sv);

    @GET
    Call<ActivityResult> getActivitiesNextPage(@Url String url);

    @GET("/openapiv2/user/{userID}/weight.json/")
    Call<WeightResult> getWeights(@Path("userID") String userId,
                                  @QueryMap Map<String, String> requiredParams,
                                  @Query("sc") String sc,
                                  @Query("sv") String sv);

    @GET
    Call<WeightResult> getWeightsNextPage(@Url String url);

    @GET("/openapiv2/user/{userID}/glucose.json/")
    Call<GlucoseResult> getGlucoses(@Path("userID") String userId,
                                    @QueryMap Map<String, String> requiredParams,
                                    @Query("sc") String sc,
                                    @Query("sv") String sv);

    @GET
    Call<GlucoseResult> getGlucosesNextPage(@Url String url);

    @GET("/openapiv2/user/{userID}/bp.json/")
    Call<BloodPressureResult> getBloodPressures(@Path("userID") String userId,
                                                @QueryMap Map<String, String> requiredParams,
                                                @Query("sc") String sc,
                                                @Query("sv") String sv);

    @GET
    Call<BloodPressureResult> getBloodPressuresNextPage(@Url String url);

    @GET("/openapiv2/user/{userID}/sleep.json/")
    Call<SleepResult> getSleeps(@Path("userID") String userId,
                                     @QueryMap Map<String, String> requiredParams,
                                     @Query("sc") String sc,
                                     @Query("sv") String sv);

    @GET
    Call<SleepResult> getSleepsNextPage(@Url String url);
}
