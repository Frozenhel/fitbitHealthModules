package com.anext.fitbitmodule.manager;

import com.anext.fitbitmodule.FitbitManager;
import com.anext.fitbitmodule.exception.HttpCodeException;
import com.anext.fitbitmodule.model.food.FoodLog;
import com.anext.fitbitmodule.model.food.FoodResponse;
import com.anext.fitbitmodule.model.food.Meal;
import com.anext.fitbitmodule.model.food.MealResponse;
import com.anext.fitbitmodule.service.FoodService;
import com.anext.fitbitmodule.util.DateConvertor;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Jiri on 31/07/17.
 */

public class FoodManager {
    private FoodService service;

    public FoodManager(FoodService service){
        this.service = service;
    }

    public List<Meal> downloadMeals() throws HttpCodeException, IOException {

        Call<MealResponse> call = service.getMeals();
        Response<MealResponse> response = call.execute();
        FitbitManager.validateResponseCode(response);

        return response.body().getMeals();
    }

    public List<FoodLog> downloadFoodsForDay(Date date) throws HttpCodeException, IOException {
        if(date == null) date = new Date();

        Call<FoodResponse> call = service.getFoodForDay(DateConvertor.convertDateToString(date));
        Response<FoodResponse> response = call.execute();
        FitbitManager.validateResponseCode(response);

        return response.body().getFoods();
    }

    public boolean logFood(){
        //TODO budu si to potrebovat upresnit

        return false;
    }

    public boolean logMeal(){
        //TODO stejny problem jak u log FOOD

        return false;
    }

}
