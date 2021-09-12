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

import com.nik.news.articles.dto.NewsArticlesDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class NewsArticlesRepoRealTest {

    @Autowired
    NewsArticlesRepo newsArticlesRepo;

    @Test
    public void saveNewsArticles() {
        NewsArticlesDTO newsArticlesDTO = new NewsArticlesDTO();
        newsArticlesDTO.setHeader("Mandatory 6th generation middleware");
        newsArticlesDTO.setShortDesc("Poisoning by diagnostic agents, self-harm, sequela");
        newsArticlesDTO.setText("Poisoning by diagnostic agents, intentional self-harm, sequela");
        newsArticlesDTO.setAuthor("Lebbie Withrop");
        newsArticlesDTO.setKeyword("Wrapsafe");
        newsArticlesRepo.save(newsArticlesDTO.toModel());
        Assert.isTrue(true, "data saved Successfully");
    }

    @Test
    public void updateNewsArticles() {
        NewsArticlesDTO newsArticlesDTO = new NewsArticlesDTO();
        newsArticlesDTO.setHeader("Mandatory 6th generation middleware");
        newsArticlesDTO.setShortDesc("Poisoning by diagnostic agents, self-harm, sequela");
        newsArticlesDTO.setText("Poisoning by diagnostic agents, intentional self-harm, sequela");
        newsArticlesDTO.setAuthor("Lebbie Withrop");
        newsArticlesDTO.setKeyword("Wrapsafe");
        newsArticlesRepo.save(newsArticlesDTO.toModel());
        Assert.isTrue(true, "data saved Successfully");
    }

}
