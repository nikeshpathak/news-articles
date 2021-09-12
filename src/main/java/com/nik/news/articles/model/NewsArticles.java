package com.nik.news.articles.model;

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
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_news_articles")
public class NewsArticles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "header")
    String header;
    @Column(name = "short_desc")
    String shortDesc;
    @Column(name = "text")
    String text;
    @Column(name = "publish_date")
    long publishDate;
    @Column(name = "author")
    String author;
    @Column(name = "keyword")
    String keyword;

    public NewsArticlesDTO toDTO() {
        NewsArticlesDTO newsArticlesDTO = new NewsArticlesDTO();
        newsArticlesDTO.setId(this.id);
        newsArticlesDTO.setHeader(this.header);
        newsArticlesDTO.setShortDesc(this.shortDesc);
        newsArticlesDTO.setText(this.text);
        newsArticlesDTO.setPublishDate(new Date().getTime());
        newsArticlesDTO.setAuthor(this.author);
        newsArticlesDTO.setKeyword(this.keyword);
        return newsArticlesDTO;
    }
}
