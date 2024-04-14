package com.example.finschoolapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.finschoolapp.navigation.graphs.RootNavigationGraph
import com.example.finschoolapp.navigation.navBars.BottomNavigationBar


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            val navController = rememberNavController()
            var isNavigationBarVisible by remember { mutableStateOf(false) }

            Scaffold(
                bottomBar = {
                    if (isNavigationBarVisible) {
                        BottomNavigationBar(navController = navController)
                    }
                }
            )
            { padding ->
                RootNavigationGraph(
                    paddingValues = padding,
                    isNavigationBarVisible = { isNavigationBarVisible = it },
                    navController = navController
                )
            }
        }
    }
}