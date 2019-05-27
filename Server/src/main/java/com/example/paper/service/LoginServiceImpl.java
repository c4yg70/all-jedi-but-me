package com.example.paper.service;

import com.example.paper.bl.LoginService;
import com.example.paper.dao.UserRepo;
import com.example.paper.entity.User;
import com.example.paper.response.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public BasicResponse userSignUp(String username, String password){
        if(userRepo.findById(username).isPresent()){
            return new BasicResponse(false,"该用户名已存在！");
        }else {
            User user = new User(username,password);
            userRepo.save(user);
            return new BasicResponse(true,"");
        }
    }

    @Override
    public BasicResponse userLogin(String username, String password){
        Optional<User> userOptional = userRepo.findById(username);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(user.getPassword().equals(password)){
                return new BasicResponse(true,"");
            }else {
                return new BasicResponse(false,"密码错误！");
            }
        }else {
            return new BasicResponse(false,"该用户名不存在！");
        }
    }

}
