import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.finschoolapp.navigation.RootScreen
import com.example.finschoolapp.navigation.games.secondMiniGameGraph
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.viewmodel.SecondMiniGameViewModel
import com.example.finschoolapp.navigation.games.fourthMiniGameNavGraph
import com.example.finschoolapp.presentations.screens.fourthgame.FourthMiniGameMain
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

    }
}