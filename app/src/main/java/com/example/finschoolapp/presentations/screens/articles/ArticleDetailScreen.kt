package com.example.finschoolapp.presentations.screens.articles

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.finschoolapp.presentations.viewModels.ArticleViewModel
import com.example.finschoolapp.ui.components.buttons.ContinueModuleButton
import com.example.finschoolapp.ui.theme.ThemeColors
import org.koin.androidx.compose.koinViewModel

@Composable
fun ArticleDetailScreen(
    articleId: Int,
    moduleId: Int,
    viewModel: ArticleViewModel = koinViewModel(),
    navController: NavHostController,
) {
    LaunchedEffect(moduleId) {
        viewModel.loadArticlesForModule(moduleId)
        viewModel.loadArticle(articleId)
    }
    val article = viewModel.article.collectAsState().value
    val articlesInModule = viewModel.articles.collectAsState().value
    Log.d("ArticleDetailScreen", "Article: $article")

    if (article != null) {
        val isLastArticle = articlesInModule.lastOrNull()?.id == article.id

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()) // Включение скроллинга
        ) {

            Text(
                text = article.title,
                color = ThemeColors.LightTheme.secondary,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = article.content,
                color = ThemeColors.LightTheme.secondary,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            if (isLastArticle) {
                ContinueModuleButton(
                    modifier = Modifier.fillMaxWidth(),
                    palette = ThemeColors.LightTheme,
                    text = "Перейти к мини-игре",
                    onButtonClick = {
                        // TODO: переход к мини-игре
//                        navController.navigate(ArticleScreen.ArticleList.route+"/{moduleId}")
                    })
            } else {
                ContinueModuleButton(
                    modifier = Modifier.fillMaxWidth(),
                    palette = ThemeColors.LightTheme,
                    text = "Продолжить",
                    onButtonClick = {
                        navController.navigate("articleDetail/${article.id + 1}")
                    }
                )
            }
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Статья не найдена", color = ThemeColors.LightTheme.secondary)
        }
    }
}
