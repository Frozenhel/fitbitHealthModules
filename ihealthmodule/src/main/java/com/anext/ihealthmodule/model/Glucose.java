package com.anext.ihealthmodule.model;

/**
 * Created by AnextCZ on 07/08/17.
 */

public class Glucose {
    private float BG;
    private String DataID;
    private String DinnerSituation;
    private String DrugSituation;
    private float Lat;
    private float Lon;
    private long MDate;
    private String Note;

    public float getBG() {
        return BG;
    }

    public String getDataID() {
        return DataID;
    }

    public String getDinnerSituation() {
        return DinnerSituation;
    }

    public String getDrugSituation() {
        return DrugSituation;
    }

    public float getLat() {
        return Lat;
    }

    public float getLon() {
        return Lon;
    }

    public long getMDate() {
        return MDate;
    }

    public String getNote() {
        return Note;
    }

    public Glucose(float BG, String dataID, String dinnerSituation, String drugSituation, float lat, float lon, long MDate, String note) {
        this.BG = BG;
        DataID = dataID;
        DinnerSituation = dinnerSituation;
        DrugSituation = drugSituation;
        Lat = lat;
        Lon = lon;
        this.MDate = MDate;
        Note = note;
    }

    @Override
    public String toString() {
        return "Glucose{" +
                "BG=" + BG +
                ", DataID='" + DataID + '\'' +
                ", DinnerSituation='" + DinnerSituation + '\'' +
                ", DrugSituation='" + DrugSituation + '\'' +
                ", Lat=" + Lat +
                ", Lon=" + Lon +
                ", MDate=" + MDate +
                ", Note='" + Note + '\'' +
                '}';
    }
}
