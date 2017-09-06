package com.anext.ihealthmodule.model;

/**
 * Created by AnextCZ on 07/08/17.
 */

public class BloodPressure {
    private int BPL;
    private String DataID;
    private int HP;
    private int HR;
    private int IsArr;
    private int LP;
    private long LastChangeTime;
    private float Lat;
    private float Lon;
    private long MDate;
    private String Note;

    public int getBPL() {
        return BPL;
    }

    public String getDataID() {
        return DataID;
    }

    public int getHP() {
        return HP;
    }

    public int getHR() {
        return HR;
    }

    public int getIsArr() {
        return IsArr;
    }

    public int getLP() {
        return LP;
    }

    public long getLastChangeTime() {
        return LastChangeTime;
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

    public BloodPressure(int BPL, String dataID, int HP, int HR, int isArr, int LP, long lastChangeTime, float lat, float lon, long MDate, String note) {
        this.BPL = BPL;
        DataID = dataID;
        this.HP = HP;
        this.HR = HR;
        IsArr = isArr;
        this.LP = LP;
        LastChangeTime = lastChangeTime;
        Lat = lat;
        Lon = lon;
        this.MDate = MDate;
        Note = note;
    }

    @Override
    public String toString() {
        return "BloodPressure{" +
                "BPL=" + BPL +
                ", DataID='" + DataID + '\'' +
                ", HP=" + HP +
                ", HR=" + HR +
                ", IsArr=" + IsArr +
                ", LP=" + LP +
                ", LastChangeTime=" + LastChangeTime +
                ", Lat=" + Lat +
                ", Lon=" + Lon +
                ", MDate=" + MDate +
                ", Note='" + Note + '\'' +
                '}';
    }
}
