package com.querydsl.sqlTest;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public List<Article> findByLevelUsingQuerydsl(String level) {
        // Q클래스를 이용한다.
        QArticle article = QArticle.article;
        QUser user = QUser.user;

        return queryFactory.selectFrom(article)
                .where(
                        article.userId.in(
                                JPAExpressions
                                        .select(user.id)
                                        .from(user)
                                        .where(user.level.gt(level))
                        )
                )
                .fetch();
    }
}