package com.anext.fitbitmodule.model.food;

/**
 * Created by Jiri on 02/08/17.
 */

public class FoodLog {
    private boolean isFavorite;
    private String logDate;
    private long logId;
    private Food loggedFood;
    private NutritionalValues nutritionalValues;

    public boolean isFavorite() {
        return isFavorite;
    }

    public String getLogDate() {
        return logDate;
    }

    public long getLogId() {
        return logId;
    }

    public Food getLoggedFood() {
        return loggedFood;
    }

    public NutritionalValues getNutritionalValues() {
        return nutritionalValues;
    }

    public FoodLog(boolean isFavorite, String logDate, long logId, Food loggedFood, NutritionalValues nutritionalValues) {
        this.isFavorite = isFavorite;
        this.logDate = logDate;
        this.logId = logId;
        this.loggedFood = loggedFood;
        this.nutritionalValues = nutritionalValues;
    }

    @Override
    public String toString() {
        return "FoodLog{" +
                "isFavorite=" + isFavorite +
                ", logDate='" + logDate + '\'' +
                ", logId=" + logId +
                ", loggedFood=" + loggedFood +
                ", nutritionalValues=" + nutritionalValues +
                '}';
    }
}
