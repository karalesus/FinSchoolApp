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


var answerCount: Int = 0
fun updateAnswerCount() {
    answerCount += 1
}
fun NavGraphBuilder.fifthGameNavGraph(
    navController: NavHostController,
    screenName: (String) -> Unit
) {
    navigation(
        route = RootScreen.FifthGameNavGraph.route,
        startDestination = QuestionGameScreen.GameScreen1.route
    ){

        composable(route = QuestionGameScreen.GameScreen1.route){
            QuestionGameScreen(
                navController = navController,
                scenario = scenarios.get(0),
                onClick ={
                    if(it == scenarios.get(0).correctOptionIndex){
                        updateAnswerCount()
                    }
                    when (it) {
                        0 -> { navController.navigate(AnswerGameScreen.AnswerGame1Screen1.route) }
                        1 -> { navController.navigate(AnswerGameScreen.AnswerGame1Screen2.route) }
                        2 -> { navController.navigate(AnswerGameScreen.AnswerGame1Screen3.route) }
                        3 -> { navController.navigate(AnswerGameScreen.AnswerGame1Screen4.route) }
                    }
                } )
            screenName("Game1Screen1")
        }

        composable(route = AnswerGameScreen.AnswerGame1Screen1.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(0),
                fromButton =0,
                btnRoute = QuestionGameScreen.GameScreen2.route)
            screenName("AnswerGame1Screen1")
        }
        composable(route = AnswerGameScreen.AnswerGame1Screen2.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(0),
                fromButton =1,
                btnRoute = QuestionGameScreen.GameScreen2.route)
            screenName("AnswerGame1Screen2")
        }

        composable(route = AnswerGameScreen.AnswerGame1Screen3.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(0),
                fromButton =2,
                btnRoute = QuestionGameScreen.GameScreen2.route)
            screenName("AnswerGame1Screen3")
        }

        composable(route = AnswerGameScreen.AnswerGame1Screen4.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(0),
                fromButton =3,
                btnRoute = QuestionGameScreen.GameScreen2.route)
            screenName("AnswerGame1Screen4")
        }




        composable(route = QuestionGameScreen.GameScreen2.route){
            QuestionGameScreen(
                navController = navController,
                scenario = scenarios.get(1),
                onClick = {
                    if(it == scenarios.get(1).correctOptionIndex){
                        updateAnswerCount()
                    }
                    when (it) {
                        0 -> { navController.navigate(AnswerGameScreen.AnswerGame2Screen1.route) }
                        1 -> { navController.navigate(AnswerGameScreen.AnswerGame2Screen2.route) }
                        2 -> { navController.navigate(AnswerGameScreen.AnswerGame2Screen3.route) }
                        3 -> { navController.navigate(AnswerGameScreen.AnswerGame2Screen4.route) }
                    }
                })
            screenName("GameScreen2")
        }

        composable(route = AnswerGameScreen.AnswerGame2Screen1.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(1),
                fromButton =0,
                btnRoute = QuestionGameScreen.GameScreen3.route)
            screenName("AnswerGame2Screen1")
        }
        composable(route = AnswerGameScreen.AnswerGame2Screen2.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(1),
                fromButton =1,
                btnRoute = QuestionGameScreen.GameScreen3.route)
            screenName("AnswerGame2Screen2")
        }
        composable(route = AnswerGameScreen.AnswerGame2Screen3.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(1),
                fromButton =2,
                btnRoute = QuestionGameScreen.GameScreen3.route)
            screenName("AnswerGame2Screen3")
        }
        composable(route = AnswerGameScreen.AnswerGame2Screen4.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(1),
                fromButton =3,
                btnRoute = QuestionGameScreen.GameScreen3.route)
            screenName("AnswerGame2Screen4")
        }




//
        composable(route = QuestionGameScreen.GameScreen3.route){
            QuestionGameScreen(
                navController = navController,
                scenario = scenarios.get(2),
                onClick = {
                    if(it == scenarios.get(2).correctOptionIndex){
                        updateAnswerCount()
                    }
                    when (it) {
                        0 -> { navController.navigate(AnswerGameScreen.AnswerGame3Screen1.route) }
                        1 -> { navController.navigate(AnswerGameScreen.AnswerGame3Screen2.route) }
                        2 -> { navController.navigate(AnswerGameScreen.AnswerGame3Screen3.route) }
                        3 -> { navController.navigate(AnswerGameScreen.AnswerGame3Screen4.route) }
                    }
                })
            screenName("GameScreen3")
        }

        composable(route = AnswerGameScreen.AnswerGame3Screen1.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(2),
                fromButton =0,
                btnRoute = QuestionGameScreen.GameScreen4.route)
            screenName("AnswerGame3Screen1")
        }
        composable(route = AnswerGameScreen.AnswerGame3Screen2.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(2),
                fromButton =1,
                btnRoute = QuestionGameScreen.GameScreen4.route)
            screenName("AnswerGame3Screen2")
        }
        composable(route = AnswerGameScreen.AnswerGame3Screen3.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(2),
                fromButton =2,
                btnRoute = QuestionGameScreen.GameScreen4.route)
            screenName("AnswerGame3Screen3")
        }
        composable(route = AnswerGameScreen.AnswerGame3Screen4.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(2),
                fromButton =3,
                btnRoute = QuestionGameScreen.GameScreen4.route)
            screenName("AnswerGame2Screen4")
        }

//




        composable(route = QuestionGameScreen.GameScreen4.route){
            QuestionGameScreen(
                navController = navController,
                scenario = scenarios.get(3),
                onClick = {
                    if(it == scenarios.get(3).correctOptionIndex){
                        updateAnswerCount()
                    }
                    when (it) {
                        0 -> { navController.navigate(AnswerGameScreen.AnswerGame4Screen1.route) }
                        1 -> { navController.navigate(AnswerGameScreen.AnswerGame4Screen2.route) }
                        2 -> { navController.navigate(AnswerGameScreen.AnswerGame4Screen3.route) }
                        3 -> { navController.navigate(AnswerGameScreen.AnswerGame4Screen4.route) }
                    }
                })
            screenName("GameScreen4")
        }

        composable(route = AnswerGameScreen.AnswerGame4Screen1.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(3),
                fromButton =0,
                btnRoute = QuestionGameScreen.GameScreen5.route)
            screenName("AnswerGame4Screen1")
        }
        composable(route = AnswerGameScreen.AnswerGame4Screen2.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(3),
                fromButton =1,
                btnRoute = QuestionGameScreen.GameScreen5.route)
            screenName("AnswerGame4Screen2")
        }
        composable(route = AnswerGameScreen.AnswerGame4Screen3.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(3),
                fromButton =2,
                btnRoute = QuestionGameScreen.GameScreen5.route)
            screenName("AnswerGame4Screen3")
        }
        composable(route = AnswerGameScreen.AnswerGame4Screen4.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(3),
                fromButton =3,
                btnRoute = QuestionGameScreen.GameScreen5.route)
            screenName("AnswerGame4Screen4")
        }




        composable(route = QuestionGameScreen.GameScreen5.route){
            QuestionGameScreen(
                navController = navController,
                scenario = scenarios.get(4),
                onClick = {
                    if(it == scenarios.get(4).correctOptionIndex){
                        updateAnswerCount()
                    }
                    when (it) {
                        0 -> { navController.navigate(AnswerGameScreen.AnswerGame5Screen1.route) }
                        1 -> { navController.navigate(AnswerGameScreen.AnswerGame5Screen2.route) }
                        2 -> { navController.navigate(AnswerGameScreen.AnswerGame5Screen3.route) }
                        3 -> { navController.navigate(AnswerGameScreen.AnswerGame5Screen4.route) }
                    }
                })
            screenName("GameScreen5")
        }

        composable(route = AnswerGameScreen.AnswerGame5Screen1.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(4),
                fromButton =0,
                btnRoute =
                    if( answerCount>3){
                        SuccessfulEndScreenFifthGame.SuccessfulEndGame.route
                    }else{
                        RepeatEndScreenFifthGame.RepeatEndGame.route
                    }
            )
            screenName("AnswerGame5Screen1")
        }
        composable(route = AnswerGameScreen.AnswerGame5Screen2.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(4),
                fromButton =1,
                btnRoute =
                    if( answerCount>3){
                        SuccessfulEndScreenFifthGame.SuccessfulEndGame.route
                    }else{
                        RepeatEndScreenFifthGame.RepeatEndGame.route
                    }
            )
            screenName("AnswerGame5Screen2")
        }
        composable(route = AnswerGameScreen.AnswerGame5Screen3.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(4),
                fromButton =2,
                btnRoute =
                    if( answerCount>3){
                        SuccessfulEndScreenFifthGame.SuccessfulEndGame.route
                    }else{
                        RepeatEndScreenFifthGame.RepeatEndGame.route
                    }
            )
            screenName("AnswerGame5Screen3")
        }
        composable(route = AnswerGameScreen.AnswerGame5Screen4.route){
            AnswerGameScreen(
                navController = navController,
                scenario = scenarios.get(4),
                fromButton =3,
                btnRoute =
                    if( answerCount>3){
                        SuccessfulEndScreenFifthGame.SuccessfulEndGame.route
                    }else{
                        RepeatEndScreenFifthGame.RepeatEndGame.route
                    }
               )
            screenName("AnswerGame5Screen4")
        }





        composable(route = SuccessfulEndScreenFifthGame.SuccessfulEndGame.route){
            SuccessfulEndScreenFifthGame(
                navController = navController,
                answerCount = answerCount)
            screenName("SuccessfulEndGame")
        }

        composable(route = RepeatEndScreenFifthGame.RepeatEndGame.route){
            RepeatEndScreenFifthGame(
                navController = navController,
                answerCount = answerCount)
            screenName("RepeatEndGame")
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
sealed class AnswerGameScreen(val route: String) {
    object AnswerGame1Screen1 : AnswerGameScreen(route = "AnswerGame1Screen1")
    object AnswerGame1Screen2 : AnswerGameScreen(route = "AnswerGame1Screen2")
    object AnswerGame1Screen3 : AnswerGameScreen(route = "AnswerGame1Screen3")
    object AnswerGame1Screen4 : AnswerGameScreen(route = "AnswerGame1Screen4")


    object AnswerGame2Screen1 : AnswerGameScreen(route = "AnswerGame2Screen1")
    object AnswerGame2Screen2 : AnswerGameScreen(route = "AnswerGame2Screen2")
    object AnswerGame2Screen3 : AnswerGameScreen(route = "AnswerGame2Screen3")
    object AnswerGame2Screen4 : AnswerGameScreen(route = "AnswerGame2Screen4")


    object AnswerGame3Screen1 : AnswerGameScreen(route = "AnswerGame3Screen1")
    object AnswerGame3Screen2 : AnswerGameScreen(route = "AnswerGame3Screen2")
    object AnswerGame3Screen3 : AnswerGameScreen(route = "AnswerGame3Screen3")
    object AnswerGame3Screen4 : AnswerGameScreen(route = "AnswerGame3Screen4")


    object AnswerGame4Screen1 : AnswerGameScreen(route = "AnswerGame4Screen1")
    object AnswerGame4Screen2 : AnswerGameScreen(route = "AnswerGame4Screen2")
    object AnswerGame4Screen3 : AnswerGameScreen(route = "AnswerGame4Screen3")
    object AnswerGame4Screen4 : AnswerGameScreen(route = "AnswerGame4Screen4")


    object AnswerGame5Screen1 : AnswerGameScreen(route = "AnswerGame5Screen1")
    object AnswerGame5Screen2 : AnswerGameScreen(route = "AnswerGame5Screen2")
    object AnswerGame5Screen3 : AnswerGameScreen(route = "AnswerGame5Screen3")
    object AnswerGame5Screen4 : AnswerGameScreen(route = "AnswerGame5Screen4")
}

@Immutable
sealed class FirstScreenFifthGame(val route: String) {
    object StartGame: FirstScreenFifthGame(route = "StartGame")
}

@Immutable
sealed class SuccessfulEndScreenFifthGame(val route: String) {
    object SuccessfulEndGame: SuccessfulEndScreenFifthGame(route = "SuccessfulEndGame")
}

@Immutable
sealed class RepeatEndScreenFifthGame(val route: String) {
    object RepeatEndGame: RepeatEndScreenFifthGame(route = "RepeatEndGame")
}



