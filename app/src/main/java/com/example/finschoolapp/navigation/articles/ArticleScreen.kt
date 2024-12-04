package com.example.finschoolapp.navigation.articles

import androidx.compose.runtime.Immutable;

@Immutable
sealed class ArticleScreen(val route: String) {
    object ArticleList : ArticleScreen("ArticleList")
    object ArticleDetail : ArticleScreen("ArticleDetail")
}
