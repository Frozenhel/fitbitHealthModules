package com.anext.ihealthmodule.model;

/**
 * Created by AnextCZ on 06/09/2017.
 */

public class BloodOxygen {
    private int BO;
    private String DataID;
    private int HR;
    private float Lat;
    private float Lon;
    private long MDate;
    private String Note;
    private long LastChangeTime;
    private String DataSource;
    private String TimeZone;

    public int getBO() {
        return BO;
    }

    public String getDataID() {
        return DataID;
    }

    public int getHR() {
        return HR;
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

    public long getLastChangeTime() {
        return LastChangeTime;
    }

    public String getDataSource() {
        return DataSource;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public BloodOxygen(int BO, String dataID, int HR, float lat, float lon, long MDate, String note, long lastChangeTime, String dataSource, String timeZone) {
        this.BO = BO;
        DataID = dataID;
        this.HR = HR;
        Lat = lat;
        Lon = lon;
        this.MDate = MDate;
        Note = note;
        LastChangeTime = lastChangeTime;
        DataSource = dataSource;
        TimeZone = timeZone;
    }

    @Override
    public String toString() {
        return "BloodOxygen{" +
                "BO=" + BO +
                ", DataID='" + DataID + '\'' +
                ", HR=" + HR +
                ", Lat=" + Lat +
                ", Lon=" + Lon +
                ", MDate=" + MDate +
                ", Note='" + Note + '\'' +
                ", LastChangeTime=" + LastChangeTime +
                ", DataSource='" + DataSource + '\'' +
                ", TimeZone='" + TimeZone + '\'' +
                '}';
    }
}
