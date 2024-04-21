package com.example.finschoolapp.presentations.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.ui.components.toolbars.BackToolbar
import com.example.finschoolapp.ui.theme.ThemeColors

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            BackToolbar(
                text = "Настройки профиля",
                palette = ThemeColors.LightTheme,
                navController = navController
            )
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Настройки")
        }
    }
}

@Preview
@Composable
fun SettingScreenPreview() {
    SettingScreen(navController = rememberNavController())
}