package com.querydsl.lesson;

import com.querydsl.lesson.domain.Article;
import com.querydsl.lesson.domain.repository.ArticleRepository;
import com.querydsl.lesson.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article v1(Long id) {
        return articleRepository.findWithCommentById(id).orElseThrow();
    }

    public ArticleDto v2(Long id) {
        return articleRepository.findWithCommentByIdDto(id).orElseThrow();
    }
}
