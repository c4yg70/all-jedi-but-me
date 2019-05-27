package com.example.paper.bl;

import com.example.paper.response.PaperVO;

import java.util.List;

public interface SearchService {
    /**
     * 根据文献来源搜索论文
     * @param source
     * @return
     */
    List<PaperVO> getPapersBySource(String source);

    /**
     * 根据关键字严格搜索论文
     * @param keyword
     * @return
     */
    List<PaperVO> getPapersByKeyword(String keyword);
}
