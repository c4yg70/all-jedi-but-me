package com.example.paper.controller;

import com.example.paper.bl.SearchService;
import com.example.paper.response.PaperVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/paper/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping(value = "/source")
    public List<PaperVO> getPapersBySource(@RequestParam(value="source")String source){
        return searchService.getPapersBySource(source);
    }

    @GetMapping(value = "/keyword")
    public List<PaperVO> getPapersByKeyword(@RequestParam(value="keyword")String keyword){
        return searchService.getPapersByKeyword(keyword);
    }
}
