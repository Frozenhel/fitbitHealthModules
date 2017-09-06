package com.anext.fitbitmodule.model.food;

import java.util.List;

/**
 * Created by Jiri on 26/07/17.
 */

public class Food {
    private String accessLevel;
    private int amount;
    private String brand;
    private int calories;
    private int foodId;
    private int mealTypeId;
    private String locale;
    private String name;
    private Unit unit;
    private List<Integer> units;

    public Food(String accessLevel, int amount, String brand, int calories, int foodId, int mealTypeId, String locale, String name, Unit unit, List<Integer> units) {
        this.accessLevel = accessLevel;
        this.amount = amount;
        this.brand = brand;
        this.calories = calories;
        this.foodId = foodId;
        this.mealTypeId = mealTypeId;
        this.locale = locale;
        this.name = name;
        this.unit = unit;
        this.units = units;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public int getAmount() {
        return amount;
    }

    public String getBrand() {
        return brand;
    }

    public int getCalories() {
        return calories;
    }

    public int getFoodId() {
        return foodId;
    }

    public int getMealTypeId() {
        return mealTypeId;
    }

    public String getLocale() {
        return locale;
    }

    public String getName() {
        return name;
    }

    public Unit getUnit() {
        return unit;
    }

    public List<Integer> getUnits() {
        return units;
    }

    @Override
    public String toString() {
        return "Food{" +
                "accessLevel='" + accessLevel + '\'' +
                ", amount=" + amount +
                ", brand='" + brand + '\'' +
                ", calories=" + calories +
                ", foodId=" + foodId +
                ", mealTypeId=" + mealTypeId +
                ", locale='" + locale + '\'' +
                ", name='" + name + '\'' +
                ", unit=" + unit +
                ", units=" + units +
                '}';
    }
}
