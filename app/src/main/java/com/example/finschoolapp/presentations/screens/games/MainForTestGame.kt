package com.example.finschoolapp.presentations.screens.games

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.navigation.RootScreen
import com.example.finschoolapp.navigation.graphs.gameNavGraph

class MainForTestGame : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = RootScreen.GameNavGraph.route) {
                gameNavGraph(navController) { screenName -> println("Current Screen: $screenName")
                }
            }
        }
    }
}
