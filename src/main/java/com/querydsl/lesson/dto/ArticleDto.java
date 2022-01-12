package com.querydsl.lesson.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class ArticleDto {

    private final Long id;
    private final String title;
    private final String articleContents;
    private final List<ArticleCommentDto> articleCommentDtos;
}
