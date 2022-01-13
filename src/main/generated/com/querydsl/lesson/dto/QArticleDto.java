package com.querydsl.lesson.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.querydsl.lesson.dto.QArticleDto is a Querydsl Projection type for ArticleDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QArticleDto extends ConstructorExpression<ArticleDto> {

    private static final long serialVersionUID = 783884514L;

    public QArticleDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> articleContents, com.querydsl.core.types.Expression<? extends java.util.List<ArticleCommentDto>> comments) {
        super(ArticleDto.class, new Class<?>[]{long.class, String.class, String.class, java.util.List.class}, id, title, articleContents, comments);
    }

}

