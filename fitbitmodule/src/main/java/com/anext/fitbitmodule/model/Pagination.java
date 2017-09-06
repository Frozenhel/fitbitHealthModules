package com.anext.fitbitmodule.model;

/**
 * Created by Jiri on 01/08/17.
 */

public class Pagination {
    private String beforeDate;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private String sort;

    public Pagination(String beforeDate, int limit, String next, int offset, String previous, String sort) {
        this.beforeDate = beforeDate;
        this.limit = limit;
        this.next = next;
        this.offset = offset;
        this.previous = previous;
        this.sort = sort;
    }

    public String getBeforeDate() {
        return beforeDate;
    }

    public int getLimit() {
        return limit;
    }

    public String getNext() {
        return next;
    }

    public int getOffset() {
        return offset;
    }

    public String getPrevious() {
        return previous;
    }

    public String getSort() {
        return sort;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "beforeDate='" + beforeDate + '\'' +
                ", limit=" + limit +
                ", next='" + next + '\'' +
                ", offset=" + offset +
                ", previous='" + previous + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
