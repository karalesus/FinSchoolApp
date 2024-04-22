package com.example.finschoolapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.finschoolapp.navigation.graphs.RootNavigationGraph
import com.example.finschoolapp.navigation.navBars.BottomNavigationBar
import com.example.finschoolapp.presentations.viewmodels.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.mainState.observe(this, Observer{newState ->})
    }
}