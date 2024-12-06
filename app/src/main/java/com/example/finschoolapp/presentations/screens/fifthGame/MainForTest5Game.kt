package com.example.finschoolapp.presentations.screens.fifthGame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.navigation.RootScreen

class MainForTest5Game : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = RootScreen.FifthGameNavGraph.route) {
                fifthGameNavGraph(navController) { screenName -> println("Current Screen: $screenName")
                }
            }
        }
    }
}
