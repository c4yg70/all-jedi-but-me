package com.example.paper.bl;

import com.example.paper.response.BasicResponse;

public interface LoginService {
    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    BasicResponse userSignUp(String username, String password);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    BasicResponse userLogin(String username, String password);
}
