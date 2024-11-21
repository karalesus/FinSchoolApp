package com.example.finschoolapp.presentations.screens.games

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Immutable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.finschoolapp.navigation.RootScreen
import com.example.finschoolapp.presentations.screens.main.SuccessfulEndFirstModuleScreen

import com.example.finschoolapp.ui.components.animation.ConfettiAnimation

var tomMmoney: Int = 50
fun updateMoney(amount: Int) {
    tomMmoney += amount
}

fun NavGraphBuilder.gameNavGraph(
    navController: NavHostController,
    screenName: (String) -> Unit
) {
    navigation(
        route = RootScreen.GameNavGraph.route,
        startDestination = NeedHelp.StartGame.route
    ){
        composable(
            route = NeedHelp.StartGame.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ){

            NeedHelp(navController = navController)
//            navController.navigate(GameScreen.Game1Screen1.route)

            screenName("StartGame")
        }


        composable(route = GameScreen.Game1Screen1.route){

            GameScreen(
                onClick = {
                    updateMoney(it)
                    navController.navigate(GameScreen.Game1Screen2.route)
                    println("Кнопка: $tomMmoney")
                          },
                scenario = scenarios.get(0),
                TomMoney = tomMmoney

            )
            screenName("Monday")
        }
        composable(route = GameScreen.Game1Screen2.route){
            GameScreen(
                onClick = {
                    updateMoney(it)
                    navController.navigate(GameScreen.Game1Screen3.route)
                    println("Кнопка: $tomMmoney")
                },
                scenario = scenarios.get(1),
                TomMoney = tomMmoney
            )
            screenName("Tuesday")
        }
        composable(route = GameScreen.Game1Screen3.route){
            GameScreen(
                onClick = {
                    updateMoney(it)
                    navController.navigate(GameScreen.Game1Screen4.route)
                    println("Кнопка: $tomMmoney")
                },
                scenario = scenarios.get(2),
                TomMoney = tomMmoney
            )
            screenName("Wednesday")
        }
        composable(route = GameScreen.Game1Screen4.route){
            GameScreen(
                onClick = {
                    updateMoney(it)
                    navController.navigate(GameScreen.Game1Screen5.route)
                    println("Кнопка: $tomMmoney")
                },
                scenario = scenarios.get(3),
                TomMoney = tomMmoney
            )
            screenName("Thursday")
        }
        composable(route = GameScreen.Game1Screen5.route){
            GameScreen(
                onClick = {
                    updateMoney(it)
                    navController.navigate(GameScreen.Game1Screen6.route)
                    println("Кнопка: $tomMmoney")
                },
                scenario = scenarios.get(4),
                TomMoney = tomMmoney
            )
            screenName("Friday")
        }
        composable(route = GameScreen.Game1Screen6.route){
            GameScreen(
                onClick = {
                    updateMoney(it)
                    navController.navigate(GameScreen.Game1Screen7.route)
                    println("Кнопка: $tomMmoney")
                },
                scenario = scenarios.get(5),
                TomMoney = tomMmoney
            )
            screenName("Saturday")
        }
        composable(route = GameScreen.Game1Screen7.route){
            GameScreen(
                onClick = {
                    updateMoney(it)
                    if(tomMmoney >0) {
                        navController.navigate(SuccessfulEndFirstModuleScreen.SuccessfulEndGame.route)
                    }else{
                        navController.navigate(RipEndFirstModuleScreen.RipEndGame.route)
                    }
                    println("Кнопка: $tomMmoney")
                },
                scenario = scenarios.get(6),
                TomMoney = tomMmoney
            )
            screenName("Sunday")
        }
        composable(route = SuccessfulEndFirstModuleScreen.SuccessfulEndGame.route){
            SuccessfulEndFirstModuleScreen(navController = navController, TomMoney = tomMmoney)
            ConfettiAnimation(visible = true)
            screenName("SuccessfulEnd")
        }
        composable(route = RipEndFirstModuleScreen.RipEndGame.route){
            RipEndFirstModuleScreen(navController = navController)
            screenName("RipEnd")
        }




    }


}

@Immutable
sealed class GameScreen(val route: String) {
    object Game1Screen1 : GameScreen(route = "Game1Screen1")
    object Game1Screen2 : GameScreen(route = "Game1Screen2")
    object Game1Screen3 : GameScreen(route = "Game1Screen3")
    object Game1Screen4 : GameScreen(route = "Game1Screen4")
    object Game1Screen5 : GameScreen(route = "Game1Screen5")
    object Game1Screen6 : GameScreen(route = "Game1Screen6")
    object Game1Screen7 : GameScreen(route = "Game1Screen7")

}
@Immutable
sealed class NeedHelp(val route: String) {
    object StartGame: NeedHelp(route = "StartGame")
}
@Immutable
sealed class SuccessfulEndFirstModuleScreen(val route: String) {
    object SuccessfulEndGame: SuccessfulEndFirstModuleScreen(route = "SuccessfulEndGame")
}

@Immutable
sealed class RipEndFirstModuleScreen(val route: String) {
    object RipEndGame: RipEndFirstModuleScreen(route = "RipEndGame")
}

