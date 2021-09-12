package com.nik.news.articles.service;

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
import com.nik.news.articles.exception.InvalidIdException;
import com.nik.news.articles.model.NewsArticles;
import com.nik.news.articles.repo.NewsArticlesRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsArticlesServiceImpl implements NewsArticlesService {

    final NewsArticlesRepo newsArticlesRepo;

    @Value("${app.page.size}")
    String pageSize;

    public NewsArticlesServiceImpl(NewsArticlesRepo newsArticlesRepo) {
        this.newsArticlesRepo = newsArticlesRepo;
    }

    @Override
    public void add(NewsArticlesDTO newsArticles) {
        newsArticlesRepo.save(newsArticles.toModel());
    }

    @Override
    public void update(NewsArticlesDTO newsArticlesDTO) {
        Optional<NewsArticles> newsArticles = newsArticlesRepo.findById(newsArticlesDTO.getId());
        if (newsArticles.isPresent()) {
            if (newsArticlesDTO.getHeader() != null)
                newsArticles.get().setHeader(newsArticlesDTO.getHeader());
            if (newsArticlesDTO.getKeyword() != null)
                newsArticles.get().setKeyword(newsArticlesDTO.getKeyword());
            if (newsArticlesDTO.getShortDesc() != null)
                newsArticles.get().setShortDesc(newsArticlesDTO.getShortDesc());
            if (newsArticlesDTO.getText() != null)
                newsArticles.get().setText(newsArticlesDTO.getText());

            newsArticlesRepo.save(newsArticles.get());
        } else {
            throw new InvalidIdException();
        }
    }

    @Override
    public void delete(long id) {
        Optional<NewsArticles> newsArticles = newsArticlesRepo.findById(id);
        if (newsArticles.isPresent()) {
            newsArticlesRepo.deleteById(id);
        } else {
            throw new InvalidIdException();
        }
    }

    @Override
    public NewsArticlesDTO get(long id) {
        Optional<NewsArticles> newsArticles = newsArticlesRepo.findById(id);
        if (newsArticles.isPresent()) {
            return newsArticles.get().toDTO();
        } else {
            throw new InvalidIdException();
        }
    }

    @Override
    public List<NewsArticlesDTO> getArticlesBetweenDate(long start, long end) {
        return newsArticlesRepo.findByPublishDateBetween(start, end).stream().map(NewsArticles::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<NewsArticlesDTO> findByKeyword(String keywords) {
        return newsArticlesRepo.findByKeyword(keywords).stream().map(NewsArticles::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<NewsArticlesDTO> getArticlesByAuthor(String authorName) {
        return newsArticlesRepo.findByAuthor(authorName).stream().map(NewsArticles::toDTO).collect(Collectors.toList());
    }
}
