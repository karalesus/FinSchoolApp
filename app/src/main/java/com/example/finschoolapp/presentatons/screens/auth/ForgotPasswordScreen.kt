package com.example.finschoolapp.presentatons.screens.auth

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
fun ForgotPasswordScreen(
    name: String,
    onClick: () -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text (
            modifier = Modifier.clickable { onClick() } ,
            text = "Восстановление пароля",
            style = textViewBaseVariant
        )
    }
}