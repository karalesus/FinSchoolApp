package com.example.finschoolapp.presentatons.screens.main

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
fun WalletScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text (
            text = "Учёт",
            color = ThemeColors.Theme.secondary,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview
fun WalletScreenPreview() {
    WalletScreen()
}