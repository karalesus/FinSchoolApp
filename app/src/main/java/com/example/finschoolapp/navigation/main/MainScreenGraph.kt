package com.example.finschoolapp.navigation.main

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.finschoolapp.navigation.RootScreen
import com.example.finschoolapp.presentatons.screens.main.LearningScreen
import com.example.finschoolapp.presentatons.screens.main.ProgressScreen
import com.example.finschoolapp.presentatons.screens.main.WalletScreen

fun NavGraphBuilder.mainScreenGraph(screenName: (String) -> Unit) {
    navigation(
        startDestination = MainScreen.Progress.route,
        route = RootScreen.MainScreenGraph.route
    ) {
        composable(
            route = MainScreen.Progress.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            ProgressScreen()
            screenName("Progress")
        }

        composable(
            route = MainScreen.Learning.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            LearningScreen()
            screenName("Learning")
        }

        composable(
            route = MainScreen.Wallet.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            WalletScreen()
            screenName("Wallet")
        }
    }
}