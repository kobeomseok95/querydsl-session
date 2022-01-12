package com.querydsl.lesson.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
public class ArticleImage {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ARTICLE_IMAGE_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ARTICLE_ID", nullable = false)
    @JsonIgnore
    private Article article;

    @Column(length = 300, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String url;

    @Column(nullable = false)
    private Integer orders;
}
