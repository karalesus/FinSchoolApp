package com.example.finschoolapp.presentations.screens.fifthGame

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.finschoolapp.navigation.RootScreen
import com.example.finschoolapp.presentations.screens.games.GameScreen
import com.example.finschoolapp.presentations.screens.games.NeedHelp
import com.example.finschoolapp.presentations.screens.games.RipEndFirstModuleScreen
import com.example.finschoolapp.presentations.screens.main.SuccessfulEndFirstModuleScreen
import com.example.finschoolapp.ui.components.animation.ConfettiAnimation



fun NavGraphBuilder.fifthGameNavGraph(
    navController: NavHostController,
    screenName: (String) -> Unit
) {
    navigation(
        route = RootScreen.FifthGameNavGraph.route,
        startDestination = FirstScreenFifthGame.StartGame.route

    ){
        composable(
            route = FirstScreenFifthGame.StartGame.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ){

            FirstScreenFifthGame(navController = navController)
//            navController.navigate(GameScreen.Game1Screen1.route)

            screenName("StartGame")
        }


        composable(route = GameScreen.Game1Screen1.route){
            QuestionGameScreen(navController = navController, scenario = scenarios.get(0)) {
            }
            screenName("Game1Screen1")
        }






    }


}

@Immutable
sealed class QuestionGameScreen(val route: String) {
    object GameScreen1 : QuestionGameScreen(route = "QuestionGameScreen1")
    object GameScreen2 : QuestionGameScreen(route = "QuestionGameScreen2")
    object GameScreen3 : QuestionGameScreen(route = "QuestionGameScreen3")
    object GameScreen4 : QuestionGameScreen(route = "QuestionGameScreen4")
    object GameScreen5 : QuestionGameScreen(route = "QuestionGameScreen5")


}
@Immutable
sealed class FirstScreenFifthGame(val route: String) {
    object StartGame: FirstScreenFifthGame(route = "StartGame")
}


