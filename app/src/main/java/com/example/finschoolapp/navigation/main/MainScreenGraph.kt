import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.finschoolapp.navigation.RootScreen
import com.example.finschoolapp.navigation.games.fifthGameNavGraph
import com.example.finschoolapp.navigation.games.firstGameNavGraph
import com.example.finschoolapp.navigation.games.secondMiniGameGraph
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.viewmodel.SecondMiniGameViewModel
import com.example.finschoolapp.navigation.games.fourthMiniGameNavGraph
import com.example.finschoolapp.navigation.games.sixGameNavGraph
import com.example.finschoolapp.presentations.screens.games.eightGame.EndEightModuleScreen
import com.example.finschoolapp.presentations.screens.games.fifthGame.FirstScreenFifthGame
import com.example.finschoolapp.presentations.screens.games.firstGame.NeedHelp
import com.example.finschoolapp.presentations.screens.games.fourthGame.FourthMiniGameMain
import com.example.finschoolapp.presentations.screens.games.seventhGame.EndSeventhModuleScreen
import com.example.finschoolapp.presentations.screens.games.sixthGame.ChoosingInsuranceScreen
import com.example.finschoolapp.presentations.screens.main.LearningScreen
import com.example.finschoolapp.presentations.screens.main.ProgressScreen
import com.example.finschoolapp.presentations.screens.main.SettingScreen
import com.example.finschoolapp.presentations.screens.main.WalletScreen
import com.example.finschoolapp.presentations.screens.wallet.AddGoalScreen
import com.example.finschoolapp.presentations.viewModels.ModuleViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.mainScreenGraph(
    navController: NavHostController,
    screenName: (String) -> Unit
) {
    navigation(
        startDestination = MainScreen.Progress.route,
        route = RootScreen.MainScreenGraph.route
    ) {
        composable(
            route = MainScreen.Progress.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            ProgressScreen(navController = navController)
            screenName("Progress")
        }

        composable(
            route = MainScreen.Learning.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            val moduleViewModel: ModuleViewModel = koinViewModel()
            LearningScreen(navController = navController, moduleViewModel = moduleViewModel)
            screenName("Learning")
        }

        composable(
            route = MainScreen.Wallet.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            WalletScreen(navController = navController)
            screenName("Wallet")
        }

        composable(
            route = MainScreen.Settings.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            SettingScreen(navController = navController)
            screenName("Settings")
        }

        composable(
            route = MainScreen.AddGoal.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            AddGoalScreen(navController = navController)
            screenName("AddGoal")
        }

        secondMiniGameGraph(
            navController = navController,
            viewModel = SecondMiniGameViewModel()
        )

        composable(MainScreen.FourthMiniGame.route) {
            FourthMiniGameMain(
                navController = navController
            )
        }

        fourthMiniGameNavGraph(navController = navController)

        composable(
            MainScreen.SixthMiniGame.route
        ) {
            ChoosingInsuranceScreen(
                navController = navController, buttonActions = listOf(),
                cashAmount = 1000
            )
            screenName("SixthGame")
        }
        sixGameNavGraph(navController = navController) {
        }

        composable(
            MainScreen.FirstMiniGame.route
        ) {
            NeedHelp(
                navController = navController

            )
            screenName("FirstGame")
        }
        firstGameNavGraph(navController = navController) {
        }

        composable(
            MainScreen.SeventhMiniGame.route
        ) {
            EndSeventhModuleScreen(navController = navController)
        }

        composable(
            MainScreen.EightMiniGame.route
        ) {
            EndEightModuleScreen(navController = navController)
        }

        composable(
            MainScreen.FifthMiniGame.route
        ) {
            FirstScreenFifthGame(
                navController = navController
            )
            screenName("FifthGame")
        }
        fifthGameNavGraph(navController = navController){}

    }
}