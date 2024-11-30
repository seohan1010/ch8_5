package com.example.ch8_5.to;

public class PageHandler {

    private SearchCondition sc;

    private Integer pageSize;
    private Integer naviSize = 10;
    private Integer page;
    private Integer beginPage;
    private Integer endPage;
    private Integer totalPage;
    private boolean showPrev;
    private boolean showNext;

    PageHandler() {
    }

    public PageHandler(Long totalCnt, SearchCondition sc) {
        this.sc = sc;
        doPaging(sc.getPage(), totalCnt, sc.getPageSize());
    }

    void doPaging(Integer page, Long totalCnt, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;

        totalPage = (int) Math.ceil(totalCnt / (double) pageSize);
        beginPage = ((page - 1) / naviSize) * naviSize + 1;
        endPage = Math.min(beginPage - 1 + naviSize, totalPage);

        showPrev = beginPage != 1;
        showNext = endPage != totalPage;

    }


    void print() {

        System.out.print(showPrev ? "[PREV]" : "");
        for (int i = beginPage; i <= endPage; i++) {
            System.out.print(i + " ");
        }
        System.out.println(showNext ? "[NEXT]" : "");
        System.out.println("page = " + page);
    }


    public SearchCondition getSc() {
        return sc;
    }

    public void setSc(SearchCondition sc) {
        this.sc = sc;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(Integer naviSize) {
        this.naviSize = naviSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(Integer beginPage) {
        this.beginPage = beginPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }
}
