package com.anext.fitbitmodule.service;

import com.anext.fitbitmodule.model.body.BodyFatResponse;
import com.anext.fitbitmodule.model.body.BodyWeightResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Jiri on 26/07/17.
 */

public interface BodyService {
    @GET("1/user/-/body/log/fat/date/{date}.json")
    Call<BodyFatResponse> getBodyFatForDate(
            @Path("date") String date);

    @GET("1/user/-/body/log/fat/date/{date}/{period}.json")
    Call<BodyFatResponse> getBodyFatForPeriod(@Path("date") String date, @Path("period") String period);

    @GET("1/user/-/body/log/fat/date/{base-date}/{end-date}.json")
    Call<BodyFatResponse> getBodyFatInDateRange(@Path("base-date") String baseDate, @Path("end-date") String endDate);

    @GET("1/user/-/body/log/weight/date/{date}.json")
    Call<BodyWeightResponse> getBodyWeightForDate(@Path("date") String date);

    @GET("1/user/-/body/log/weight/date/{date}/{period}.json")
    Call<BodyWeightResponse> getBodyWeightForPeriod(@Path("date") String date, @Path("period") String period);

    @GET("1/user/-/body/log/weight/date/{base-date}/{end-date}.json")
    Call<BodyWeightResponse> getBodyWeightInDateRange(@Path("base-date") String baseDate, @Path("end-date") String endDate);
}
