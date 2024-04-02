package com.example.finschoolapp.ui.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.finschoolapp.R

@Preview
@Composable
fun AddMoney(
){
    Box() {
        Image(painter = painterResource(id = R.drawable.add_money_btn),
            contentDescription = "Добавить деньги в копилку",
            modifier = Modifier.clickable {  })
    }
}

