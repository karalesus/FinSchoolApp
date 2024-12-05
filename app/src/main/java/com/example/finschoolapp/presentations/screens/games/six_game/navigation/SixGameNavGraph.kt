package com.example.finschoolapp.presentations.screens.games.six_game.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.finschoolapp.navigation.RootScreen
import com.example.finschoolapp.presentations.screens.games.six_game.AddToVsrScreen
import com.example.finschoolapp.presentations.screens.games.six_game.BaseGameScreen
import com.example.finschoolapp.presentations.screens.games.six_game.ChoosingInsuranceScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


var isVsr: Boolean = false

var isVsrDop: Boolean = false

var isElse: Boolean = false

var isDms: Boolean = false

var isUseDms: Boolean = false

var tomMoney:Int = 120000
fun updateMoney(amount: Int) {
    tomMoney += amount
}

fun updateUseDms() {
    isUseDms = true
}
fun resetGameState() {
    isVsr = false
    isVsrDop = false
    isElse = false
    isDms = false
    isUseDms = false
    tomMoney = 120000
}


fun NavGraphBuilder.sixGameNavGraph(
    navController: NavHostController,
    screenName: (String) -> Unit,
)
{

    navigation(route = RootScreen.SixGameNavGraph.route, startDestination = ChoosingInsurance.StartGame.route,){
        composable(
            route = ChoosingInsurance.StartGame.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() },
        ){
            LaunchedEffect(Unit) {
                resetGameState()
            }
            ChoosingInsuranceScreen(
                navController = navController,
                cashAmount = tomMoney,
                buttonActions = listOf(
                    {
                        updateMoney(-30000)
                        isDms = true
                        navController.navigate(GameScreen.Game6Screen1.route)
                    },
                    { updateMoney(-50000)
                        isElse = true
                        navController.navigate(GameScreen.Game6Screen1.route)},
                    { updateMoney(-30000)
                        isVsr = true
                        navController.navigate(AddToVsrScreen.SecondScreen.route)
                    }
                )
            )
            screenName("StartGame")
        }
        composable(route = AddToVsrScreen.SecondScreen.route){
            AddToVsrScreen(
                navController = navController,
                cashAmount = tomMoney,
                buttonActions = listOf(
                    {
                        updateMoney(-5000)
                        isVsrDop = true
                        navController.navigate(GameScreen.Game6Screen1.route)
                    },
                    { navController.navigate(GameScreen.Game6Screen1.route)}
                )
            )
            screenName("AddToVsr")
        }

        composable(route = GameScreen.Game6Screen1.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf(
                    {navController.navigate(GameScreen.Game6Screen2.route) },
                    {navController.navigate(GameScreen.Game6Screen8.route)  }//заменить
                ),
                scenario = sixGameScenarios[0],
                cashAmount = tomMoney
            )
            screenName("RoadOrBar")
        }
        composable(route = GameScreen.Game6Screen2.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf(
                    {updateMoney(-8000)
                        navController.navigate(GameScreen.Game6Screen3.route) },
                    {navController.navigate(GameScreen.Game6Screen8.route)  }
                ),
                scenario = sixGameScenarios[1],
                cashAmount = tomMoney
            )
            screenName("Bar")
        }
        composable(route = GameScreen.Game6Screen3.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {
                    if (isVsrDop || isDms || isElse) {
                        navController.navigate(GameScreen.Game6Screen4.route)
                    } else navController.navigate(GameScreen.Game6Screen8.route)
                },
                scenario = sixGameScenarios[2],
                cashAmount = tomMoney
            )
            screenName("Bar2")
        }
        composable(route = GameScreen.Game6Screen4.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf(
                    {updateMoney(-10000)
                        navController.navigate(GameScreen.Game6Screen5.route) },
                    {navController.navigate(GameScreen.Game6Screen8.route)  }
                ),
                scenario = sixGameScenarios[3],
                cashAmount = tomMoney
            )
            screenName("Bar3")
        }
        composable(route = GameScreen.Game6Screen5.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {
                    navController.navigate(GameScreen.Game6Screen6.route)
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(200)
                        when {
                            isVsrDop -> updateMoney(50000)
                            isDms -> updateMoney(0)
                            else -> updateMoney(-30000)
                        }
                    }},
                scenario = sixGameScenarios[4],
                cashAmount = tomMoney
            )
            screenName("Bar3")
        }

        composable(route = GameScreen.Game6Screen6.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {if(isElse) navController.navigate(BadEndSixModule.BadEndGame1.route)
                else  navController.navigate(GameScreen.Game6Screen7.route) },
                scenario = if (isDms) {
                    updateUseDms()
                    sixGameScenarios[5]
                } else if(isVsrDop) {
                    sixGameScenarios[6]
                }else{
                    sixGameScenarios[7]
                },
                cashAmount = tomMoney
            )
            screenName("BrokenArm")
        }
        composable(route = BadEndSixModule.BadEndGame1.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {navController.navigate(RootScreen.SixGameNavGraph.route)},
                scenario = sixGameScenarios[8],
                cashAmount = tomMoney
            )
            screenName("BadEnd1")
        }

        composable(route = GameScreen.Game6Screen7.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {navController.navigate(GameScreen.Game6Screen8.route)},
                scenario = sixGameScenarios[9],
                cashAmount = tomMoney
            )
            screenName("ArmIsHealthy")
        }

        composable(route = GameScreen.Game6Screen8.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {navController.navigate(GameScreen.Game6Screen9.route)},


                scenario = sixGameScenarios[10],
                cashAmount = tomMoney
            )
            screenName("City")
        }

        composable(route = GameScreen.Game6Screen9.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf (
                    { updateMoney(-50000)
                        navController.navigate(GameScreen.Game6Screen10.route) },
                    {updateMoney(-20000)
                        navController.navigate(GameScreen.Game6Screen11.route) },
                    {updateMoney(-30000)
                        navController.navigate(GameScreen.Game6Screen12.route) },
                    {navController.navigate(GameScreen.Game6Screen13.route)}),
                scenario = sixGameScenarios[11],
                cashAmount = tomMoney
            )
            screenName("Morning")
        }
//гид
        composable(route = GameScreen.Game6Screen10.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {
                    navController.navigate(GameScreen.Game6Screen10_2.route)
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(200)
                        when {
                            isVsr -> updateMoney(0)
                            else -> updateMoney(-60000)
                        }
                    }},
                scenario = sixGameScenarios[15],
                cashAmount = tomMoney
            )
            screenName("Excursion")
        }

        //клуб
        composable(route = GameScreen.Game6Screen11.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {
                    navController.navigate(GameScreen.Game6Screen11_2.route)
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(200)
                        when {
                            isVsr -> updateMoney(0)
//
                            else -> updateMoney(-50000)
                        }
                    }},
                scenario = sixGameScenarios[12],
                cashAmount = tomMoney
            )
            screenName("Club")
        }

        //клуб
        composable(route = GameScreen.Game6Screen11_2.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {if(tomMoney<27000) navController.navigate(BadEndSixModule.BadEndGame2.route)
                else navController.navigate(SuccessfulEndSixModule.SuccessfulEndGame.route) },
                scenario = if (isVsr) {
                    sixGameScenarios[13]
                } else{
                    sixGameScenarios[14]
                },
                cashAmount = tomMoney
            )
            screenName("ClubIll")
        }

        composable(route = GameScreen.Game6Screen12.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {
                    navController.navigate(GameScreen.Game6Screen12_2.route)
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(200)
                        when {
                            isVsr -> updateMoney(0)
                            else -> updateMoney(-50000)
                        }
                    }},
                scenario = sixGameScenarios[19],
                cashAmount = tomMoney
            )
            screenName("Diving")
        }

        //дайвинг
        composable(route = GameScreen.Game6Screen12_2.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {if(tomMoney<27000) navController.navigate(BadEndSixModule.BadEndGame2.route)
                else navController.navigate(SuccessfulEndSixModule.SuccessfulEndGame.route) },
                scenario = if (isVsr) {
                    sixGameScenarios[20]
                } else{
                    sixGameScenarios[21]
                },
                cashAmount = tomMoney
            )
            screenName("DivingIll")
        }

//прогулка
        composable(route = GameScreen.Game6Screen13.route) {
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {
                    navController.navigate(GameScreen.Game6Screen10_2.route)
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(200)
                        when {
                            isVsr -> updateMoney(0)
                            isUseDms -> updateMoney(-45000)
                            else -> updateMoney(-60000)
                        }
                    }},
                scenario = sixGameScenarios[16],
                cashAmount = tomMoney
            )
            screenName("Walking")
        }

        composable(route = GameScreen.Game6Screen10_2.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {if(tomMoney<27000) navController.navigate(BadEndSixModule.BadEndGame2.route)
                else navController.navigate(SuccessfulEndSixModule.SuccessfulEndGame.route) },
                scenario = if (isVsr) {
                    sixGameScenarios[17]
                } else{
                    sixGameScenarios[18]
                },
                cashAmount = tomMoney
            )
            screenName("Ill")
        }

        composable(route = SuccessfulEndSixModule.SuccessfulEndGame.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {RootScreen.MainScreenGraph.route},
                scenario = if (tomMoney >=65000) {
                    sixGameScenarios[23]
                } else if (tomMoney>=40000){
                    sixGameScenarios[24]
                }else sixGameScenarios[25],
                cashAmount = tomMoney
            )
            screenName("HappyEnd")
        }

        composable(route = BadEndSixModule.BadEndGame2.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {navController.navigate(ChoosingInsurance.StartGame.route)},
                scenario = sixGameScenarios[22],
                cashAmount = tomMoney
            )
            screenName("BadEnd1")
        }


    }


}

@Immutable
sealed class GameScreen(val route: String) {
    object Game6Screen1 : GameScreen(route = "Game6Screen1")
    object Game6Screen2 : GameScreen(route = "Game6Screen2")
    object Game6Screen3 : GameScreen(route = "Game6Screen3")
    object Game6Screen4 : GameScreen(route = "Game6Screen4")
    object Game6Screen5 : GameScreen(route = "Game6Screen5")
    object Game6Screen6 : GameScreen(route = "Game6Screen6")
    object Game6Screen7 : GameScreen(route = "Game6Screen7")
    object Game6Screen8 : GameScreen(route = "Game6Screen8")

    object Game6Screen9 : GameScreen(route = "Game6Screen9")

    object Game6Screen10 : GameScreen(route = "Game6Screen10")
    object Game6Screen10_2 : GameScreen(route = "Game6Screen10_2")

    object Game6Screen11 : GameScreen(route = "Game6Screen11")

    object Game6Screen11_2 : GameScreen(route = "Game6Screen11_2")

    object Game6Screen12 : GameScreen(route = "Game6Screen12")

    object Game6Screen12_2 : GameScreen(route = "Game6Screen12_2")

    object Game6Screen13 : GameScreen(route = "Game6Screen13")


}
@Immutable
sealed class ChoosingInsurance(val route: String) {
    object StartGame: ChoosingInsurance(route = "StartGame")
}

@Immutable
sealed class AddToVsrScreen(val route: String) {
    object SecondScreen: AddToVsrScreen(route = "AddToVsr")
}
@Immutable
sealed class SuccessfulEndSixModule(val route: String) {
    object SuccessfulEndGame: SuccessfulEndSixModule(route = "SuccessfulEndGame1")
}

@Immutable
sealed class BadEndSixModule(val route: String) {
    object BadEndGame1: BadEndSixModule(route = "BadEndGame1")
    object BadEndGame2: BadEndSixModule(route = "BadEndGame2")
}
@Composable
fun TestMain() {
    val navController = rememberNavController()
    var tomMoney by remember { mutableStateOf(100000) }

    NavHost(navController, startDestination = RootScreen.SixGameNavGraph.route) {
        sixGameNavGraph(navController = navController) {
        }
    }
}