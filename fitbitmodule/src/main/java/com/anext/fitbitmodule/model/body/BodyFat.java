package com.anext.fitbitmodule.model.body;

/**
 * Created by Jiri on 26/07/17.
 */

public class BodyFat {

    private String date;	// yyyy-MM-dd.
    private float fat;	    // X.XX
    private long logId;
    private String time;	// HH:mm:ss
    private String source;

    public BodyFat(String date, float fat, long logId, String time, String source) {
        this.date = date;
        this.fat = fat;
        this.logId = logId;
        this.time = time;
        this.source = source;
    }

    public String getDate() {
        return date;
    }

    public float getFat() {
        return fat;
    }

    public long getLogId() {
        return logId;
    }

    public String getTime() {
        return time;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "BodyFat{" +
                "date='" + date + '\'' +
                ", fat=" + fat +
                ", logId=" + logId +
                ", time='" + time + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
