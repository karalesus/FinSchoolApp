package com.example.finschoolapp.ui.components.toolbars

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.mainHeader

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingToolbar(
    text: String,
    palette: ThemeColors,
    navController: NavHostController,
) {
    TopAppBar(
        title = {
            Text(
                text = text,
                style = mainHeader,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = palette.thirdLight,
            titleContentColor = palette.secondary
        ),
        actions = {
            IconButton(
                onClick = {
                    navController.navigate(MainScreen.Settings.route)
                },
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
}

@Preview
@Composable
fun SettingToolbarPreview() {
    SettingToolbar(
        text = "Прогресс",
        palette = ThemeColors.LightTheme,
        navController = rememberNavController()
    )
}