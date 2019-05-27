package com.example.paper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_statistics")
public class Statistics {
    @Id
    @Column
    private int paperId = 0;

    @Column
    private int pageviews = 0;

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public int getPageviews() {
        return pageviews;
    }

    public void setPageviews(int pageviews) {
        this.pageviews = pageviews;
    }

    public Statistics() {
    }

    public Statistics(int paperId) {
        this.paperId = paperId;
    }
}
