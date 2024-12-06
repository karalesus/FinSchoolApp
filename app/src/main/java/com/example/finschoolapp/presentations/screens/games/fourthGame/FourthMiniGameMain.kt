package com.example.finschoolapp.presentations.screens.games.fourthGame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.ui.components.buttons.PrimaryButton
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.smallHeader

@Composable
fun FourthMiniGameMain(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val dimensions = LocalDimensions.current
    val palette = ThemeColors.LightTheme

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = palette.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextToolbar(
            text = stringResource(id = R.string.label_fourth_mini_game),
            titleColor = palette.secondary,
            backgroundColor = palette.thirdLight

        )

        Spacer(modifier = modifier.height(dimensions.verticalSLarge))

        Image(
            painter = painterResource(id = R.drawable.fourth_mini_game_main),
            contentDescription = "The icon of the fourth mini-game",
            modifier = modifier
                .size(300.dp)
        )

        Spacer(modifier = modifier.height(dimensions.verticalSLarge))

        Text(
            text = stringResource(id = R.string.task_fourth_mini_game),
            style = smallHeader.copy(color = palette.secondary),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = modifier.height(dimensions.verticalSLarge))

        PrimaryButton(
            modifier = modifier
                .width(300.dp)
                .height(40.dp),
            palette = palette,
            text = stringResource(id = R.string.button_continue),
            navController = navController,
            route = MainScreen.FourthMiniGameQuestion.createRoute(0, 0)
        )
    }
}

@Preview
@Composable
fun FourthMiniGameMainScreenPreview() {
    FourthMiniGameMain(
        navController = rememberNavController()
    )
}