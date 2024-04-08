package com.example.finschoolapp.navigation.navBars

import androidx.annotation.DrawableRes
import com.example.finschoolapp.R
import com.example.finschoolapp.navigation.main.MainScreen


sealed class NavigationBarItem(
    val title: String,
    val route: String,
    @DrawableRes val icon: Int
) {
    object Progress : NavigationBarItem(
        title = "Прогресс",
        route = MainScreen.Progress.route,
        icon = R.drawable.progress
    )

    object Learning : NavigationBarItem(
        title = "Обучение",
        route = MainScreen.Learning.route,
        icon = R.drawable.learning
    )

    object Wallet : NavigationBarItem(
        title = "Учет",
        route = MainScreen.Wallet.route,
        icon = R.drawable.wallet
    )
}

val navigationBarItems = listOf(
    NavigationBarItem.Progress,
    NavigationBarItem.Learning,
    NavigationBarItem.Wallet
)
