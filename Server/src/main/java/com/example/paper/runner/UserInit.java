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

    private static final String TEST_PASSWORD = "123456";
    private static final String TEST_PERIODICAL_IDS = "1,6,10,11,15,17,21";

    @Override
    public void run(ApplicationArguments args) {
        User user = new User("test", TEST_PASSWORD);
        user.setPeriodicalIds("1,6,11");
        userRepo.save(user);
        user = new User("test1", TEST_PASSWORD);
        user.setPeriodicalIds(TEST_PERIODICAL_IDS);
        userRepo.save(user);
        user = new User("test2", TEST_PASSWORD);
        user.setPeriodicalIds(TEST_PERIODICAL_IDS);
        userRepo.save(user);
        user = new User("test3", TEST_PASSWORD);
        user.setPeriodicalIds(TEST_PERIODICAL_IDS);
        userRepo.save(user);
        user = new User("test4", TEST_PASSWORD);
        user.setPeriodicalIds(TEST_PERIODICAL_IDS);
        userRepo.save(user);
        user = new User("test5", TEST_PASSWORD);
        user.setPeriodicalIds(TEST_PERIODICAL_IDS);
        userRepo.save(user);
        user = new User("test6", TEST_PASSWORD);
        user.setPeriodicalIds(TEST_PERIODICAL_IDS);
        userRepo.save(user);
        user = new User("test7", TEST_PASSWORD);
        user.setPeriodicalIds(TEST_PERIODICAL_IDS);
        userRepo.save(user);
        user = new User("test8", TEST_PASSWORD);
        user.setPeriodicalIds(TEST_PERIODICAL_IDS);
        userRepo.save(user);
        user = new User("test9", TEST_PASSWORD);
        user.setPeriodicalIds(TEST_PERIODICAL_IDS);
        userRepo.save(user);

        user = new User("admin", TEST_PASSWORD);
        userRepo.save(user);
    }
}
