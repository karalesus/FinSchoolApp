package com.example.finschoolapp.presentations.screens.articles

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.finschoolapp.R
import com.example.finschoolapp.presentations.viewModels.ArticleViewModel
import com.example.finschoolapp.ui.components.buttons.ContinueModuleButton
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.smallHeader
import com.example.finschoolapp.ui.theme.textViewBaseVariant
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
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

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = article?.title ?: "Статья",
                        color = ThemeColors.LightTheme.secondary,
                        style = smallHeader
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_return),
                            contentDescription = "Return"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO: логика сохранения статьи */ }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_save),
                            contentDescription = "Save"
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = ThemeColors.LightTheme.thirdLight
                )
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(ThemeColors.LightTheme.background)
            ) {
                if (article != null) {
                    val isLastArticle = articlesInModule.lastOrNull()?.id == article.id

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Светлый контейнер
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = ThemeColors.LightTheme.lessonBackground,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(16.dp)
                        ) {

                            Text(
                                text = article.content,
                                color = ThemeColors.LightTheme.secondary,
                                style = textViewBaseVariant,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))


                        if (isLastArticle) {
                            ContinueModuleButton(
                                modifier = Modifier.fillMaxWidth(),
                                palette = ThemeColors.LightTheme,
                                text = "Перейти к мини-игре",
                                onButtonClick = {
                                    // TODO: переход к мини-игре
                                }
                            )
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
        }
    )
}

