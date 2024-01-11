package com.example.ch8_5.to;

public class PageHandler {

    Integer pageSize;
    Integer naviSize = 10;
    Integer page;
    Integer beginPage;
    Integer endPage;
    Integer totalPage;
    boolean showPrev;
    boolean showNext;


    PageHandler(Integer page, Integer totalCnt) {
        this(page, totalCnt, 10);
    }

    PageHandler(Integer page, Integer totalCnt, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;

        totalPage = (int) Math.ceil(totalCnt / (double) pageSize);
        beginPage = (page-1) / naviSize * naviSize +1;
        endPage = Math.min(beginPage-1+naviSize, totalPage);


        showPrev = beginPage != 1;
        showNext = endPage != totalPage;

    }


    void print() {

        System.out.print(showPrev ? "[PREV]" : "");
        for (int i = beginPage; i <= endPage; i++) {
            System.out.print(i + " ");
        }
        System.out.println(showNext ? "[NEXT]" : "");

    }


}
