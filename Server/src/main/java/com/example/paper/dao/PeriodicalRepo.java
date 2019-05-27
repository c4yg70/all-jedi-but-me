package com.example.paper.dao;

import com.example.paper.entity.Periodical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodicalRepo extends JpaRepository<Periodical, Integer> {
    /**
     * 按照类别查找期刊
     * @param category
     * @return
     */
    List<Periodical> findPeriodicalByCategory(String category);
}
