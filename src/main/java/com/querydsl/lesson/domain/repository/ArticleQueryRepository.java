package com.querydsl.lesson.domain.repository;

import com.querydsl.lesson.dto.ArticleDto;

import java.util.Optional;

public interface ArticleQueryRepository {

    Optional<ArticleDto> findWithCommentByIdDto(Long id);
}
