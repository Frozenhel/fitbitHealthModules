package com.anext.fitbitmodule.model.food;

import java.util.List;

/**
 * Created by Jiri on 02/08/17.
 */

public class FoodResponse {
    private List<FoodLog> foods;

    public FoodResponse(List<FoodLog> foods) {
        this.foods = foods;
    }

    public List<FoodLog> getFoods() {
        return foods;
    }

    @Override
    public String toString() {
        return "FoodResponse{" +
                "foods=" + foods +
                '}';
    }

    //TODO summary
    //TODO goals
}
