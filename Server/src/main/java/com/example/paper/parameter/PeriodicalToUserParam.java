package com.example.paper.parameter;

public class PeriodicalToUserParam {
    private int periodicalId = 0;
    private String username = "";

    public int getPeriodicalId() {
        return periodicalId;
    }

    public void setPeriodicalId(int periodicalId) {
        this.periodicalId = periodicalId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PeriodicalToUserParam() {
    }

    public PeriodicalToUserParam(int periodicalId, String username) {
        this.periodicalId = periodicalId;
        this.username = username;
    }
}
