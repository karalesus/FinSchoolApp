package com.example.finschoolapp.presentations.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.ui.components.buttons.PrimaryButton

import com.example.finschoolapp.ui.theme.ThemeColors

@Composable
fun ProgressScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Progress Screen")

        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally),
        ) {
            Text(
                text = "Прогресс",
                color = ThemeColors.LightTheme.secondary,
                fontWeight = FontWeight.Bold
            )
            PrimaryButton(
                modifier = Modifier.size
                    (width = 200.dp, height = 50.dp),
                palette = ThemeColors.LightTheme,
                text = "2 МИНИ-ИГРА",
                navController = navController,
                route = MainScreen.SecondMiniGame.route
            )

            Spacer(modifier = Modifier.height(20.dp))

            PrimaryButton(
                modifier = Modifier.size(width = 200.dp, height = 50.dp),
                palette = ThemeColors.LightTheme,
                text = "4 МИНИ-ИГРА",
                navController = navController,
                route = MainScreen.FourthMiniGame.route
            )
        }
    }
}

       
