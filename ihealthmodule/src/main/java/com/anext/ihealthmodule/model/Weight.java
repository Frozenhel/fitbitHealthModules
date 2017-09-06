package com.anext.ihealthmodule.model;

/**
 * Created by AnextCZ on 07/08/17.
 */

public class Weight {
    private float BMI;
    private float BoneValue;
    private float DCI;
    private String DataID;
    private float FatValue;
    private long LastChangeTime;
    private long MDate;
    private float MuscaleValue;
    private String Note;
    private float WaterValue;
    private float WeightValue;

    public float getBMI() {
        return BMI;
    }

    public float getBoneValue() {
        return BoneValue;
    }

    public float getDCI() {
        return DCI;
    }

    public String getDataID() {
        return DataID;
    }

    public float getFatValue() {
        return FatValue;
    }

    public long getLastChangeTime() {
        return LastChangeTime;
    }

    public long getMDate() {
        return MDate;
    }

    public float getMuscaleValue() {
        return MuscaleValue;
    }

    public String getNote() {
        return Note;
    }

    public float getWaterValue() {
        return WaterValue;
    }

    public float getWeightValue() {
        return WeightValue;
    }

    public Weight(float BMI, float boneValue, float DCI, String dataID, float fatValue, long lastChangeTime, long MDate, float muscaleValue, String note, float waterValue, float weightValue) {
        this.BMI = BMI;
        BoneValue = boneValue;
        this.DCI = DCI;
        DataID = dataID;
        FatValue = fatValue;
        LastChangeTime = lastChangeTime;
        this.MDate = MDate;
        MuscaleValue = muscaleValue;
        Note = note;
        WaterValue = waterValue;
        WeightValue = weightValue;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "BMI=" + BMI +
                ", BoneValue=" + BoneValue +
                ", DCI=" + DCI +
                ", DataID='" + DataID + '\'' +
                ", FatValue=" + FatValue +
                ", LastChangeTime=" + LastChangeTime +
                ", MDate=" + MDate +
                ", MuscaleValue=" + MuscaleValue +
                ", Note='" + Note + '\'' +
                ", WaterValue=" + WaterValue +
                ", WeightValue=" + WeightValue +
                '}';
    }
}
