package com.example.finschoolapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.navigation.graphs.RootNavigationGraph
import com.example.finschoolapp.navigation.navBars.BottomNavigationBar
import com.example.finschoolapp.presentations.viewmodels.MainViewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                val navController = rememberNavController()
                val isNavigationBarVisible by remember { mutableStateOf(false)}
                Scaffold(
                        bottomBar = {
                            if (isNavigationBarVisible) {
                                BottomNavigationBar(navController = navController)
                            }
                        }
                ) { padding ->
                    RootNavigationGraph(
                            paddingValues = padding,
                            isNavigationBarVisible = { mainViewModel.setNavigationBarVisibility(it) },
                            navController = navController
                    )
                }
        }
    }
}
