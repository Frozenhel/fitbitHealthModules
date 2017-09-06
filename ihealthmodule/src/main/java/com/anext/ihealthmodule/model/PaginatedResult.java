package com.anext.ihealthmodule.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by Jiri on 04/08/17.
 */

public abstract class PaginatedResult {
    private String CurrentRecordCount;
    private String NextPageUrl;
    private int PageLength;
    private int PageNumber;
    private String PrevPageUrl;
    private int RecordCount;

    public PaginatedResult(String currentRecordCount, String nextPageUrl, int pageLength, int pageNumber, String prevPageUrl, int recordCount) {
        CurrentRecordCount = currentRecordCount;
        NextPageUrl = nextPageUrl;
        PageLength = pageLength;
        PageNumber = pageNumber;
        PrevPageUrl = prevPageUrl;
        RecordCount = recordCount;
    }

    public String getCurrentRecordCount() {
        return CurrentRecordCount;
    }

    public String getNextPageUrl() {
        return NextPageUrl;
    }

    public String getNextPageUrlDecoded(){
        try {
            return URLDecoder.decode(NextPageUrl ,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public int getPageLength() {
        return PageLength;
    }

    public int getPageNumber() {
        return PageNumber;
    }

    public String getPrevPageUrl() {
        return PrevPageUrl;
    }

    public int getRecordCount() {
        return RecordCount;
    }

    @Override
    public String toString() {
        return "PaginatedResult{" +
                "CurrentRecordCount='" + CurrentRecordCount + '\'' +
                ", NextPageUrl='" + NextPageUrl + '\'' +
                ", PageLength=" + PageLength +
                ", PageNumber=" + PageNumber +
                ", PrevPageUrl='" + PrevPageUrl + '\'' +
                ", RecordCount=" + RecordCount +
                '}';
    }
}
