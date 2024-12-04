package com.example.finschoolapp.navigation.articles

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.finschoolapp.navigation.RootScreen
import com.example.finschoolapp.presentations.screens.articles.ArticleDetailScreen
import com.example.finschoolapp.presentations.screens.articles.ArticleListScreen
import com.example.finschoolapp.presentations.viewModels.ArticleViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.articlesNavGraph(
    navController: NavHostController,
    screenName: (String) -> Unit
) {

    navigation(
        startDestination = ArticleScreen.ArticleList.route,
        route = RootScreen.ArticlesNavGraph.route
    ) {
        composable(
            route = ArticleScreen.ArticleList.route + "/{moduleId}",
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) { backStackEntry ->
            val moduleId = backStackEntry.arguments?.getString("moduleId") ?: ""
            val articleViewModel: ArticleViewModel = koinViewModel()
            ArticleListScreen(navController = navController, moduleId = moduleId)
            screenName("ArticleList")
        }
        composable(
            route = ArticleScreen.ArticleDetail.route + "/{articleId}",
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) { backStackEntry ->
            val moduleId = backStackEntry.arguments?.getString("moduleId")?.toIntOrNull() ?: 0
            val articleId = backStackEntry.arguments?.getString("articleId")?.toIntOrNull() ?: 0
            val articleViewModel: ArticleViewModel = koinViewModel()

            articleViewModel.loadArticle(articleId)

            ArticleDetailScreen(
                articleId = articleId,
                moduleId = moduleId,
                viewModel = articleViewModel,
                navController = navController
            )
            screenName("ArticleDetail")
        }
    }
}
