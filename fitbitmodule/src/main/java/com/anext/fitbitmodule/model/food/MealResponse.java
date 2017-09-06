package com.anext.fitbitmodule.model.food;

import java.util.List;

/**
 * Created by Jiri on 02/08/17.
 */

public class MealResponse {
    List<Meal> meals;

    public MealResponse(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    @Override
    public String toString() {
        return "MealResponse{" +
                "meals=" + meals +
                '}';
    }
}
