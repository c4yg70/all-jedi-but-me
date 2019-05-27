package com.example.paper.service;

import com.example.paper.bl.PaperService;
import com.example.paper.dao.PaperRepo;
import com.example.paper.dao.StatisticsRepo;
import com.example.paper.entity.Paper;
import com.example.paper.entity.Statistics;
import com.example.paper.response.BasicResponse;
import com.example.paper.response.PaperSimpleInfoVO;
import com.example.paper.response.PaperVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperRepo paperRepo;
    @Autowired
    private StatisticsRepo statisticsRepo;

    @Override
    public List<PaperVO> getAllPapers(){
        List<Paper> papers = paperRepo.findAll();
        List<PaperVO> paperVOS = new ArrayList<>();
        for(int i=0;i<papers.size();i++){
            paperVOS.add(new PaperVO(papers.get(i)));
        }
        return paperVOS;
    }

    @Override
    public PaperVO getPaperById(int paperId){
        Paper paper = null;
        if(paperRepo.findById(paperId).isPresent()){
            paper = paperRepo.findById(paperId).get();
            return new PaperVO(paper);
        }else {
            return null;
        }
    }

    @Override
    public BasicResponse addPageviews(int paperId){
        if(statisticsRepo.findById(paperId).isPresent()){
            Statistics statistics = statisticsRepo.findById(paperId).get();
            statistics.setPageviews(statistics.getPageviews()+1);
            statisticsRepo.save(statistics);
            return new BasicResponse(true,"");
        }else {
            return new BasicResponse(false,"该论文不存在！");
        }
    }

    @Override
    public List<PaperSimpleInfoVO> getTopTen(){
        List<Statistics> statisticsList = statisticsRepo.findAll();
        Statistics[] statistics = new Statistics[statisticsList.size()];
        for(int i=0;i<statisticsList.size();i++){
            statistics[i] = statisticsList.get(i);
        }
        for(int i=0;i<statistics.length-1;i++){
            for (int j=i+1;j<statistics.length;j++){
                if(statistics[i].getPageviews() < statistics[j].getPageviews()){
                    Statistics temp = statistics[i];
                    statistics[i] = statistics[j];
                    statistics[j] = temp;
                }
            }
        }
        List<PaperSimpleInfoVO> paperSimpleInfoVOS = new ArrayList<>();
        for(int i=0;i<10;i++){
            Paper paper = paperRepo.findById(statistics[i].getPaperId()).get();
            paperSimpleInfoVOS.add(paper.getPaperSimpleInfoVO());
        }
        return paperSimpleInfoVOS;
    }

    @Override
    public String getDownloadUrl(int paperId){
        if(paperRepo.findById(paperId).isPresent()){
            return paperRepo.findById(paperId).get().getDownloadUrl();
        }else {
            return null;
        }
    }
}
