package com.anext.fitbitmodule.model.activity;

/**
 * Created by Jiri on 01/08/17.
 */

public class SleepLogResponse {
    private Sleep sleep;

    public SleepLogResponse(Sleep sleep) {
        this.sleep = sleep;
    }

    public Sleep getSleep() {
        return sleep;
    }

    @Override
    public String toString() {
        return "SleepLogResponse{" +
                "sleep=" + sleep +
                '}';
    }
}
