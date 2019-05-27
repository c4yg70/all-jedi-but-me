package com.example.paper.entity;

import com.example.paper.response.PaperSimpleInfoVO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_paper")
public class Paper {
    /**
     * 唯一标识ID
     */
    @Id
    @Column
    private int id = 0;

    /**
     * 题名
     */
    @Column
    private String title = "";

    /**
     * 作者
     */
    @Column
    private String author = "";

    /**
     * 单位
     */
    @Column
    private String organ = "";

    /**
     * 文献来源
     */
    @Column
    private String source = "";

    /**
     * 关键词，用;;分隔
     */
    @Column
    private String keyword = "";

    /**
     * 摘要
     */
    @Column(columnDefinition="text")
    private String summary = "";

    /**
     * 发表时间
     */
    @Column
    private String pubTime = "";

    /**
     * 第一责任人
     */
    @Column
    private String firstDuty = "";

    /**
     * 基金，用;;分隔
     */
    @Column
    private String fund = "";

    /**
     * 年
     */
    @Column
    private String year = "";

    /**
     * 卷
     */
    @Column
    private String volume = "";

    /**
     * 期
     */
    @Column
    private String period = "";

    /**
     * 页码
     */
    @Column
    private String pageCount = "";

    /**
     * 中图分类号
     */
    @Column
    private String CLC = "";

    /**
     * 来源库
     */
    @Column
    private String srcDatabase = "";

    /**
     * 下载链接
     */
    @Column
    private String downloadUrl = "";

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

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public PaperSimpleInfoVO getPaperSimpleInfoVO(){
        return new PaperSimpleInfoVO(id,title,source,author,summary);
    }

    public Paper() {
    }

    public Paper(int id,
                 String title,
                 String author,
                 String organ,
                 String source,
                 String keyword,
                 String summary,
                 String pubTime,
                 String firstDuty,
                 String fund,
                 String year,
                 String volume,
                 String period,
                 String pageCount,
                 String CLC,
                 String srcDatabase) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.organ = organ;
        this.source = source;
        this.keyword = keyword;
        this.summary = summary;
        this.pubTime = pubTime;
        this.firstDuty = firstDuty;
        this.fund = fund;
        this.year = year;
        this.volume = volume;
        this.period = period;
        this.pageCount = pageCount;
        this.CLC = CLC;
        this.srcDatabase = srcDatabase;
    }
}
