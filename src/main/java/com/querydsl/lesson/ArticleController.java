package com.querydsl.lesson;

import com.querydsl.lesson.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/articles/{id}")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/v1")
    public ResponseEntity<Article> v1(@PathVariable Long id) {
        Article response = articleService.v1(id);
        return ResponseEntity.ok(response);
    }
}
