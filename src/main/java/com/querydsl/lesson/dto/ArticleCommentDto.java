package com.querydsl.lesson.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Builder
public class ArticleCommentDto {

    private Long id;
    private String commentContents;

    @QueryProjection
    public ArticleCommentDto(Long id, String commentContents) {
        this.id = id;
        this.commentContents = commentContents;
    }
}
