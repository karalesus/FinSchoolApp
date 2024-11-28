package com.example.finschoolapp.presentations.screens.articles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.finschoolapp.data.model.Article
import com.example.finschoolapp.presentations.viewModels.ArticleViewModel
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import org.koin.androidx.compose.koinViewModel

@Composable
fun ArticleListScreen(
    navController: NavHostController,
    moduleId: String,
    viewModel: ArticleViewModel = koinViewModel()
) {

    val articles = viewModel.articles.collectAsState()
    LaunchedEffect(moduleId) {
        viewModel.loadArticlesForModule(moduleId.toInt())
    }

    Scaffold(
        topBar = {
            TextToolbar(
                text = "Изучить в модуле $moduleId",
                titleColor = ThemeColors.LightTheme.thirdLight,
                backgroundColor = ThemeColors.LightTheme.moduleBackgroundDark
            )
        }
    ) { padding ->
        if (articles.value.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                items(articles.value) { article ->
                    ArticleItem(article = article, onClick = {
                        navController.navigate("articleDetail/${article.id}")
                    }

                    )
                }
            }
        }
    }
}


@Composable
fun ArticleItem(article: Article, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = article.title, color = ThemeColors.LightTheme.moduleBackgroundDark)
        }
    }
}
