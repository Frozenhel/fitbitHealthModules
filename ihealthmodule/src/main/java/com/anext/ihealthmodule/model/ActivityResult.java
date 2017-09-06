package com.anext.ihealthmodule.model;

import java.util.List;

/**
 * Created by Jiri on 04/08/17.
 */

public class ActivityResult extends PaginatedResult{
    private List<Activity> ARDataList;

    public ActivityResult(String currentRecordCount, String nextPageUrl, int pageLength, int pageNumber, String prevPageUrl, int recordCount, List<Activity> ARDataList) {
        super(currentRecordCount, nextPageUrl, pageLength, pageNumber, prevPageUrl, recordCount);
        this.ARDataList = ARDataList;
    }

    public List<Activity> getARDataList() {
        return ARDataList;
    }

    @Override
    public String toString() {
        return "ActivityResult{" +
                "ARDataList=" + ARDataList +
                '}';
    }
}
