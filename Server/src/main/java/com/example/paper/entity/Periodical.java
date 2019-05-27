package com.example.paper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_periodical")
public class Periodical {
    /**
     * 唯一标识ID
     */
    @Id
    @Column
    private int id = 0;

    /**
     * 期刊来源
     */
    @Column
    private String source = "";

    /**
     * 类别
     */
    @Column
    private String category = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Periodical() {
    }

    public Periodical(int id, String source, String category) {
        this.id = id;
        this.source = source;
        this.category = category;
    }
}
