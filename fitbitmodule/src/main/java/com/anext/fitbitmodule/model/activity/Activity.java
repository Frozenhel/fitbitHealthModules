package com.anext.fitbitmodule.model.activity;

/**
 * Created by Jiri on 19/07/17.
 */

public class Activity {
    private int activityDuration;
    private String activityName;
    private Long activityTypeId;
    private float averageHearthRate;
    private int calories;
    private float distance;
    private String distanceUnit;
    private int duration;
    private String lastModified;
    private Long logId;
    private String logType;
    private float speed;
    private String startTime;
    private int steps;

    public Activity(int activityDuration, String activityName, Long activityTypeId, float averageHearthRate, int calories, float distance, String distanceUnit, int duration, String lastModified, Long logId, String logType, float speed, String startTime, int steps) {
        this.activityDuration = activityDuration;
        this.activityName = activityName;
        this.activityTypeId = activityTypeId;
        this.averageHearthRate = averageHearthRate;
        this.calories = calories;
        this.distance = distance;
        this.distanceUnit = distanceUnit;
        this.duration = duration;
        this.lastModified = lastModified;
        this.logId = logId;
        this.logType = logType;
        this.speed = speed;
        this.startTime = startTime;
        this.steps = steps;
    }

    public int getActivityDuration() {
        return activityDuration;
    }

    public String getActivityName() {
        return activityName;
    }

    public Long getActivityTypeId() {
        return activityTypeId;
    }

    public float getAverageHearthRate() {
        return averageHearthRate;
    }

    public int getCalories() {
        return calories;
    }

    public float getDistance() {
        return distance;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public int getDuration() {
        return duration;
    }

    public String getLastModified() {
        return lastModified;
    }

    public Long getLogId() {
        return logId;
    }

    public String getLogType() {
        return logType;
    }

    public float getSpeed() {
        return speed;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityDuration=" + activityDuration +
                ", activityName='" + activityName + '\'' +
                ", activityTypeId=" + activityTypeId +
                ", acerageHearthRate=" + averageHearthRate +
                ", calories=" + calories +
                ", distance=" + distance +
                ", distanceUnit='" + distanceUnit + '\'' +
                ", duration=" + duration +
                ", lastModified='" + lastModified + '\'' +
                ", logId=" + logId +
                ", logType='" + logType + '\'' +
                ", speed=" + speed +
                ", startTime='" + startTime + '\'' +
                ", steps=" + steps +
                '}';
    }
}
