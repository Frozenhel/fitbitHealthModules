package com.anext.ihealthmodule.model;

import java.util.List;

/**
 * Created by AnextCZ on 07/08/17.
 */

public class SleepResult extends PaginatedResult{
    private List<Sleep> SRDataList;

    public List<Sleep> getSRDataList() {
        return SRDataList;
    }

    public SleepResult(String currentRecordCount, String nextPageUrl, int pageLength, int pageNumber, String prevPageUrl, int recordCount, List<Sleep> SRDataList) {
        super(currentRecordCount, nextPageUrl, pageLength, pageNumber, prevPageUrl, recordCount);
        this.SRDataList = SRDataList;
    }

    @Override
    public String toString() {
        return "SleepResult{" +
                "SRDataList=" + SRDataList +
                '}';
    }
}
