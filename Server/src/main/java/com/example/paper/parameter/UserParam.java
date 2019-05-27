package com.example.paper.parameter;

public class UserParam {
    private String username = "";
    private String password = "";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserParam() {
    }

    public UserParam(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
