package com.querydsl.lesson.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.lesson.dto.ArticleDto;
import com.querydsl.lesson.dto.QArticleCommentDto;
import com.querydsl.lesson.dto.QArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static com.querydsl.lesson.domain.QArticle.article;
import static com.querydsl.lesson.domain.QArticleComment.articleComment;

@Repository
@RequiredArgsConstructor
public class ArticleQuerydslRepository {

    private final JPAQueryFactory queryFactory;

    public Optional<ArticleDto> findWithCommentsById(Long id) {
        return Optional.ofNullable(queryFactory
                .from(article)
                .join(article.comments, articleComment)
                .where(article.id.eq(id))
                .transform(groupBy(article.id).as(new QArticleDto(
                        article.id,
                        article.title,
                        article.contents,
                        list(new QArticleCommentDto(
                                articleComment.id,
                                articleComment.contents
                        ))))).get(id));
    }
}
