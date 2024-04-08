package com.example.finschoolapp.navigation

import androidx.compose.runtime.Immutable

@Immutable
sealed class RootScreen
    (val route: String) {
    object AuthNavGraph : RootScreen("Auth")
    object MainScreenGraph : RootScreen("Main")
}