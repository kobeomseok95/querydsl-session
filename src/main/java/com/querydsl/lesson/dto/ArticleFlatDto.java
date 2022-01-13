package com.querydsl.lesson.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public class ArticleFlatDto {

    private Long articleId;
    private String title;
    private String articleContents;
    private Long commentId;
    private String commentContents;
}
