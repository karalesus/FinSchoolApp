package com.example.finschoolapp.navigation.navBars

import androidx.annotation.DrawableRes
import com.example.finschoolapp.R


sealed class NavigationBarItems(
    val title: String,
    val route: String,
    @DrawableRes val icon: Int
) {
    object Progress : NavigationBarItems(
        title = "Прогресс",
        // TODO: route
        route = " ",
        icon = R.drawable.progress
    )

    object Learning : NavigationBarItems(
        title = "Обучение",
        // TODO: route
        route = " ",
        icon = R.drawable.learning
    )

    object Wallet : NavigationBarItems(
        title = "Учет",
        // TODO: wallet
        route = " ",
        icon = R.drawable.wallet
    )
}

val navigationBarItems = listOf(
    NavigationBarItems.Progress,
    NavigationBarItems.Learning,
    NavigationBarItems.Wallet
)
