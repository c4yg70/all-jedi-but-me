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
        for(int i=0;i<papers.size();i++){
            paperVOS.add(new PaperVO(papers.get(i)));
        }
        return paperVOS;
    }

    @Override
    public List<PaperVO> getPapersByKeyword(String keyword){
        List<Paper> papers = paperRepo.findAll();
        List<PaperVO> paperVOS = new ArrayList<>();
        for(int i=0;i<papers.size();i++){
            Paper paper = papers.get(i);
            String allKeywords = paper.getKeyword();
            String[] keywordList = allKeywords.split(";;");
            for(int j=0;j<keywordList.length;j++){
                if(keywordList[j].equals(keyword)){
                    paperVOS.add(new PaperVO(paper));
                }
            }
        }
        return paperVOS;
    }
}
