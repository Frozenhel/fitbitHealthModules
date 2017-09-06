package com.anext.ihealthmodule.model;

import java.util.List;

/**
 * Created by AnextCZ on 07/08/17.
 */

public class WeightResult extends PaginatedResult{
    private List<Weight> WeightDataList;
    private int WeightUnit;

    public List<Weight> getWeightDataList() {
        return WeightDataList;
    }

    public int getWeightUnit() {
        return WeightUnit;
    }

    public WeightResult(String currentRecordCount, String nextPageUrl, int pageLength, int pageNumber, String prevPageUrl, int recordCount, List<Weight> weightDataList, int weightUnit) {
        super(currentRecordCount, nextPageUrl, pageLength, pageNumber, prevPageUrl, recordCount);
        WeightDataList = weightDataList;
        WeightUnit = weightUnit;
    }

    @Override
    public String toString() {
        return "WeightResult{" +
                "WeightDataList=" + WeightDataList +
                ", WeightUnit=" + WeightUnit +
                '}';
    }
}
