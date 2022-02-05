package com.querydsl.sqlTest;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Entity
@Table(name = "article")
public class Article {
    @Id
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    private String title;
}