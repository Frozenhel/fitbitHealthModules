package com.anext.fitbitmodule.enums;

/**
 * Created by Jiri on 02/08/17.
 */

public enum MealType {
    BREAKFAST(1),
    MORNING_SNACK(2),
    LUNCH(3),
    AFTERNOON_SNACK(4),
    DINNER(5),
    ANYTIME(7);

    private int value;

    MealType(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
