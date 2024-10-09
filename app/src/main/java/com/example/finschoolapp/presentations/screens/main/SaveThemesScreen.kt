package com.example.finschoolapp.presentations.screens.main
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.navigation.navBars.BottomNavigationBar
import com.example.finschoolapp.ui.components.toolbars.BackToolbar
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.secondary
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@Composable
fun SaveThemesScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val palette = ThemeColors.LightTheme
    Scaffold(
        topBar = {
            BackToolbar(
                text = stringResource(id = R.string.saved_topics),
                palette = ThemeColors.LightTheme,
                navController = navController
            )
        },
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier,
                navController = navController,
                palette = ThemeColors.LightTheme
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = palette.background),
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .height(35.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.save_theme_btn),
                    contentDescription = "Achievement Icon",
                    tint = secondary
                )
                Spacer(modifier = Modifier.width(10.dp))

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.saved_module),
                        style = textViewBaseVariant,
                        color = palette.secondary
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.line_green),
                contentDescription = null,

            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun SaveThemesScreenPreview() {
    val navController = rememberNavController()
    SaveThemesScreen(navController = navController)
}
