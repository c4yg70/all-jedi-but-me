package com.example.paper.dao;

import com.example.paper.entity.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperRepo extends JpaRepository<Paper, Integer> {
    /**
     * 根据文献来源搜索论文
     * @param source
     * @return
     */
    List<Paper> findPaperBySource(String source);
}
