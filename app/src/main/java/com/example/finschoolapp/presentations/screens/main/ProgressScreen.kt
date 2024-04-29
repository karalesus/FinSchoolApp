package com.example.finschoolapp.presentations.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.components.toolbars.SettingToolbar
import com.example.finschoolapp.ui.theme.ThemeColors

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProgressScreen(
    navController: NavHostController
) {
    Scaffold (
        topBar = {
            SettingToolbar(
                text = stringResource(id = R.string.label_progress),
                palette = ThemeColors.LightTheme,
                navController = navController
            )
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Прогресс",
                color = ThemeColors.LightTheme.secondary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@Preview
fun ProgressScreenPreview() {
    ProgressScreen(navController = rememberNavController())
}
