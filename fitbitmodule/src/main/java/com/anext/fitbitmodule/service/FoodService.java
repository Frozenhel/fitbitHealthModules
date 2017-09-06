package com.anext.fitbitmodule.service;

import com.anext.fitbitmodule.model.food.FoodResponse;
import com.anext.fitbitmodule.model.food.MealResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Jiri on 26/07/17.
 */

public interface FoodService {
    @GET("1/user/-/meals.json")
    Call<MealResponse> getMeals();

   /* @POST("1/user/-/meals.json")
    Call<MealResponse>*/

    @GET("1/user/-/foods/log/date/{date}.json")
    Call<FoodResponse> getFoodForDay(@Path("date") String date);
}
