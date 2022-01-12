package com.querydsl.lesson.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
public class Article {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ARTICLE_ID")
    private Long id;

    @OneToMany(mappedBy = "article")
    @Builder.Default
    private List<ArticleComment> comments = new ArrayList<>();

    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String contents;
}
