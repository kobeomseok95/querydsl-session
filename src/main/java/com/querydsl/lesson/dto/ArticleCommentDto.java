package com.querydsl.lesson.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class ArticleCommentDto {

    private Long id;
    private String commentContents;
}
