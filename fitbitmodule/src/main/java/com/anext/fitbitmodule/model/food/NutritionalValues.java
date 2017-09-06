package com.anext.fitbitmodule.model.food;

/**
 * Created by Jiri on 02/08/17.
 */

public class NutritionalValues {
    private float calories;
    private float carbs;
    private float fat;
    private float fiber;
    private float protein;
    private float sodium;

    public float getCalories() {
        return calories;
    }

    public float getCarbs() {
        return carbs;
    }

    public float getFat() {
        return fat;
    }

    public float getFiber() {
        return fiber;
    }

    public float getProtein() {
        return protein;
    }

    public float getSodium() {
        return sodium;
    }

    public NutritionalValues(float calories, float carbs, float fat, float fiber, float protein, float sodium) {
        this.calories = calories;
        this.carbs = carbs;
        this.fat = fat;
        this.fiber = fiber;
        this.protein = protein;
        this.sodium = sodium;
    }

    @Override
    public String toString() {
        return "NutritionalValues{" +
                "calories=" + calories +
                ", carbs=" + carbs +
                ", fat=" + fat +
                ", fiber=" + fiber +
                ", protein=" + protein +
                ", sodium=" + sodium +
                '}';
    }
}
