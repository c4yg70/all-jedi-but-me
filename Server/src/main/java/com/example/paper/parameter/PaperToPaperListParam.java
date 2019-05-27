package com.example.paper.parameter;

public class PaperToPaperListParam {
    private int paperId = 0;
    private String username = "";

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PaperToPaperListParam() {
    }

    public PaperToPaperListParam(int paperId, String username) {
        this.paperId = paperId;
        this.username = username;
    }
}
