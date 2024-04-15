package com.example.finschoolapp.presentations.screens.main

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.presentations.screens.slider.ThemeSliderScreen
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.ThemeColors

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
    ) {
        ThemeSliderScreen(navController = rememberNavController())
    }
}

@Composable
@Preview
fun LearningScreenPreview() {
    LearningScreen()
}