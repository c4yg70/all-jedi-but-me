package com.example.paper.response;

public class PaperSimpleInfoVO {
    private int id = 0;
    private String title = "";
    private String source = "";
    private String author = "";
    private String summary = "";

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public PaperSimpleInfoVO() {
    }

    public PaperSimpleInfoVO(int id, String title, String source, String author, String summary) {
        this.id = id;
        this.title = title;
        this.source = source;
        this.author = author;
        this.summary = summary;
    }
}
