package com.anext.fitbitmodule.model.body;

import java.util.List;

/**
 * Created by Jiri on 26/07/17.
 */

public class BodyWeightResponse {
    private List<BodyWeight> weight;

    public BodyWeightResponse(List<BodyWeight> weight) {
        this.weight = weight;
    }

    public List<BodyWeight> getWeights() {
        return weight;
    }

    @Override
    public String toString() {
        return "BodyWeightResponse{" +
                "weight=" + weight +
                '}';
    }
}
