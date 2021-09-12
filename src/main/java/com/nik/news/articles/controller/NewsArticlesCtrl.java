package com.nik.news.articles.controller;

/* Copyright 2017 Nikesh Pathak
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */

import com.nik.news.articles.dto.NewsArticlesDTO;
import com.nik.news.articles.service.NewsArticlesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsArticlesCtrl {

    final NewsArticlesService newsArticlesService;

    public NewsArticlesCtrl(NewsArticlesService newsArticlesService) {
        this.newsArticlesService = newsArticlesService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> addArticles(@Valid @RequestBody NewsArticlesDTO newsArticlesDTO) {
        newsArticlesService.add(newsArticlesDTO);
        return ResponseEntity.status(201).build();
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<String> updateArticles(@Valid @RequestBody NewsArticlesDTO newsArticlesDTO) {
        newsArticlesService.update(newsArticlesDTO);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteArticles(@PathVariable long id) {
        newsArticlesService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<NewsArticlesDTO> getArticles(@PathVariable long id) {
        return ResponseEntity.ok(newsArticlesService.get(id));
    }

    @GetMapping(value = "/betweenDate")
    public ResponseEntity<List<NewsArticlesDTO>> getArticlesBetweenDate(@RequestParam("start") long startTimeStamp, @RequestParam("end") long endTimeStamp) {
        return ResponseEntity.ok(newsArticlesService.getArticlesBetweenDate(startTimeStamp, endTimeStamp));
    }

    @GetMapping(value = "/author")
    public ResponseEntity<List<NewsArticlesDTO>> getArticlesByAuthor(@RequestParam("name") String authorName) {
        return ResponseEntity.ok(newsArticlesService.getArticlesByAuthor(authorName));
    }

    @GetMapping(value = "/keyword")
    public ResponseEntity<List<NewsArticlesDTO>> getArticlesByKeyword(@RequestParam("value") String keyword) {
        return ResponseEntity.ok(newsArticlesService.findByKeyword(keyword));
    }

}
