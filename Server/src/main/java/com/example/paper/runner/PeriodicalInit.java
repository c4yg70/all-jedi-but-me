package com.example.paper.runner;

import com.example.paper.dao.PeriodicalRepo;
import com.example.paper.entity.Periodical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PeriodicalInit implements ApplicationRunner {
    @Autowired
    private PeriodicalRepo periodicalRepo;

    @Override
    public void run(ApplicationArguments args) {
        Periodical periodical1 = new Periodical(1,"四川师范大学电子出版社","计算机");
        Periodical periodical2 = new Periodical(2,"中国心理卫生杂志","心理");
        Periodical periodical3 = new Periodical(3,"世界有色金属","地理");
        Periodical periodical4 = new Periodical(4,"海南大学学报(自然科学版)","自然科学");
        Periodical periodical5 = new Periodical(5,"南水北调与水利科技","地理");
        Periodical periodical6 = new Periodical(6,"电子技术与软件工程","计算机");
        Periodical periodical7 = new Periodical(7,"经营与管理","管理学");
        Periodical periodical8 = new Periodical(8,"中国现代应用药学","医学");
        Periodical periodical9 = new Periodical(9,"现代工业经济和信息化","信息");
        Periodical periodical10 = new Periodical(10,"计算机应用","计算机");
        Periodical periodical11 = new Periodical(11,"计算机工程","计算机");
        Periodical periodical12 = new Periodical(12,"新媒体研究","新媒体");
        Periodical periodical13 = new Periodical(13,"绿色环保建材","建筑学");
        Periodical periodical14 = new Periodical(14,"中国医学装备","医学");
        Periodical periodical15 = new Periodical(15,"指挥信息系统与技术","计算机");
        Periodical periodical16 = new Periodical(16,"中国机械工程","机械");
        Periodical periodical17 = new Periodical(17,"软件学报","计算机");
        Periodical periodical18 = new Periodical(18,"激光与光电子学进展","电子");
        Periodical periodical19 = new Periodical(19,"山东工业技术","工业");
        Periodical periodical20 = new Periodical(20,"信息技术","信息");
        Periodical periodical21 = new Periodical(21,"计算机产品与流通","计算机");
        Periodical periodical22 = new Periodical(22,"arXiv","计算机");

        periodicalRepo.save(periodical1);
        periodicalRepo.save(periodical2);
        periodicalRepo.save(periodical3);
        periodicalRepo.save(periodical4);
        periodicalRepo.save(periodical5);
        periodicalRepo.save(periodical6);
        periodicalRepo.save(periodical7);
        periodicalRepo.save(periodical8);
        periodicalRepo.save(periodical9);
        periodicalRepo.save(periodical10);
        periodicalRepo.save(periodical11);
        periodicalRepo.save(periodical12);
        periodicalRepo.save(periodical13);
        periodicalRepo.save(periodical14);
        periodicalRepo.save(periodical15);
        periodicalRepo.save(periodical16);
        periodicalRepo.save(periodical17);
        periodicalRepo.save(periodical18);
        periodicalRepo.save(periodical19);
        periodicalRepo.save(periodical20);
        periodicalRepo.save(periodical21);
        periodicalRepo.save(periodical22);
    }

}
