package com.example.paper.controller;

import com.example.paper.bl.PeriodicalService;
import com.example.paper.parameter.PeriodicalToUserParam;
import com.example.paper.response.BasicResponse;
import com.example.paper.response.PeriodicalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/periodical")
public class PeriodicalController {
    @Autowired
    private PeriodicalService periodicalService;

    @GetMapping(value = "/getAll")
    public List<String> getAllCategories(){
        return periodicalService.getAllCategories();
    }

    @GetMapping(value = "/category/get")
    public List<PeriodicalVO> getPeriodicalsByCategory(@RequestParam(value="category")String category){
        return periodicalService.getPeriodicalsByCategory(category);
    }

    @GetMapping(value = "/username/get")
    public List<PeriodicalVO> getPeriodicalsByUserName(@RequestParam(value="username")String username){
        return periodicalService.getPeriodicalsByUserName(username);
    }

    @PostMapping(value = "/addToUser")
    public BasicResponse addPeriodicalToUser(@RequestBody PeriodicalToUserParam param){
        return periodicalService.addPeriodicalToUser(param.getPeriodicalId(),param.getUsername());
    }

    @PostMapping(value = "/deleteFromUser")
    public BasicResponse deletePeriodicalToUser(@RequestBody PeriodicalToUserParam param){
        return periodicalService.deletePeriodicalToUser(param.getPeriodicalId(),param.getUsername());
    }

    @GetMapping(value = "/getCount")
    public int getPeriodicalCount(@RequestParam(value="username")String username){
        return periodicalService.getPeriodicalCount(username);
    }

    @GetMapping(value = "/recommend")
    public List<PeriodicalVO> recommend(@RequestParam(value="username")String username){
        return periodicalService.recommend(username);
    }
}
