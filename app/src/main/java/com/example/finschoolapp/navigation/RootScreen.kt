package com.example.finschoolapp.navigation

import androidx.compose.runtime.Immutable

@Immutable
sealed class RootScreen
    (val route: String) {
    object FifthGameNavGraph:RootScreen("FifthGame")
    object AuthNavGraph : RootScreen("AuthNavGraph")
    object MainScreenGraph : RootScreen("MainScreenGraph")
    object ArticlesNavGraph : RootScreen("ArticlesNavGraph")
}