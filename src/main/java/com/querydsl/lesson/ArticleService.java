package com.querydsl.lesson;

import com.querydsl.lesson.domain.Article;
import com.querydsl.lesson.domain.repository.ArticleQuerydslRepository;
import com.querydsl.lesson.domain.repository.ArticleRepository;
import com.querydsl.lesson.dto.ArticleCommentDto;
import com.querydsl.lesson.dto.ArticleDto;
import com.querydsl.lesson.dto.ArticleFlatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleQuerydslRepository articleQuerydslRepository;

    // 엔티티 그대로 조회
    public Article v1(Long id) {
        return articleRepository.findWithCommentById(id).orElseThrow();
    }

    // 엔티티를 조회 후 DTO로 변환
    public ArticleDto v2(Long id) {
        Article article = articleRepository.findWithCommentById(id).orElseThrow();
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .articleContents(article.getContents())
                .comments(article.getComments()
                        .stream()
                        .map(comment -> ArticleCommentDto.builder()
                                .id(comment.getId())
                                .commentContents(comment.getContents())
                                .build())
                        .collect(toList()))
                .build();
    }

    // 컬렉션 DTO를 위해 전체 데이터 조회 후 반환
    public ArticleDto v3(Long id) {
        List<ArticleFlatDto> flats = articleRepository.findDtoById(id);
        return flats.stream()
                .collect(groupingBy(articleFlatDto -> ArticleDto.builder()
                                .id(articleFlatDto.getArticleId())
                                .title(articleFlatDto.getTitle())
                                .articleContents(articleFlatDto.getArticleContents())
                                .build(),
                        mapping(articleFlatDto -> ArticleCommentDto.builder()
                                .id(articleFlatDto.getCommentId())
                                .commentContents(articleFlatDto.getCommentContents())
                                .build(), toList())
                )).entrySet().stream()
                .map(e -> ArticleDto.builder()
                        .id(e.getKey().getId())
                        .title(e.getKey().getTitle())
                        .articleContents(e.getKey().getArticleContents())
                        .comments(e.getValue())
                        .build())
                .findFirst()
                .orElseThrow();
    }

    // Querydsl로 조회
    public ArticleDto v4(Long id) {
        return articleQuerydslRepository.findWithCommentsById(id).orElseThrow();
    }
}
