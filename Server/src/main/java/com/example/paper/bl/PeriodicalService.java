package com.example.paper.bl;

import com.example.paper.response.BasicResponse;
import com.example.paper.response.PeriodicalVO;

import java.util.List;

public interface PeriodicalService {
    /**
     * 获得所有期刊种类的名字
     * @return
     */
    List<String> getAllCategories();

    /**
     * 按照类别获得所有期刊
     * @param category
     * @return
     */
    List<PeriodicalVO> getPeriodicalsByCategory(String category);

    /**
     * 获得某个用户收藏的所有期刊
     * @param username
     * @return
     */
    List<PeriodicalVO> getPeriodicalsByUserName(String username);

    /**
     * 用户follow期刊
     * @param periodicalId
     * @param username
     * @return
     */
    BasicResponse addPeriodicalToUser(int periodicalId, String username);

    /**
     * 用户unfollow期刊
     * @param periodicalId
     * @param username
     * @return
     */
    BasicResponse deletePeriodicalToUser(int periodicalId, String username);

    /**
     * 返回用户follow的期刊数
     * @return
     */
    int getPeriodicalCount(String username);

    /**
     * 推荐给用户的期刊
     * @param username
     * @return
     */
    List<PeriodicalVO> recommend(String username);
}
