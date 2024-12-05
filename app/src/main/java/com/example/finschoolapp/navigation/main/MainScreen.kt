package com.example.finschoolapp.navigation.main

import androidx.compose.runtime.Immutable

@Immutable
sealed class MainScreen(val route: String) {
    object Progress : MainScreen("Progress")
    object Learning : MainScreen("Learning")
    object Wallet : MainScreen("Wallet")
    object Settings : MainScreen("Settings")
    object AddGoal : MainScreen("AddGoal")
    object SecondMiniGame : MainScreen("SecondMiniGame")
    object FourthMiniGame : MainScreen("FourthMiniGame")
    object FourthMiniGameQuestion :
        MainScreen("fourthMiniGameQuestion/{questionIndex}/{correctAnswers}") {
        fun createRoute(questionIndex: Int, correctAnswers: Int): String =
            "fourthMiniGameQuestion/$questionIndex/$correctAnswers"
    }

    object FourthMiniGameAnswer :
        MainScreen("fourthMiniGameAnswer/{questionIndex}/{selectedButton}/{correctAnswers}") {
        fun createRoute(questionIndex: Int, selectedButton: Int, correctAnswers: Int): String =
            "fourthMiniGameAnswer/$questionIndex/$selectedButton/$correctAnswers"
    }

    object FourthMiniGameFinish :
        MainScreen("fourthMiniGameFinish/{correctAnswers}/{totalQuestions}") {
        fun createRoute(correctAnswers: Int, totalQuestions: Int): String =
            "fourthMiniGameFinish/$correctAnswers/$totalQuestions"
    }
}