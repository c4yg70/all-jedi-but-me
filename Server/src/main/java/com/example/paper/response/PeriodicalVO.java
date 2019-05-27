package com.example.paper.response;

import com.example.paper.entity.Periodical;

public class PeriodicalVO {
    private int id = 0;
    private String source = "";
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

    public PeriodicalVO() {
    }

    public PeriodicalVO(Periodical periodical) {
        this.id = periodical.getId();
        this.source = periodical.getSource();
        this.category = periodical.getCategory();
    }
}
