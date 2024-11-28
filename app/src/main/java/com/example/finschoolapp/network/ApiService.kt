package com.example.finschoolapp.network

import com.example.finschoolapp.data.model.Article
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(private val httpClientAndroid: HttpClient) {

    suspend fun fetchArticle(id: Int): Article {
        return httpClientAndroid.get("http://83.102.204.195:8085/article/$id").body()
    }

    suspend fun fetchArticlesForModule(moduleId: Int): List<Article> {
        return httpClientAndroid.get("http://83.102.204.195:8085/article/module/$moduleId").body()
    }
}