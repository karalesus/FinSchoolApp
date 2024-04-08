package com.example.finschoolapp.presentations.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.finschoolapp.ui.theme.ThemeColors

@Composable
fun LearningScreen (
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text (
            text = "Обучение",
            color = ThemeColors.LightTheme.secondary,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview
fun LearningScreenPreview() {
    LearningScreen()
}