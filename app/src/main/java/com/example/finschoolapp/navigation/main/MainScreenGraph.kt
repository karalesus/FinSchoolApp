import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.finschoolapp.navigation.RootScreen
import com.example.finschoolapp.navigation.games.SecondMiniGameGraph
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.presentations.screens.main.ProgressScreen

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
            route = "second_mini_game",
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            val mainNavController = rememberNavController()
            SecondMiniGameGraph(mainNavController)
            screenName("SecondMiniGame")
        }
    }
}