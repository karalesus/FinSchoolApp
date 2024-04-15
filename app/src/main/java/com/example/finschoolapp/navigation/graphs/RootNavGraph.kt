package com.example.finschoolapp.navigation.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.finschoolapp.navigation.RootScreen
import com.example.finschoolapp.navigation.main.mainScreenGraph

@Composable
fun RootNavigationGraph(
    paddingValues: PaddingValues,
    navController: NavHostController,
    isNavigationBarVisible: (Boolean) -> Unit,
){
    NavHost(
        modifier = Modifier.padding(paddingValues = paddingValues),
        navController  = navController,
        startDestination = RootScreen.AuthNavGraph.route
    ) {
        authNavGraph(navController = navController) {
            isNavigationBarVisible(false)
        }
        mainScreenGraph(navController = navController) {
            isNavigationBarVisible(true)
        }

    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val PROGRESS = "progress_auth"
    // TODO: дальнейшие переходы на экраны
}