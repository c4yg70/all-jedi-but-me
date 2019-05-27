package com.example.paper.dao;

import com.example.paper.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepo extends JpaRepository<Statistics, Integer> {
}
