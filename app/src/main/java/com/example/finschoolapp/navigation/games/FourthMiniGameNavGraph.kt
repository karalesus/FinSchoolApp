package com.example.finschoolapp.navigation.games

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.presentations.screens.fourthgame.FourthMiniGameAnswer
import com.example.finschoolapp.presentations.screens.fourthgame.FourthMiniGameFinish
import com.example.finschoolapp.presentations.screens.fourthgame.FourthMiniGameMain
import com.example.finschoolapp.presentations.screens.fourthgame.FourthMiniGameQuestion

fun NavGraphBuilder.fourthMiniGameNavGraph(navController: NavHostController) {

    composable(MainScreen.FourthMiniGame.route) {
        FourthMiniGameMain(navController = navController)
    }

    composable(
        MainScreen.FourthMiniGameQuestion.route,
        arguments = listOf(
            navArgument("questionIndex") { type = NavType.IntType },
            navArgument("correctAnswers") { type = NavType.IntType }
        )
    ) { backStackEntry ->
        val questionIndex = backStackEntry.arguments?.getInt("questionIndex") ?: 0
        val correctAnswers = backStackEntry.arguments?.getInt("correctAnswers") ?: 0
        FourthMiniGameQuestion(
            navController = navController,
            questionIndex = questionIndex,
            correctAnswers = correctAnswers
        )
    }

    composable(
        MainScreen.FourthMiniGameAnswer.route,
        arguments = listOf(
            navArgument("questionIndex") { type = NavType.IntType },
            navArgument("selectedButton") { type = NavType.IntType },
            navArgument("correctAnswers") { type = NavType.IntType }
        )
    ) { backStackEntry ->
        val questionIndex = backStackEntry.arguments?.getInt("questionIndex") ?: 0
        val selectedButton = backStackEntry.arguments?.getInt("selectedButton") ?: 0
        val correctAnswers = backStackEntry.arguments?.getInt("correctAnswers") ?: 0
        FourthMiniGameAnswer(
            questionIndex = questionIndex,
            selectedButton = selectedButton,
            correctAnswers = correctAnswers,
            navController = navController
        )
    }

    composable(
        MainScreen.FourthMiniGameFinish.route,
        arguments = listOf(
            navArgument("correctAnswers") { type = NavType.IntType }
        )
    ) { backStackEntry ->
        val correctAnswers = backStackEntry.arguments?.getInt("correctAnswers") ?: 0
        FourthMiniGameFinish(
            correctAnswers = correctAnswers,
            navController = navController
        )
    }
}