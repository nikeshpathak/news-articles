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

import java.util.List;

public interface NewsArticlesService {

    void add(NewsArticlesDTO newsArticles);

    void update(NewsArticlesDTO newsArticles);

    void delete(long id);

    NewsArticlesDTO get(long id);

    List<NewsArticlesDTO> getArticlesBetweenDate(long start, long end);

    List<NewsArticlesDTO> findByKeyword(String keywords);

    List<NewsArticlesDTO> getArticlesByAuthor(String authorName);

}
