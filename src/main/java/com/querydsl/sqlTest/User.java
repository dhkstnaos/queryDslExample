package com.querydsl.sqlTest;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    private Integer id;
    private String name;
    private String level;
}