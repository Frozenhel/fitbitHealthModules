package com.anext.fitbitmodule.model.activity;

/**
 * Created by Jiri on 01/08/17.
 */

public class Sleep {
    private String dateOfSleep;
    private long duration;
    private int efficiency;
    private long logId;
    private int minutesAfterWakeup;
    private int minutesAsleep;
    private int minutesAwake;
    private int minutesToFallAsleep;
    private String startTime;
    private int timeInBed;
    private String type;

    public Sleep(String dateOfSleep, long duration, int efficiency, long logId, int minutesAfterWakeup, int minutesAsleep, int minutesAwake, int minutesToFallAsleep, String startTime, int timeInBed, String type) {
        this.dateOfSleep = dateOfSleep;
        this.duration = duration;
        this.efficiency = efficiency;
        this.logId = logId;
        this.minutesAfterWakeup = minutesAfterWakeup;
        this.minutesAsleep = minutesAsleep;
        this.minutesAwake = minutesAwake;
        this.minutesToFallAsleep = minutesToFallAsleep;
        this.startTime = startTime;
        this.timeInBed = timeInBed;
        this.type = type;
    }

    public String getDateOfSleep() {
        return dateOfSleep;
    }

    public long getDuration() {
        return duration;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public long getLogId() {
        return logId;
    }

    public int getMinutesAfterWakeup() {
        return minutesAfterWakeup;
    }

    public int getMinutesAsleep() {
        return minutesAsleep;
    }

    public int getMinutesAwake() {
        return minutesAwake;
    }

    public int getMinutesToFallAsleep() {
        return minutesToFallAsleep;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getTimeInBed() {
        return timeInBed;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Sleep{" +
                "dateOfSleep='" + dateOfSleep + '\'' +
                ", duration=" + duration +
                ", efficinecly=" + efficiency +
                ", logId=" + logId +
                ", minutesAfterWakeup=" + minutesAfterWakeup +
                ", minutesAsleep=" + minutesAsleep +
                ", minutesAwake=" + minutesAwake +
                ", minutesToFallAsleep=" + minutesToFallAsleep +
                ", startTime='" + startTime + '\'' +
                ", timeInBed=" + timeInBed +
                ", type='" + type + '\'' +
                '}';
    }
}
