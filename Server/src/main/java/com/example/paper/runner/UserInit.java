package com.example.paper.runner;

import com.example.paper.dao.UserRepo;
import com.example.paper.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UserInit implements ApplicationRunner {
    @Autowired
    private UserRepo userRepo;

    @Override
    public void run(ApplicationArguments args) {
        User user = new User("test","123456");
        user.setPeriodicalIds("1,6,11");
        userRepo.save(user);
        user = new User("test1","123456");
        user.setPeriodicalIds("1,6,10,11,15,17,21");
        userRepo.save(user);
        user = new User("test2","123456");
        user.setPeriodicalIds("1,6,10,11,15,17,21");
        userRepo.save(user);
        user = new User("test3","123456");
        user.setPeriodicalIds("1,6,10,11,15,17,21");
        userRepo.save(user);
        user = new User("test4","123456");
        user.setPeriodicalIds("1,6,10,11,15,17,21");
        userRepo.save(user);
        user = new User("test5","123456");
        user.setPeriodicalIds("1,6,10,11,15,17,21");
        userRepo.save(user);
        user = new User("test6","123456");
        user.setPeriodicalIds("1,6,10,11,15,17,21");
        userRepo.save(user);
        user = new User("test7","123456");
        user.setPeriodicalIds("1,6,10,11,15,17,21");
        userRepo.save(user);
        user = new User("test8","123456");
        user.setPeriodicalIds("1,6,10,11,15,17,21");
        userRepo.save(user);
        user = new User("test9","123456");
        user.setPeriodicalIds("1,6,10,11,15,17,21");
        userRepo.save(user);

        user = new User("admin","123456");
        userRepo.save(user);
    }
}
