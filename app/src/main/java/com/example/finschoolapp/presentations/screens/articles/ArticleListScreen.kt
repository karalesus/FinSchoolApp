package com.example.finschoolapp.presentations.screens.articles

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.example.finschoolapp.data.model.Article
import com.example.finschoolapp.presentations.viewModels.ArticleViewModel
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.smallHeader
import com.example.finschoolapp.ui.theme.textViewBaseVariant
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
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
            TopAppBar(
                title = {
                    Text(
                        text = "Изучить в модуле $moduleId",
                        color = ThemeColors.LightTheme.thirdLight,
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
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = ThemeColors.LightTheme.moduleBackgroundDark
                )
            )
        }
    ) { padding ->
        Box (
            modifier = Modifier
                .fillMaxSize()
                .background(ThemeColors.LightTheme.background)
                .padding(padding)
        )
        if (articles.value.isEmpty()) {
            Text(
                text = "Если долго не загружается, проверьте подключение к интернету",
                color = ThemeColors.LightTheme.secondary,
                style = smallHeader
            )
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(horizontal =  16.dp, vertical = 8.dp)
                    .fillMaxSize()
            ) {
                items(articles.value) { article ->
                    ArticleItem(article = article,
                        onClick = {
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
            .padding(vertical = 12.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(ThemeColors.LightTheme.moduleBackgroundDark)
                .padding(16.dp), // Внутренние отступы
            contentAlignment = Alignment.Center // Центрирование содержимого внутри Box
        ) {
            Text(
                text = article.title,
                color = ThemeColors.LightTheme.thirdLight,
                style = textViewBaseVariant
            )
        }
    }
}

