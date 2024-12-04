package com.example.finschoolapp.navigation.games

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.presentations.screens.secondgame.FinalScreen
import com.example.finschoolapp.presentations.screens.secondgame.QuestionScreen
import com.example.finschoolapp.presentations.screens.secondgame.SecondMiniGameMainScreen
import com.example.finschoolapp.viewmodel.SecondMiniGameViewModel
import kotlinx.coroutines.MainScope

fun NavGraphBuilder.secondMiniGameGraph(
    navController: NavHostController,
    viewModel: SecondMiniGameViewModel
) {
    navigation(
        startDestination = MainScreen.SecondMiniGame.route,
        route = "secondMiniGameGraph"
    ) {
        composable(route = MainScreen.SecondMiniGame.route) {
            SecondMiniGameMainScreen(
                navController = navController,
                buttonRoute = "screen_0",
                viewModel = viewModel
            )
        }
        composable(route = "screen_{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toIntOrNull() ?: 0
            val question = viewModel.questions[index]
            val nextScreen = if (index + 1 < viewModel.questions.size) "screen_${index + 1}" else "game_end"

            QuestionScreen(
                questionTitle = question.questionTitle,
                questionText = question.questionText,
                answers = question.answers,
                imageResId = question.imageResId,
                navController = navController,
                nextRoute = nextScreen,
                viewModel = viewModel
            )
        }
        composable(route = "game_end") {
            FinalScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}