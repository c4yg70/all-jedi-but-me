package com.example.paper;

import com.example.paper.bl.SearchService;
import com.example.paper.response.PaperVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class SearchServiceTest extends PaperApplicationTests{
    @Autowired
    private SearchService searchService;

    @Test
    public void testLoginService1(){
        List<PaperVO> paperVOS = searchService.getPapersByKeyword("翻译研究");
        Assert.assertEquals(1,paperVOS.size());
        PaperVO paperVO = paperVOS.get(0);
        Assert.assertEquals(2,paperVO.getId());
        Assert.assertEquals("中英学术论文标题词汇特征对比分析与翻译——以计算机类学术论文词汇为例",paperVO.getTitle());
        Assert.assertEquals("四川师范大学电子出版社",paperVO.getOrgan());
        Assert.assertEquals("四川师范大学电子出版社",paperVO.getSource());
        Assert.assertEquals("学术论文;;翻译研究;;计算机",paperVO.getKeyword());
        Assert.assertEquals("随着计算机技术的发展,相关的著作、学术论文等纷纷涌现,为推动计算机技术的进步奠定了基础,同时也为从事科技英语翻译的工作人员提供了更多的空间。目前国内摘要翻译在专业词汇的英译、语法的灵活转换、语篇内容完整性上存在不足。为了充分而又准确地传达信息,译者应在科技英语翻译方法的基础上结合计算机英语的专业特点,采用文献法,描述法以及个案分析法概括分析国内摘要的语言特点以及国外摘要的语言特点,将国内摘要的中英文的语言特点以及国内英文摘要和国外英文摘要的语言特点进行对比,找出英文词汇使用上的缺陷。",paperVO.getSummary());
        Assert.assertEquals("2019-06-01",paperVO.getPubTime());
        Assert.assertEquals("王雨婷",paperVO.getFirstDuty());
        Assert.assertEquals("2019",paperVO.getYear());
        Assert.assertEquals("",paperVO.getVolume());
        Assert.assertEquals("",paperVO.getPeriod());
        Assert.assertEquals("6",paperVO.getPageCount());
        Assert.assertEquals("",paperVO.getCLC());
        Assert.assertEquals("CPFDPREP",paperVO.getSrcDatabase());
    }

    @Test
    public void testLoginService2(){
        List<PaperVO> paperVOS = searchService.getPapersBySource("世界有色金属");
        Assert.assertEquals(4,paperVOS.size());
    }
}
