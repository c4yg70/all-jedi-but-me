package com.example.paper.response;

public class BasicResponse {
    private boolean succeed;
    private String msg;

    public boolean getSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BasicResponse() {
    }

    public BasicResponse(boolean succeed, String msg) {
        this.succeed = succeed;
        this.msg = msg;
    }
}
