package com.anext.ihealthmodule.model;

import java.util.List;

/**
 * Created by AnextCZ on 07/08/17.
 */

public class BloodPressureResult extends PaginatedResult{
    private List<BloodPressure> BPDataList;
    private int BPUnit;

    public List<BloodPressure> getBPDataList() {
        return BPDataList;
    }

    public int getBPUnit() {
        return BPUnit;
    }

    public BloodPressureResult(String currentRecordCount, String nextPageUrl, int pageLength, int pageNumber, String prevPageUrl, int recordCount, List<BloodPressure> BPDataList, int BPUnit) {
        super(currentRecordCount, nextPageUrl, pageLength, pageNumber, prevPageUrl, recordCount);
        this.BPDataList = BPDataList;
        this.BPUnit = BPUnit;
    }

    @Override
    public String toString() {
        return "BloodPressureResult{" +
                "BPDataList=" + BPDataList +
                ", BPUnit=" + BPUnit +
                '}';
    }
}
