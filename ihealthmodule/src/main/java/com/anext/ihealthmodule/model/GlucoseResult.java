package com.anext.ihealthmodule.model;

import java.util.List;

/**
 * Created by AnextCZ on 07/08/17.
 */

public class GlucoseResult extends PaginatedResult{
    private List<Glucose> BGDataList;
    private int BGUnit;

    public List<Glucose> getBGDataList() {
        return BGDataList;
    }

    public int getBGUnit() {
        return BGUnit;
    }

    public GlucoseResult(String currentRecordCount, String nextPageUrl, int pageLength, int pageNumber, String prevPageUrl, int recordCount, List<Glucose> BGDataList, int BGUnit) {
        super(currentRecordCount, nextPageUrl, pageLength, pageNumber, prevPageUrl, recordCount);
        this.BGDataList = BGDataList;
        this.BGUnit = BGUnit;
    }

    @Override
    public String toString() {
        return "GlucoseResult{" +
                "BGDataList=" + BGDataList +
                ", BGUnit=" + BGUnit +
                '}';
    }
}
