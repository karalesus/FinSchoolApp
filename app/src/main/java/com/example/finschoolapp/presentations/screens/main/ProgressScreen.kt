package com.example.finschoolapp.presentations.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.finschoolapp.R
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

        Spacer(modifier = Modifier.height(20.dp))

        PrimaryButton(
            modifier = Modifier.size
                (width = 296.dp, height = 46.dp),
            palette = ThemeColors.LightTheme,
            text = "SECOND MINI-GAME",
            navController = navController,
            route = "second_mini_game"
        )

    }
}
