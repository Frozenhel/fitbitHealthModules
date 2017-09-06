package com.anext.ihealthmodule.model;

/**
 * Created by Jiri on 02/08/17.
 */

public class Activity{
    private int Calories;
    private String DataID;
    private float DistanceTraveled;
    private float Lat;
    private float Lon;
    private Long MDate;
    private String Note;
    private int Steps;

    public Activity(int calories, String dataID, float distanceTraveled, float lat, float lon, Long MDate, String note, int steps) {
        Calories = calories;
        DataID = dataID;
        DistanceTraveled = distanceTraveled;
        Lat = lat;
        Lon = lon;
        this.MDate = MDate;
        Note = note;
        Steps = steps;
    }

    public int getCalories() {
        return Calories;
    }

    public String getDataID() {
        return DataID;
    }

    public float getDistanceTraveled() {
        return DistanceTraveled;
    }

    public float getLat() {
        return Lat;
    }

    public float getLon() {
        return Lon;
    }

    public Long getMDate() {
        return MDate;
    }

    public String getNote() {
        return Note;
    }

    public int getSteps() {
        return Steps;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "Calories=" + Calories +
                ", DataID='" + DataID + '\'' +
                ", DistanceTraveled=" + DistanceTraveled +
                ", Lat=" + Lat +
                ", Lon=" + Lon +
                ", MDate=" + MDate +
                ", Note='" + Note + '\'' +
                ", Steps=" + Steps +
                '}';
    }
}

