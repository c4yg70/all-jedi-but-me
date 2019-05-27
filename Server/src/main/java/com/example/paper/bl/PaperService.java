package com.example.paper.bl;

import com.example.paper.response.BasicResponse;
import com.example.paper.response.PaperSimpleInfoVO;
import com.example.paper.response.PaperVO;

import java.util.List;

public interface PaperService {
    /**
     * 查看所有论文
     * @return
     */
    List<PaperVO> getAllPapers();

    /**
     * 根据Id查找论文
     * @param paperId
     * @return
     */
    PaperVO getPaperById(int paperId);

    /**
     * 添加一个阅读量
     * @param paperId
     * @return
     */
    BasicResponse addPageviews(int paperId);

    /**
     * 获取阅读量前10的论文
     * @return
     */
    List<PaperSimpleInfoVO> getTopTen();

    /**
     * 获取论文的下载链接
     * @param paperId
     * @return
     */
    String getDownloadUrl(int paperId);
}
