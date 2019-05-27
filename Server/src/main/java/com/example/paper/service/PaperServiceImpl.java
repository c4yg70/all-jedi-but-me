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
import java.util.Optional;

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
        for (Paper paper : papers) {
            paperVOS.add(new PaperVO(paper));
        }
        return paperVOS;
    }

    @Override
    public PaperVO getPaperById(int paperId){
        Paper paper;
        Optional<Paper> paperOptional = paperRepo.findById(paperId);
        if(paperOptional.isPresent()){
            paper = paperOptional.get();
            return new PaperVO(paper);
        }else {
            return null;
        }
    }

    @Override
    public BasicResponse addPageviews(int paperId){
        Optional<Statistics> statisticsOptional = statisticsRepo.findById(paperId);
        if(statisticsOptional.isPresent()){
            Statistics statistics = statisticsOptional.get();
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
            Optional<Paper> paperOptional = paperRepo.findById(statistics[i].getPaperId());
            if(paperOptional.isPresent()) {
                Paper paper = paperOptional.get();
                paperSimpleInfoVOS.add(paper.getPaperSimpleInfoVO());
            }
        }
        return paperSimpleInfoVOS;
    }

    @Override
    public String getDownloadUrl(int paperId){
        Optional<Paper> paperOptional = paperRepo.findById(paperId);
        return paperOptional.map(Paper::getDownloadUrl).orElse(null);
    }
}
