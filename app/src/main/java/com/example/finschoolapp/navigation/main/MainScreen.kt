package com.example.finschoolapp.navigation.main

import androidx.compose.runtime.Immutable

@Immutable
sealed class MainScreen (val route: String) {
    object ProgressScreen: MainScreen("Прогресс")
    object LearningScreen: MainScreen("Обучение")
    object WalletScreen: MainScreen("Учёт")
}