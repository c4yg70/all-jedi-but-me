package com.example.paper;

import com.example.paper.bl.PaperListService;
import com.example.paper.dao.UserRepo;
import com.example.paper.entity.User;
import com.example.paper.response.BasicResponse;
import com.example.paper.response.PaperSimpleInfoVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class PaperListServiceTest extends PaperApplicationTests{
    @Autowired
    private PaperListService paperListService;
    @Autowired
    private UserRepo userRepo;

    @Test
    public void testPaperListService1(){
        paperListService.addPaperToList(1,"admin");
        User user = userRepo.findById("admin").get();
        Assert.assertEquals("1",user.getPaperIds());
        Assert.assertEquals(1,paperListService.getPaperListCount("admin"));

        paperListService.addPaperToList(12,"admin");
        user = userRepo.findById("admin").get();
        Assert.assertEquals("1,12",user.getPaperIds());
        Assert.assertEquals(2,paperListService.getPaperListCount("admin"));

        paperListService.deletePaperFromList(1,"admin");
        user = userRepo.findById("admin").get();
        Assert.assertEquals("12",user.getPaperIds());
        Assert.assertEquals(1,paperListService.getPaperListCount("admin"));

        List<PaperSimpleInfoVO> paperSimpleInfoVOS = paperListService.getPaperListByUserName("admin");
        Assert.assertEquals(12,paperSimpleInfoVOS.get(0).getId());
        Assert.assertEquals("虚拟网络路由交换机制",paperSimpleInfoVOS.get(0).getTitle());
        Assert.assertEquals("电子技术与软件工程",paperSimpleInfoVOS.get(0).getSource());
        Assert.assertEquals("刘杰;周保群",paperSimpleInfoVOS.get(0).getAuthor());
        Assert.assertEquals("本文将基于vxlan和ospf,探讨了一种改进型的,适用于虚拟网络的ospf路由交换方式。",paperSimpleInfoVOS.get(0).getSummary());
    }

    @Test
    public void testPaperListService2(){
        BasicResponse basicResponse = paperListService.addPaperToList(12,"admin");
        Assert.assertFalse(basicResponse.getSucceed());
        Assert.assertEquals("该论文已被收藏！",basicResponse.getMsg());

        basicResponse = paperListService.addPaperToList(12,"admin1");
        Assert.assertFalse(basicResponse.getSucceed());
        Assert.assertEquals("该用户名不存在！",basicResponse.getMsg());

        basicResponse = paperListService.deletePaperFromList(12,"admin1");
        Assert.assertFalse(basicResponse.getSucceed());
        Assert.assertEquals("该用户名不存在！",basicResponse.getMsg());

        basicResponse = paperListService.deletePaperFromList(1,"admin");
        Assert.assertFalse(basicResponse.getSucceed());
        Assert.assertEquals("该论文未被收藏！",basicResponse.getMsg());

        paperListService.deletePaperFromList(12,"admin");
        User user = userRepo.findById("test").get();
        Assert.assertEquals("",user.getPaperIds());
        Assert.assertEquals(0,paperListService.getPaperListCount("admin"));
    }
}
