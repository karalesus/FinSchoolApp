package com.example.finschoolapp.navigation.games

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finschoolapp.presentations.screens.secondgame.FinalScreen
import com.example.finschoolapp.presentations.screens.secondgame.QuestionScreen
import com.example.finschoolapp.presentations.screens.secondgame.SecondMiniGameMainScreen
import com.example.finschoolapp.viewmodel.SecondMiniGameViewModel

@Composable
fun SecondMiniGameGraph(navController: NavHostController) {
    val viewModel: SecondMiniGameViewModel = viewModel()

    NavHost(navController = navController, startDestination = "main_screen") {
        composable(route = "main_screen") {
            SecondMiniGameMainScreen(
                navController = navController,
                buttonRoute = "screen_0"
            )
        }
        buildGameGraph(navController, viewModel)
        composable(route = "game_end") {
            FinalScreen(
                viewModel = viewModel,
                navController = navController,
                nextRoute = "learning"
            )
        }
    }
}


fun NavGraphBuilder.buildGameGraph(
    navController: NavController,
    viewModel: SecondMiniGameViewModel
) {
    viewModel.questions.forEachIndexed { index, question ->
        val route = "screen_$index"
        val nextScreen = if (index + 1 < viewModel.questions.size) "screen_${index + 1}" else "game_end"

        composable(route = route) {
            QuestionScreen(
                questionTitle = question.questionTitle,
                questionText = question.questionText,
                answers = question.answers,
                imageResId = question.imageResId,
                navController = navController as NavHostController,
                nextRoute = nextScreen,
                viewModel = viewModel
            )
        }
    }
}
