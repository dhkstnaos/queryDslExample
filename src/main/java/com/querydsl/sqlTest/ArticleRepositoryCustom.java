package com.querydsl.sqlTest;

import java.util.List;

public interface ArticleRepositoryCustom {
    List<Article> findByLevelUsingQuerydsl(String level);
}
