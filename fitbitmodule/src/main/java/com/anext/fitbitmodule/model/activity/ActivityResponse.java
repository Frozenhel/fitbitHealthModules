package com.anext.fitbitmodule.model.activity;

import com.anext.fitbitmodule.model.Pagination;

import java.util.List;

/**
 * Created by Jiri on 01/08/17.
 */

public class ActivityResponse {
    private List<Activity> activities;
    private Pagination pagination;

    public ActivityResponse(List<Activity> activities, Pagination pagination) {
        this.activities = activities;
        this.pagination = pagination;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public Pagination getPagination() {
        return pagination;
    }

    @Override
    public String toString() {
        return "ActivityResponse{" +
                "activities=" + activities +
                ", pagination=" + pagination +
                '}';
    }
}
