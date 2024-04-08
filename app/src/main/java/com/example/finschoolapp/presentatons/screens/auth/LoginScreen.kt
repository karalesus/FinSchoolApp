package com.example.finschoolapp.presentatons.screens.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@Composable
fun LoginScreen(
    onClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotClick: () -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text (
           modifier = Modifier.clickable { onClick() } ,
            text = "ЛОГИН",
            style = textViewBaseVariant
        )
        Text (
            modifier = Modifier.clickable { onClick() } ,
            text = "Зарегистрироваться",
            style = textViewBaseVariant
        )
        Text (
            modifier = Modifier.clickable { onClick() } ,
            text = "Забыл пароль",
            style = textViewBaseVariant
        )
    }
}

