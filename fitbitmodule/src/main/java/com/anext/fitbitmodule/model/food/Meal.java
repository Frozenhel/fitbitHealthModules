package com.anext.fitbitmodule.model.food;

import java.util.List;

/**
 * Created by Jiri on 02/08/17.
 */

public class Meal {
    private List<Food> mealFoods;
    private int id;
    private String description;
    private String name;

    public Meal(List<Food> mealFoods, int id, String description, String name) {
        this.mealFoods = mealFoods;
        this.id = id;
        this.description = description;
        this.name = name;
    }

    public List<Food> getMealFoods() {
        return mealFoods;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealFoods=" + mealFoods +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
