package com.example.finschoolapp.navigation.games

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
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.presentations.screens.games.sixthGame.AddToVsrScreen
import com.example.finschoolapp.presentations.screens.games.sixthGame.BaseGameScreen
import com.example.finschoolapp.presentations.screens.games.sixthGame.ChoosingInsuranceScreen
import com.example.finschoolapp.presentations.screens.games.sixthGame.sixGameScenarios
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
fun updateMoneyInSixthGame(amount: Int) {
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

    navigation(route = MainScreen.SixthMiniGame.route, startDestination = ChoosingInsurance.StartGame.route,){
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
                        updateMoneyInFirstGame(-30000)
                        isDms = true
                        navController.navigate(SixthGameScreen.SixthGame6Screen1.route)
                    },
                    { updateMoneyInFirstGame(-50000)
                        isElse = true
                        navController.navigate(SixthGameScreen.SixthGame6Screen1.route)},
                    { updateMoneyInFirstGame(-30000)
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
                        updateMoneyInFirstGame(-5000)
                        isVsrDop = true
                        navController.navigate(SixthGameScreen.SixthGame6Screen1.route)
                    },
                    { navController.navigate(SixthGameScreen.SixthGame6Screen1.route)}
                )
            )
            screenName("AddToVsr")
        }

        composable(route = SixthGameScreen.SixthGame6Screen1.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf(
                    {navController.navigate(SixthGameScreen.SixthGame6Screen2.route) },
                    {navController.navigate(SixthGameScreen.SixthGame6Screen8.route)  }//заменить
                ),
                scenario = sixGameScenarios[0],
                cashAmount = tomMoney
            )
            screenName("RoadOrBar")
        }
        composable(route = SixthGameScreen.SixthGame6Screen2.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf(
                    {
                        updateMoneyInFirstGame(-8000)
                        navController.navigate(SixthGameScreen.SixthGame6Screen3.route) },
                    {navController.navigate(SixthGameScreen.SixthGame6Screen8.route)  }
                ),
                scenario = sixGameScenarios[1],
                cashAmount = tomMoney
            )
            screenName("Bar")
        }
        composable(route = SixthGameScreen.SixthGame6Screen3.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {
                    if (isVsrDop || isDms || isElse) {
                        navController.navigate(SixthGameScreen.SixthGame6Screen4.route)
                    } else navController.navigate(SixthGameScreen.SixthGame6Screen8.route)
                },
                scenario = sixGameScenarios[2],
                cashAmount = tomMoney
            )
            screenName("Bar2")
        }
        composable(route = SixthGameScreen.SixthGame6Screen4.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf(
                    {
                        updateMoneyInFirstGame(-10000)
                        navController.navigate(SixthGameScreen.SixthGame6Screen5.route) },
                    {navController.navigate(SixthGameScreen.SixthGame6Screen8.route)  }
                ),
                scenario = sixGameScenarios[3],
                cashAmount = tomMoney
            )
            screenName("Bar3")
        }
        composable(route = SixthGameScreen.SixthGame6Screen5.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {
                    navController.navigate(SixthGameScreen.SixthGame6Screen6.route)
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(200)
                        when {
                            isVsrDop -> updateMoneyInFirstGame(50000)
                            isDms -> updateMoneyInFirstGame(0)
                            else -> updateMoneyInFirstGame(-30000)
                        }
                    }},
                scenario = sixGameScenarios[4],
                cashAmount = tomMoney
            )
            screenName("Bar3")
        }

        composable(route = SixthGameScreen.SixthGame6Screen6.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {if(isElse) navController.navigate(BadEndSixModule.BadEndGame1.route)
                else  navController.navigate(SixthGameScreen.SixthGame6Screen7.route) },
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
                buttonActions = listOf {navController.navigate(MainScreen.SixthMiniGame.route)},
                scenario = sixGameScenarios[8],
                cashAmount = tomMoney
            )
            screenName("BadEnd1")
        }

        composable(route = SixthGameScreen.SixthGame6Screen7.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {navController.navigate(SixthGameScreen.SixthGame6Screen8.route)},
                scenario = sixGameScenarios[9],
                cashAmount = tomMoney
            )
            screenName("ArmIsHealthy")
        }

        composable(route = SixthGameScreen.SixthGame6Screen8.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {navController.navigate(SixthGameScreen.SixthGame6Screen9.route)},


                scenario = sixGameScenarios[10],
                cashAmount = tomMoney
            )
            screenName("City")
        }

        composable(route = SixthGameScreen.SixthGame6Screen9.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf (
                    { updateMoneyInFirstGame(-50000)
                        navController.navigate(SixthGameScreen.SixthGame6Screen10.route) },
                    {
                        updateMoneyInFirstGame(-20000)
                        navController.navigate(SixthGameScreen.SixthGame6Screen11.route) },
                    {
                        updateMoneyInFirstGame(-30000)
                        navController.navigate(SixthGameScreen.SixthGame6Screen12.route) },
                    {navController.navigate(SixthGameScreen.SixthGame6Screen13.route)}),
                scenario = sixGameScenarios[11],
                cashAmount = tomMoney
            )
            screenName("Morning")
        }
//гид
        composable(route = SixthGameScreen.SixthGame6Screen10.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {
                    navController.navigate(SixthGameScreen.SixthGame6Screen10_2.route)
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(200)
                        when {
                            isVsr -> updateMoneyInFirstGame(0)
                            else -> updateMoneyInFirstGame(-60000)
                        }
                    }},
                scenario = sixGameScenarios[15],
                cashAmount = tomMoney
            )
            screenName("Excursion")
        }

        //клуб
        composable(route = SixthGameScreen.SixthGame6Screen11.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {
                    navController.navigate(SixthGameScreen.SixthGame6Screen11_2.route)
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(200)
                        when {
                            isVsr -> updateMoneyInFirstGame(0)
//
                            else -> updateMoneyInFirstGame(-50000)
                        }
                    }},
                scenario = sixGameScenarios[12],
                cashAmount = tomMoney
            )
            screenName("Club")
        }

        //клуб
        composable(route = SixthGameScreen.SixthGame6Screen11_2.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {if(tomMoney <27000) navController.navigate(BadEndSixModule.BadEndGame2.route)
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

        composable(route = SixthGameScreen.SixthGame6Screen12.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {
                    navController.navigate(SixthGameScreen.SixthGame6Screen12_2.route)
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(200)
                        when {
                            isVsr -> updateMoneyInFirstGame(0)
                            else -> updateMoneyInFirstGame(-50000)
                        }
                    }},
                scenario = sixGameScenarios[19],
                cashAmount = tomMoney
            )
            screenName("Diving")
        }

        //дайвинг
        composable(route = SixthGameScreen.SixthGame6Screen12_2.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {if(tomMoney <27000) navController.navigate(BadEndSixModule.BadEndGame2.route)
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
        composable(route = SixthGameScreen.SixthGame6Screen13.route) {
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {
                    navController.navigate(SixthGameScreen.SixthGame6Screen10_2.route)
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(200)
                        when {
                            isVsr -> updateMoneyInFirstGame(0)
                            isUseDms -> updateMoneyInFirstGame(-45000)
                            else -> updateMoneyInFirstGame(-60000)
                        }
                    }},
                scenario = sixGameScenarios[16],
                cashAmount = tomMoney
            )
            screenName("Walking")
        }

        composable(route = SixthGameScreen.SixthGame6Screen10_2.route){
            BaseGameScreen(
                navController = navController,
                buttonActions = listOf {if(tomMoney <27000) navController.navigate(BadEndSixModule.BadEndGame2.route)
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
                } else if (tomMoney >=40000){
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
sealed class SixthGameScreen(val route: String) {
    object SixthGame6Screen1 : SixthGameScreen(route = "SixthGame6Screen1")
    object SixthGame6Screen2 : SixthGameScreen(route = "SixthGame6Screen2")
    object SixthGame6Screen3 : SixthGameScreen(route = "SixthGame6Screen3")
    object SixthGame6Screen4 : SixthGameScreen(route = "SixthGame6Screen4")
    object SixthGame6Screen5 : SixthGameScreen(route = "SixthGame6Screen5")
    object SixthGame6Screen6 : SixthGameScreen(route = "SixthGame6Screen6")
    object SixthGame6Screen7 : SixthGameScreen(route = "SixthGame6Screen7")
    object SixthGame6Screen8 : SixthGameScreen(route = "SixthGame6Screen8")

    object SixthGame6Screen9 : SixthGameScreen(route = "SixthGame6Screen9")

    object SixthGame6Screen10 : SixthGameScreen(route = "SixthGame6Screen10")
    object SixthGame6Screen10_2 : SixthGameScreen(route = "SixthGame6Screen10_2")

    object SixthGame6Screen11 : SixthGameScreen(route = "SixthGame6Screen11")

    object SixthGame6Screen11_2 : SixthGameScreen(route = "SixthGame6Screen11_2")

    object SixthGame6Screen12 : SixthGameScreen(route = "SixthGame6Screen12")

    object SixthGame6Screen12_2 : SixthGameScreen(route = "SixthGame6Screen12_2")

    object SixthGame6Screen13 : SixthGameScreen(route = "SixthGame6Screen13")


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

    NavHost(navController, startDestination = MainScreen.SixthMiniGame.route) {
        sixGameNavGraph(navController = navController) {
        }
    }
}