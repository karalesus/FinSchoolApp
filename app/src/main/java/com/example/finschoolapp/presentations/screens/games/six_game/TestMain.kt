package com.example.finschoolapp.presentations.screens.games.six_game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.navigation.RootScreen
import com.example.finschoolapp.presentations.screens.games.six_game.navigation.sixGameNavGraph

class TestMain : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = RootScreen.SixGameNavGraph.route) {
                sixGameNavGraph(navController = navController, screenName ={})
                }
            }
        }
    }
