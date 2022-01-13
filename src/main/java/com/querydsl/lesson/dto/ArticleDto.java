package com.querydsl.lesson.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Builder
public class ArticleDto {

    private Long id;
    private String title;
    private String articleContents;
    private List<ArticleCommentDto> comments;

    @QueryProjection
    public ArticleDto(Long id, String title, String articleContents, List<ArticleCommentDto> comments) {
        this.id = id;
        this.title = title;
        this.articleContents = articleContents;
        this.comments = comments;
    }
}
