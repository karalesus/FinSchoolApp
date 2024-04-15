package com.example.finschoolapp.ui.components.toolbars

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.mainHeader

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextToolbar(
    text: String,
    titleColor: Color,
    backgroundColor: Color
) {
    TopAppBar(
        modifier = Modifier
            .shadow(elevation = 10.dp),
        title = {
            Text(
                text = text,
                style = mainHeader,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor,
            titleContentColor = titleColor
        )
    )
}

@Preview
@Composable
fun TextToolbarPreview() {
    val palette = ThemeColors.LightTheme
    TextToolbar(
        text = "Ура!",
        titleColor = palette.secondary,
        backgroundColor = palette.thirdLight
    )
}