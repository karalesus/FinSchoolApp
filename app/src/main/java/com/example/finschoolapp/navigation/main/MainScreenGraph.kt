import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.finschoolapp.navigation.RootScreen
import com.example.finschoolapp.navigation.games.secondMiniGameGraph
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.presentations.screens.main.ProgressScreen
import com.example.finschoolapp.viewmodel.SecondMiniGameViewModel

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
        secondMiniGameGraph(
            navController = navController,
            viewModel = SecondMiniGameViewModel()
        )
    }
}