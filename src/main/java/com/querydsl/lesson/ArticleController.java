package com.querydsl.lesson;

import com.querydsl.lesson.domain.Article;
import com.querydsl.lesson.dto.ArticleDto;
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
        return ResponseEntity.ok(articleService.v1(id));
    }

    @GetMapping("/v2")
    public ResponseEntity<ArticleDto> v2(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.v2(id));
    }

    @GetMapping("/v3")
    public ResponseEntity<ArticleDto> v3(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.v3(id));
    }

    @GetMapping("/v4")
    public ResponseEntity<ArticleDto> v4(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.v4(id));
    }
}
