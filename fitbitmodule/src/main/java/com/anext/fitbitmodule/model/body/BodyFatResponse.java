package com.anext.fitbitmodule.model.body;

import java.util.List;

/**
 * Created by Jiri on 26/07/17.
 */

public class BodyFatResponse {
    private List<BodyFat> fat;

    public BodyFatResponse(List<BodyFat> fat) {
        this.fat = fat;
    }

    public List<BodyFat> getFat() {
        return fat;
    }

    @Override
    public String toString() {
        return "BodyFatResponse{" +
                "fat=" + fat +
                '}';
    }
}
