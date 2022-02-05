package com.querydsl.sqlTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer>, ArticleRepositoryCustom {
    @Query(value = "SELECT id, title, user_id FROM article WHERE user_id IN (SELECT id FROM user WHERE level > :level)", nativeQuery = true)
    List<Article> findByLevel(String level);
}