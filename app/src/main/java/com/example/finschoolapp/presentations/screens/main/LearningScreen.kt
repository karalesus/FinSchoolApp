package com.example.finschoolapp.presentations.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.presentations.screens.slider.ThemeSliderScreen
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.ThemeColors

@Composable
fun LearningScreen (
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TextToolbar(
                text = "Обучение",
                titleColor = ThemeColors.LightTheme.thirdLight,
                backgroundColor = ThemeColors.LightTheme.moduleBackgroundDark
            )
        },
    ) { innerPadding ->
        ThemeSliderScreen(navController = rememberNavController())
    }
}

@Composable
@Preview
fun LearningScreenPreview() {
    LearningScreen()
}