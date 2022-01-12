package com.querydsl.lesson.domain.repository;

import com.querydsl.lesson.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ArticleRepository
        extends JpaRepository<Article, Long>,
        ArticleQueryRepository {

    @Query(
            "select distinct a " +
            "from Article a " +
            "join fetch a.comments " +
            "where a.id = :id"
    )
    Optional<Article> findWithCommentById(@Param("id") Long id);
}
