package com.example.finschoolapp.ui.components.bottomnav

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finschoolapp.ui.components.screens.AccountingScreen
import com.example.finschoolapp.ui.components.screens.LearningScreen
import com.example.finschoolapp.ui.components.screens.ProgressScreen

@Preview
@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Progress.route
    ) {
        composable(route = BottomBarScreen.Progress.route)
        {
            ProgressScreen()
        }
        composable(route = BottomBarScreen.Learning.route)
        {
            LearningScreen()
        }
        composable(route = BottomBarScreen.Accounting.route)
        {
            AccountingScreen()
        }
    }
}