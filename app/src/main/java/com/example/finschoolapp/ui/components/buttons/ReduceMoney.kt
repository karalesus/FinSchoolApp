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
fun ReduceMoney(
){
    Box() {
        Image(painter = painterResource(id = R.drawable.reduce_money_btn),
            contentDescription = "Убрать деньги из копилки",
            modifier = Modifier.clickable {  })
    }
}

