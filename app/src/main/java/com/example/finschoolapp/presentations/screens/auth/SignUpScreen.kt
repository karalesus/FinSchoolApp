package com.example.finschoolapp.presentations.screens.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@Composable
fun SignUpScreen(
    name: String,
    onClick: () -> Unit,
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text (
            modifier = Modifier.clickable { onClick() } ,
            text = "Регистрация",
            style = textViewBaseVariant
        )
    }
}