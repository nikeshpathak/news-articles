package com.nik.news.articles.dto;

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
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class NewsArticlesDTO {

    long id;
    @NotNull
    @Size(min = 2, max = 128)
    String header;
    @NotNull
    @Size(min = 2, max = 256)
    String shortDesc;
    @NotNull
    @Size(min = 10)
    String text;
    long publishDate;
    @NotNull
    @Size(min = 2, max = 256)
    String author;
    @NotNull
    @Size(min = 2, max = 256)
    String keyword;

    public NewsArticles toModel() {
        NewsArticles newsArticles = new NewsArticles();
        newsArticles.setHeader(this.header);
        newsArticles.setShortDesc(this.shortDesc);
        newsArticles.setText(this.text);
        newsArticles.setPublishDate(new Date().getTime());
        newsArticles.setAuthor(this.author);
        newsArticles.setKeyword(this.keyword);
        return newsArticles;
    }

    public List<NewsArticlesDTO> toDTOList(List<NewsArticles> newsArticlesList) {
        return newsArticlesList.stream().map(NewsArticles::toDTO).collect(Collectors.toList());
    }
}
