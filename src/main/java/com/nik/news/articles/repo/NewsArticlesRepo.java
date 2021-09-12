package com.nik.news.articles.repo;

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

import com.nik.news.articles.model.NewsArticles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsArticlesRepo extends CrudRepository<NewsArticles, Long> {

    List<NewsArticles> findByPublishDateBetween(long start, long stop);

    List<NewsArticles> findByKeyword(String keyword);

    List<NewsArticles> findByAuthor(String author);
}
