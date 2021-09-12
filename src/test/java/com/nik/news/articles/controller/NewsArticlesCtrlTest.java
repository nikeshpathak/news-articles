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

import com.nik.news.articles.model.NewsArticles;
import com.nik.news.articles.repo.NewsArticlesRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class NewsArticlesCtrlTest {

    @MockBean
    NewsArticlesRepo newsArticlesRepo;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveNewsArticlesTest() throws Exception {
        when(newsArticlesRepo.save(any())).thenReturn(getNewsArticlesObject());
        mockMvc.perform(post("/news")
                .contentType(MediaType.APPLICATION_JSON).content("{\"header\":\"Operative motivating projection\",\"shortDesc\":\"Subluxation of MCP joint of right ring finger\",\"text\":\"Subluxation of metacarpophalangeal joint of right ring finger\",\"author\":\"Cristie Awmack\",\"keyword\":\"Vagram\",\"publishDate\":1631440612723}")).andExpect(status().isCreated());
    }

    @Test
    public void updateNewsArticlesTest() throws Exception {
        when(newsArticlesRepo.save(any())).thenReturn(getNewsArticlesObject());
        when(newsArticlesRepo.findById(any())).thenReturn(Optional.of(getNewsArticlesObject()));
        mockMvc.perform(put("/news")
                .contentType(MediaType.APPLICATION_JSON).content("{\"id\":1,\"header\":\"Operative motivating projection\",\"shortDesc\":\"Subluxation of MCP joint of right ring finger\",\"text\":\"Subluxation of metacarpophalangeal joint of right ring finger\",\"author\":\"Cristie Awmack\",\"keyword\":\"Vagram\",\"publishDate\":1631440612723}")).andExpect(status().isAccepted());
    }

    @Test
    public void getArticlesByIdTest() throws Exception {
        when(newsArticlesRepo.findById(any())).thenReturn(Optional.of(getNewsArticlesObject()));
        mockMvc.perform(get("/news/1")).andExpect(status().isOk());
    }

    @Test
    public void deleteArticlesByIdTest() throws Exception {
        when(newsArticlesRepo.findById(any())).thenReturn(Optional.of(getNewsArticlesObject()));
        doNothing().when(newsArticlesRepo).deleteById(anyLong());
        mockMvc.perform(get("/news/1")).andExpect(status().isOk());
    }

    @Test
    public void getArticlesBetweenDate() throws Exception {
        ArrayList<NewsArticles> list = new ArrayList();
        list.add(getNewsArticlesObject());
        when(newsArticlesRepo.findByPublishDateBetween(anyLong(), anyLong())).thenReturn(list);
        mockMvc.perform(get("/news/betweenDate").param("start", "1631440612723")
                .param("end", "1631440612723")).andExpect(status().isOk());
    }

    @Test
    public void getArticlesByAuthor() throws Exception {
        ArrayList<NewsArticles> list = new ArrayList();
        list.add(getNewsArticlesObject());
        when(newsArticlesRepo.findByAuthor(anyString())).thenReturn(list);
        mockMvc.perform(get("/news/author").param("name", "Atlante Ovize")).andExpect(status().isOk());
    }

    @Test
    public void getArticlesByKeyWord() throws Exception {
        ArrayList<NewsArticles> list = new ArrayList();
        list.add(getNewsArticlesObject());
        when(newsArticlesRepo.findByKeyword(anyString())).thenReturn(list);
        mockMvc.perform(get("/news/keyword").param("value", "Hatity")).andExpect(status().isOk());
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

}
