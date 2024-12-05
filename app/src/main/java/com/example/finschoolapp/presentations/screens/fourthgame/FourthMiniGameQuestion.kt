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
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.ui.theme.smallDescription

@Composable
fun FourthMiniGameQuestion(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    correctAnswers: Int,
    questionIndex: Int,
    questions: List<Question> = questionsList
) {
    val currentQuestion = questions[questionIndex]

    val palette = ThemeColors.LightTheme
    val dimensions = LocalDimensions.current

    currentQuestion.let { question ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = palette.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = question.questionText,
                style = smallDescription.copy(color = palette.secondary),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = modifier.height(dimensions.verticalSLarge))

            Row(
                horizontalArrangement = Arrangement.spacedBy(dimensions.horizontalSmall),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FourthMiniGameButton(
                    text = currentQuestion.answerLeft,
                    onClick = {
                        navController.navigate(
                            MainScreen.FourthMiniGameAnswer.createRoute(
                                questionIndex, 1, correctAnswers
                            )
                        )
                    }
                )

                FourthMiniGameButton(
                    text = currentQuestion.answerRight,
                    onClick = {
                        navController.navigate(
                            MainScreen.FourthMiniGameAnswer.createRoute(
                                questionIndex, 2, correctAnswers
                            )
                        )
                    }
                )
            }
        }
    }
}


@Preview
@Composable
fun QuestionFourthMiniGameScreenPreview() {
    FourthMiniGameQuestion(
        navController = rememberNavController(),
        correctAnswers = 0,
        questionIndex = 0,
        questions = questionsList
    )
}
