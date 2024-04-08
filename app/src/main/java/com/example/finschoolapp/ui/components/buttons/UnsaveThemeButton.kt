package com.example.finschoolapp.ui.components.buttons

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.theme.ThemeColors

@Preview
@Composable
fun UnsaveThemeButton(
){
    IconButton(onClick = { /*TODO*/ },
    ) {Icon(
        painter = painterResource(id = R.drawable.saved),
        contentDescription = "Несохраненная тема",
        tint = ThemeColors.LightTheme.secondary
    )
    }
}

