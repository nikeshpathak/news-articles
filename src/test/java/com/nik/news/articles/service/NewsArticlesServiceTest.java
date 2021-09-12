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
import com.nik.news.articles.model.NewsArticles;
import com.nik.news.articles.repo.NewsArticlesRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class NewsArticlesServiceTest {

    @MockBean
    NewsArticlesRepo newsArticlesRepo;

    @Autowired
    NewsArticlesService newsArticlesService;

    @Test
    public void saveNewsArticlesTest() throws Exception {
        when(newsArticlesRepo.save(any())).thenReturn(getNewsArticlesObject());
        newsArticlesService.add(getNewsArticlesObjectDTO());
        Assert.isTrue(true, "Saved Successfully");
    }

    @Test
    public void updateNewsArticlesTest() throws Exception {
        when(newsArticlesRepo.save(any())).thenReturn(getNewsArticlesObject());
        when(newsArticlesRepo.findById(any())).thenReturn(Optional.of(getNewsArticlesObject()));
        newsArticlesService.update(getNewsArticlesObjectDTO());
    }

    @Test
    public void getArticlesByIdTest() throws Exception {
        when(newsArticlesRepo.findById(any())).thenReturn(Optional.of(getNewsArticlesObject()));
        NewsArticlesDTO newsArticlesDTO = newsArticlesService.get(1);
        Assert.notNull(newsArticlesDTO, "Data fetch Successfully");
    }

    private NewsArticles getNewsArticlesObject() {
        NewsArticles newsArticles = new NewsArticles();
        newsArticles.setHeader("Mandatory 6th generation middleware");
        newsArticles.setShortDesc("Poisoning by diagnostic agents, self-harm, sequela");
        newsArticles.setText("Poisoning by diagnostic agents, intentional self-harm, sequela");
        newsArticles.setAuthor("Lebbie Withrop");
        newsArticles.setKeyword("Wrapsafe");
        return newsArticles;
    }

    private NewsArticlesDTO getNewsArticlesObjectDTO() {
        NewsArticlesDTO newsArticles = new NewsArticlesDTO();
        newsArticles.setHeader("Mandatory 6th generation middleware");
        newsArticles.setShortDesc("Poisoning by diagnostic agents, self-harm, sequela");
        newsArticles.setText("Poisoning by diagnostic agents, intentional self-harm, sequela");
        newsArticles.setAuthor("Lebbie Withrop");
        newsArticles.setKeyword("Wrapsafe");
        return newsArticles;
    }

}
