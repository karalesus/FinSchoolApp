package com.example.finschoolapp.presentations.screens.fourthgame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.ui.components.buttons.FourthMiniGameButton
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.smallHeader

@Composable
fun QuestionFourthMiniGameScreen(
    modifier: Modifier = Modifier,
    questionText: String,
    answerButtonLeft: String,
    answerButtonRight: String,
    navController: NavHostController,
    isAnswerLeftCorrect: Boolean,
) {
    val dimensions = LocalDimensions.current
    val palette = ThemeColors.LightTheme

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = palette.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = questionText,
            style = smallHeader.copy(color = palette.secondary),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = modifier.height(dimensions.verticalSLarge))

        Row(
            horizontalArrangement = Arrangement.spacedBy(dimensions.horizontalSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FourthMiniGameButton(
                text = answerButtonLeft,
                onClick = { navController.navigate("answer_fourth_mini_game_screen/${isAnswerLeftCorrect}") },
            )

            FourthMiniGameButton(
                text = answerButtonRight,
                onClick = { navController.navigate("answer_fourth_mini_game_screen/${!isAnswerLeftCorrect}") },
            )
        }
    }
}


@Preview
@Composable
fun QuestionFourthMiniGameScreenPreview() {
    QuestionFourthMiniGameScreen(
        questionText = "Что выгоднее?",
        answerButtonLeft = "Вариант 1",
        answerButtonRight = "Вариант 2",
        navController = rememberNavController(),
        isAnswerLeftCorrect = true
    )
}
