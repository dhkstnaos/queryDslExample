package com.querydsl.sqlTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SqlTestApplicationTest {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void testGetArticleList() {
        // Native Query
        List<Article> articleList = articleRepository.findByLevel("1");

        System.out.println("--------------------------------------------------");

        // Querydsl
        List<Article> articleListByQuerydsl = articleRepository.findByLevelUsingQuerydsl("1");

        Assertions.assertEquals(articleList.size(), articleListByQuerydsl.size());
    }

}