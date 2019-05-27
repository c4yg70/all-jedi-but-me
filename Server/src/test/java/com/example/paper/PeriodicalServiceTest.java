package com.example.paper;

import com.example.paper.bl.PeriodicalService;
import com.example.paper.response.BasicResponse;
import com.example.paper.response.PeriodicalVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class PeriodicalServiceTest extends PaperApplicationTests{
    @Autowired
    private PeriodicalService periodicalService;

    @Test
    public void testLoginService1(){
        List<String> allcategories = new ArrayList<>();
        allcategories.add("计算机");
        allcategories.add("心理");
        allcategories.add("地理");
        allcategories.add("自然科学");
        allcategories.add("管理学");
        allcategories.add("医学");
        allcategories.add("信息");
        allcategories.add("新媒体");
        allcategories.add("建筑学");
        allcategories.add("机械");
        allcategories.add("电子");
        allcategories.add("工业");
        List<String> categories = periodicalService.getAllCategories();
        Assert.assertEquals(allcategories,categories);
    }

    @Test
    public void testLoginService2(){
        List<PeriodicalVO> periodicalVOS = periodicalService.getPeriodicalsByCategory("工业");
        Assert.assertEquals(1,periodicalVOS.size());
        Assert.assertEquals(19,periodicalVOS.get(0).getId());
        Assert.assertEquals("山东工业技术",periodicalVOS.get(0).getSource());
        Assert.assertEquals("工业",periodicalVOS.get(0).getCategory());
    }

    @Test
    public void testLoginService3(){
        periodicalService.addPeriodicalToUser(1,"admin");
        Assert.assertEquals(1,periodicalService.getPeriodicalCount("admin"));

        List<PeriodicalVO> periodicalVOS = periodicalService.getPeriodicalsByUserName("admin");
        Assert.assertEquals(1,periodicalVOS.size());
        Assert.assertEquals("计算机",periodicalVOS.get(0).getCategory());
        Assert.assertEquals("四川师范大学电子出版社",periodicalVOS.get(0).getSource());

        periodicalService.addPeriodicalToUser(12,"admin");
        Assert.assertEquals(2,periodicalService.getPeriodicalCount("admin"));

        periodicalService.deletePeriodicalToUser(1,"admin");
        Assert.assertEquals(1,periodicalService.getPeriodicalCount("admin"));
    }

    @Test
    public void testLoginService4(){
        BasicResponse basicResponse = periodicalService.addPeriodicalToUser(1,"admin1");
        Assert.assertFalse(basicResponse.getSucceed());
        Assert.assertEquals("该用户名不存在！",basicResponse.getMsg());

        basicResponse = periodicalService.addPeriodicalToUser(12,"admin");
        Assert.assertFalse(basicResponse.getSucceed());
        Assert.assertEquals("该期刊已被收藏！",basicResponse.getMsg());

        basicResponse = periodicalService.deletePeriodicalToUser(12,"admin1");
        Assert.assertFalse(basicResponse.getSucceed());
        Assert.assertEquals("该用户名不存在！",basicResponse.getMsg());

        basicResponse = periodicalService.deletePeriodicalToUser(1,"admin");
        Assert.assertFalse(basicResponse.getSucceed());
        Assert.assertEquals("该期刊未被收藏！",basicResponse.getMsg());

        periodicalService.deletePeriodicalToUser(12,"admin");
        Assert.assertEquals(0,periodicalService.getPeriodicalCount("admin"));
    }
}
