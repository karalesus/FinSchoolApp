package com.example.finschoolapp.presentations.screens.articles

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.finschoolapp.data.model.Article

@Composable
fun ArticlesScreen(
    navController: NavHostController,
    moduleId: String,
    articles: List<Article>
) {

    LazyColumn {
        items(articles) { article ->
            ArticleItem(article) {
                navController.navigate("article/${article.id}")
            }
        }
    }
}

