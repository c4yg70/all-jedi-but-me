package com.example.paper.response;

import com.example.paper.entity.Paper;

public class PaperVO {
    private int id = 0;
    private String title = "";
    private String author = "";
    private String organ = "";
    private String source = "";
    private String keyword = "";
    private String summary = "";
    private String pubTime = "";
    private String firstDuty = "";
    private String fund = "";
    private String year = "";
    private String volume = "";
    private String period = "";
    private String pageCount = "";
    private String CLC = "";
    private String srcDatabase = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getFirstDuty() {
        return firstDuty;
    }

    public void setFirstDuty(String firstDuty) {
        this.firstDuty = firstDuty;
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getCLC() {
        return CLC;
    }

    public void setCLC(String CLC) {
        this.CLC = CLC;
    }

    public String getSrcDatabase() {
        return srcDatabase;
    }

    public void setSrcDatabase(String srcDatabase) {
        this.srcDatabase = srcDatabase;
    }

    public PaperVO() {
    }

    public PaperVO(Paper paper) {
        this.id = paper.getId();
        this.title = paper.getTitle();
        this.author = paper.getAuthor();
        this.organ = paper.getOrgan();
        this.source = paper.getSource();
        this.keyword = paper.getKeyword();
        this.summary = paper.getSummary();
        this.pubTime = paper.getPubTime();
        this.firstDuty = paper.getFirstDuty();
        this.fund = paper.getFund();
        this.year = paper.getYear();
        this.volume = paper.getVolume();
        this.period = paper.getPeriod();
        this.pageCount = paper.getPageCount();
        this.CLC = paper.getCLC();
        this.srcDatabase = paper.getSrcDatabase();
    }
}
