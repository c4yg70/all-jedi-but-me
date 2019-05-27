package com.example.paper;

import com.example.paper.bl.LoginService;
import com.example.paper.dao.UserRepo;
import com.example.paper.entity.User;
import com.example.paper.response.BasicResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LoginServiceTest extends PaperApplicationTests{
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserRepo userRepo;

    @Test
    public void testLoginService1(){
        loginService.userSignUp("admin","123456");
        User user = userRepo.findById("admin").get();
        Assert.assertEquals("123456",user.getPassword());

        BasicResponse basicResponse = loginService.userLogin("admin","123456");
        Assert.assertTrue(basicResponse.getSucceed());

        basicResponse = loginService.userSignUp("admin","123456789");
        Assert.assertFalse(basicResponse.getSucceed());
        Assert.assertEquals("该用户名已存在！",basicResponse.getMsg());

        basicResponse = loginService.userLogin("admin","123456789");
        Assert.assertFalse(basicResponse.getSucceed());
        Assert.assertEquals("密码错误！",basicResponse.getMsg());
    }

    @Test
    public void testLoginService2(){
        BasicResponse basicResponse = loginService.userLogin("adminn","123456789");
        Assert.assertFalse(basicResponse.getSucceed());
        Assert.assertEquals("该用户名不存在！",basicResponse.getMsg());
    }
}
