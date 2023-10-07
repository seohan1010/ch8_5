package com.example.ch8_5.to;

public class SearchCondition {

    Integer offset;
    Integer PageSize;


    @Override
    public String toString() {
        return "SearchCondition{" +
                "offset=" + offset +
                ", PageSize=" + PageSize +
                '}';
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }
}
