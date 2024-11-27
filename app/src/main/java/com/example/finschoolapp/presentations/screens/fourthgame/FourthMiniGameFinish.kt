package com.example.finschoolapp.presentations.screens.fourthgame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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
fun FourthMiniGameFinish(
    modifier: Modifier = Modifier,
    correctAnswers: Int,
    navController: NavHostController
) {
    val dimensions = LocalDimensions.current
    val palette = ThemeColors.LightTheme

    val totalQuestions = questionsList.size

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = palette.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextToolbar(
            text = "ИТОГИ",
            titleColor = palette.secondary,
            backgroundColor = palette.thirdLight

        )

        Spacer(modifier = modifier.height(dimensions.verticalSLarge))

        Text(
            text = stringResource(id = R.string.finish_fourth_mini_game),
            style = smallHeader.copy(color = palette.secondary),
            textAlign = TextAlign.Center
        )

        if (correctAnswers > 4) {
            Spacer(modifier = modifier.height(dimensions.verticalSLarge))

            Image(
                painter = painterResource(id = R.drawable.fourth_mini_game_finish),
                contentDescription = "The finish of the fourth mini-game",
                modifier = modifier
                    .size(300.dp)
            )

            Spacer(modifier = modifier.height(dimensions.verticalSLarge))

            Text(
                text = "Вы набрали $correctAnswers из $totalQuestions баллов.\nТеперь Толик разбирается в кредитовании! Поздравляем!",
                style = smallHeader.copy(color = palette.secondary),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = modifier.height(dimensions.verticalSLarge))

            PrimaryButton(
                modifier = modifier
                    .width(300.dp)
                    .height(35.dp),
                palette = palette,
                text = stringResource(id = R.string.button_continue),
                navController = navController,
                route = MainScreen.Learning.route
            )
        } else {
            Text(
                text = "Вы набрали $correctAnswers из $totalQuestions баллов.\n\nНеобходимо заново пройти уровень!",
                style = smallHeader.copy(color = palette.secondary),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = modifier.height(dimensions.verticalMLarge))

            PrimaryButton(
                modifier = modifier
                    .width(300.dp)
                    .height(35.dp),
                palette = palette,
                text = "Начать заново",
                navController = navController,
                route = MainScreen.FourthMiniGame.route
            )
        }
    }
}

@Composable
@Preview
fun FourthMiniGameFinishPreview() {
    FourthMiniGameFinish(correctAnswers = 6, navController = rememberNavController())
}
