package com.example.paper.controller;

import com.example.paper.bl.PaperService;
import com.example.paper.response.BasicResponse;
import com.example.paper.response.PaperSimpleInfoVO;
import com.example.paper.response.PaperVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/paper")
public class PaperController {
    @Autowired
    private PaperService paperService;

    @GetMapping(value = "/getAll")
    public List<PaperVO> getAllPapers(){
        return paperService.getAllPapers();
    }

    @GetMapping(value = "/getTarget")
    public PaperVO getPaperById(@RequestParam(value="paperId")int paperId){
        return paperService.getPaperById(paperId);
    }

    @PostMapping(value = "/addPageviews")
    public BasicResponse addPageviews(@RequestParam(value="paperId")int paperId){
        return paperService.addPageviews(paperId);
    }

    @GetMapping(value = "/getTopTen")
    public List<PaperSimpleInfoVO> getTopTen(){
        return paperService.getTopTen();
    }

    @GetMapping(value = "/getDownloadUrl")
    public String getDownloadUrl(@RequestParam(value="paperId")int paperId){
        return paperService.getDownloadUrl(paperId);
    }
}
