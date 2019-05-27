package com.example.paper.service;

import com.example.paper.bl.SearchService;
import com.example.paper.dao.PaperRepo;
import com.example.paper.entity.Paper;
import com.example.paper.response.PaperVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private PaperRepo paperRepo;

    @Override
    public List<PaperVO> getPapersBySource(String source){
        List<Paper> papers = paperRepo.findPaperBySource(source);
        List<PaperVO> paperVOS = new ArrayList<>();
        for (Paper paper : papers) {
            paperVOS.add(new PaperVO(paper));
        }
        return paperVOS;
    }

    @Override
    public List<PaperVO> getPapersByKeyword(String keyword){
        List<Paper> papers = paperRepo.findAll();
        List<PaperVO> paperVOS = new ArrayList<>();
        for (Paper paper : papers) {
            String allKeywords = paper.getKeyword();
            String[] keywordList = allKeywords.split(";;");
            for (String aKeywordList : keywordList) {
                if (aKeywordList.equals(keyword)) {
                    paperVOS.add(new PaperVO(paper));
                }
            }
        }
        return paperVOS;
    }
}
