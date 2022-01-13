package com.querydsl.lesson.domain.repository;

import com.querydsl.lesson.domain.Article;
import com.querydsl.lesson.dto.ArticleFlatDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long>{

    @Query(
            "select distinct a " +
            "from Article a " +
            "join fetch a.comments " +
            "where a.id = :id"
    )
    Optional<Article> findWithCommentById(@Param("id") Long id);

    @Query(
            "select " +
            "new com.querydsl.lesson.dto.ArticleFlatDto(a.id, a.title, a.contents, ac.id, ac.contents) " +
            "from Article a " +
            "join a.comments as ac " +
            "where a.id = :id"
    )
    List<ArticleFlatDto> findDtoById(@Param("id") Long id);
}
