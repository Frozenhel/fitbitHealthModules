package com.anext.ihealthmodule.model;

/**
 * Created by AnextCZ on 07/08/17.
 */

public class Sleep {
    private int Awaken;
    private String DataID;
    private float EndTime;
    private float FellSleep;
    private float HoursSlept;
    private float Lat;
    private float Lon;
    private String Note;
    private int SleepEfficiency;
    private long StartTime;

    public int getAwaken() {
        return Awaken;
    }

    public String getDataID() {
        return DataID;
    }

    public float getEndTime() {
        return EndTime;
    }

    public float getFellSleep() {
        return FellSleep;
    }

    public float getHoursSlept() {
        return HoursSlept;
    }

    public float getLat() {
        return Lat;
    }

    public float getLon() {
        return Lon;
    }

    public String getNote() {
        return Note;
    }

    public int getSleepEfficiency() {
        return SleepEfficiency;
    }

    public long getStartTime() {
        return StartTime;
    }

    public Sleep(int awaken, String dataID, float endTime, float fellSleep, float hoursSlept, float lat, float lon, String note, int sleepEfficiency, long startTime) {
        Awaken = awaken;
        DataID = dataID;
        EndTime = endTime;
        FellSleep = fellSleep;
        HoursSlept = hoursSlept;
        Lat = lat;
        Lon = lon;
        Note = note;
        SleepEfficiency = sleepEfficiency;
        StartTime = startTime;
    }

    @Override
    public String toString() {
        return "Sleep{" +
                "Awaken=" + Awaken +
                ", DataID='" + DataID + '\'' +
                ", EndTime=" + EndTime +
                ", FellSleep=" + FellSleep +
                ", HoursSlept=" + HoursSlept +
                ", Lat=" + Lat +
                ", Lon=" + Lon +
                ", Note='" + Note + '\'' +
                ", SleepEfficiency=" + SleepEfficiency +
                ", StartTime=" + StartTime +
                '}';
    }
}
