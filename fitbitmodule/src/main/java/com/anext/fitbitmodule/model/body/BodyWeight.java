package com.anext.fitbitmodule.model.body;

/**
 * Created by Jiri on 26/07/17.
 */

public class BodyWeight {
    private float bmi;
    private String date;
    private long logId;
    private String time;
    private float weight;
    private String source;

    public BodyWeight(float bmi, String date, long logId, String time, float weight, String source) {
        this.bmi = bmi;
        this.date = date;
        this.logId = logId;
        this.time = time;
        this.weight = weight;
        this.source = source;
    }

    public float getBmi() {
        return bmi;
    }

    public String getDate() {
        return date;
    }

    public long getLogId() {
        return logId;
    }

    public String getTime() {
        return time;
    }

    public float getWeight() {
        return weight;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "BodyWeight{" +
                "bmi=" + bmi +
                ", date='" + date + '\'' +
                ", logId=" + logId +
                ", time='" + time + '\'' +
                ", weight=" + weight +
                ", source='" + source + '\'' +
                '}';
    }
}
