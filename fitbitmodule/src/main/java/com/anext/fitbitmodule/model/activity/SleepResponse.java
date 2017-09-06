package com.anext.fitbitmodule.model.activity;

import com.anext.fitbitmodule.model.Pagination;

import java.util.List;

/**
 * Created by Jiri on 01/08/17.
 */

public class SleepResponse {
    private Pagination pagination;
    private List<Sleep> sleep;

    public SleepResponse(Pagination pagination, List<Sleep> sleep) {
        this.pagination = pagination;
        this.sleep = sleep;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public List<Sleep> getSleep() {
        return sleep;
    }

    @Override
    public String toString() {
        return "SleepResponse{" +
                "pagination=" + pagination +
                ", sleep=" + sleep +
                '}';
    }
}
