package com.example.finschoolapp.presentations.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finschoolapp.data.model.Article
import com.example.finschoolapp.network.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel(private val apiService: ApiService) : ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> get() = _articles

    private val _article = MutableStateFlow<Article?>(null)
    val article: StateFlow<Article?> = _article

    fun loadArticlesForModule(moduleId: Int) {
        viewModelScope.launch {
            try {
                _articles.value = apiService.fetchArticlesForModule(moduleId)
                Log.d("ArticleRepository", "Fetching articles for moduleId = $moduleId")
                Log.d("ArticleRepository", "Response: ${_articles.value}")
            } catch (e: Exception) {
                _articles.value = emptyList()
            }
        }
    }

    fun loadArticle(articleId: Int) {
        viewModelScope.launch {
            try {
                _article.value = apiService.fetchArticle(articleId)
            } catch (e: Exception) {
                _article.value = null
            }
        }
    }
}
