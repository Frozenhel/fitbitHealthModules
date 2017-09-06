package com.anext.ihealthmodule.model;

import java.util.List;

/**
 * Created by AnextCZ on 06/09/2017.
 */

public class BloodOxygenResult extends PaginatedResult{
    private List<BloodOxygen> BODataList;

    public List<BloodOxygen> getBODataList() {
        return BODataList;
    }

    public BloodOxygenResult(String currentRecordCount, String nextPageUrl, int pageLength, int pageNumber, String prevPageUrl, int recordCount, List<BloodOxygen> BODataList) {
        super(currentRecordCount, nextPageUrl, pageLength, pageNumber, prevPageUrl, recordCount);
        this.BODataList = BODataList;
    }

    @Override
    public String toString() {
        return "BloodOxygenResult{" +
                "BODataList=" + BODataList +
                '}';
    }
}
