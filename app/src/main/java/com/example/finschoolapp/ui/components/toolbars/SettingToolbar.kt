package com.example.finschoolapp.ui.components.toolbars

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.mainHeader

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingToolbar(
    text: String,
    palette: ThemeColors,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(7.dp),
                title = {
                    Text(
                        text = text,
                        style = mainHeader,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = palette.thirdLight,
                    titleContentColor = palette.secondary
                ),
                actions = {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(55.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.settings),
                            contentDescription = "Настройки",
                            tint = palette.secondary
                        )
                    }
                }
            )
        })
    {
    }
}

@Preview
@Composable
fun SettingToolbarPreview() {
    SettingToolbar(text = "Прогресс", palette = ThemeColors.LightTheme)
}