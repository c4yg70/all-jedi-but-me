package com.example.paper.bl;

import com.example.paper.response.BasicResponse;
import com.example.paper.response.PaperSimpleInfoVO;

import java.util.List;

public interface PaperListService {
    /**
     * 为一个用户的书单添加一篇论文
     * @param paperId
     * @param username
     * @return
     */
    BasicResponse addPaperToList(int paperId, String username);

    /**
     * 在一个用户的书单里删除一篇论文
     * @param paperId
     * @param username
     * @return
     */
    BasicResponse deletePaperFromList(int paperId, String username);

    /**
     * 获得一个用户的书单
     * @param username
     * @return
     */
    List<PaperSimpleInfoVO> getPaperListByUserName(String username);

    /**
     * 返回用户书单里的论文数
     * @param username
     * @return
     */
    int getPaperListCount(String username);
}
