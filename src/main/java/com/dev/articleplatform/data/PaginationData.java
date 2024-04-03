package com.dev.articleplatform.data;

import java.io.Serializable;

public class PaginationData implements Serializable {

    private static final long serialVersionUID = 1L;

    private int page;
    private int size;
    private String sort;

    public PaginationData() {
    }

    public PaginationData(int page, int size, String sort) {
        this.page = page;
        this.size = size;
        this.sort = sort;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
