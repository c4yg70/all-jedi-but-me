package com.example.paper.controller;

import com.example.paper.bl.PaperListService;
import com.example.paper.parameter.PaperToPaperListParam;
import com.example.paper.response.BasicResponse;
import com.example.paper.response.PaperSimpleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/paperList")
public class PaperListController {
    @Autowired
    private PaperListService paperListService;

    @PostMapping(value = "/addPaperToList")
    public BasicResponse addPaperToList(@RequestBody PaperToPaperListParam param){
        return paperListService.addPaperToList(param.getPaperId(),param.getUsername());
    }

    @PostMapping(value = "/deletePaperFromList")
    public BasicResponse deletePaperFromList(@RequestBody PaperToPaperListParam param){
        return paperListService.deletePaperFromList(param.getPaperId(),param.getUsername());
    }

    @GetMapping(value = "/getTargetPaperList")
    public List<PaperSimpleInfoVO> getPaperListByUserNameAndPaperId(@RequestParam(value="username")String username){
        return paperListService.getPaperListByUserName(username);
    }

    @GetMapping(value = "/getCount")
    public int getPaperListCount(@RequestParam(value="username")String username){
        return paperListService.getPaperListCount(username);
    }
}
