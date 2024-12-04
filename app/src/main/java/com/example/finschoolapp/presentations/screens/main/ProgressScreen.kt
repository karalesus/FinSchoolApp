package com.example.finschoolapp.presentations.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.finschoolapp.R
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.ui.components.buttons.PrimaryButton
import com.example.finschoolapp.ui.components.toolbars.SettingToolbar

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

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Прогресс",
                color = ThemeColors.LightTheme.secondary,
                fontWeight = FontWeight.Bold
            )

            PrimaryButton(
                modifier = Modifier.size(width = 200.dp, height = 50.dp),
                palette = ThemeColors.LightTheme,
                text = "4 МИНИ-ИГРА",
                navController = navController,
                route = MainScreen.FourthMiniGame.route)
            
            Spacer(modifier = Modifier.height(20.dp))

            PrimaryButton(
                modifier = Modifier.size
                    (width = 296.dp, height = 46.dp),
                palette = ThemeColors.LightTheme,
                text = "SECOND MINI-GAME",
                navController = navController,
                route = MainScreen.SecondMiniGame.route
            )
        }
    }
}

       
