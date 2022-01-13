package com.querydsl.lesson.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.querydsl.lesson.dto.QArticleCommentDto is a Querydsl Projection type for ArticleCommentDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QArticleCommentDto extends ConstructorExpression<ArticleCommentDto> {

    private static final long serialVersionUID = -389080419L;

    public QArticleCommentDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> commentContents) {
        super(ArticleCommentDto.class, new Class<?>[]{long.class, String.class}, id, commentContents);
    }

}

