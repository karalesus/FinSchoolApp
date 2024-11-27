package com.example.finschoolapp.presentations.screens.fourthgame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.ui.components.FourthMiniGameAnswerComponent
import com.example.finschoolapp.ui.components.buttons.NextQuestionButton
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.smallHeader
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@Composable
fun FourthMiniGameAnswer(
    modifier: Modifier = Modifier,
    questionIndex: Int,
    selectedButton: Int,
    correctAnswers: Int,
    navController: NavHostController,
    questions: List<Question> = questionsList
) {
    val palette = ThemeColors.LightTheme
    val dimensions = LocalDimensions.current

    val currentQuestion = questions[questionIndex]
    val isLeftButtonSelected = selectedButton == 1
    val isRightButtonSelected = selectedButton == 2

    val isCorrectAnswer =
        (isLeftButtonSelected && currentQuestion.isAnswerLeftCorrect) ||
                (isRightButtonSelected && !currentQuestion.isAnswerLeftCorrect)

    val updatedCorrectAnswers = if (isCorrectAnswer) correctAnswers + 1 else correctAnswers

    val textColor = if (isCorrectAnswer) palette.correctBackground else palette.errorBackground

    val backgroundColorLeft = if (isLeftButtonSelected) {
        if (currentQuestion.isAnswerLeftCorrect) palette.correctBackground else palette.errorBackground
    } else {
        palette.third
    }

    val backgroundColorRight = if (isRightButtonSelected) {
        if (!currentQuestion.isAnswerLeftCorrect) palette.correctBackground else palette.errorBackground
    } else {
        palette.third
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = palette.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = currentQuestion.questionText,
            style = smallHeader.copy(color = palette.secondary),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = modifier.height(dimensions.verticalSLarge))

        Row(
            horizontalArrangement = Arrangement.spacedBy(dimensions.horizontalSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FourthMiniGameAnswerComponent(
                backgroundColor = backgroundColorLeft,
                text = currentQuestion.answerLeft
            )

            FourthMiniGameAnswerComponent(
                backgroundColor = backgroundColorRight,
                text = currentQuestion.answerRight
            )
        }

        Spacer(modifier = modifier.height(dimensions.verticalSLarge))

        Text(
            modifier = modifier.padding(start = 32.dp, end = 32.dp),
            text = currentQuestion.explanation,
            style = textViewBaseVariant.copy(
                color = textColor,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = modifier.height(dimensions.verticalNormal))

        NextQuestionButton(
            modifier = modifier
                .width(300.dp)
                .height(35.dp),
            palette = palette,
            text = stringResource(id = R.string.button_continue),
            onClick = {
                val nextRoute = if (questionIndex + 1 < questions.size) {
                    MainScreen.FourthMiniGameQuestion.createRoute(questionIndex + 1, updatedCorrectAnswers)
                } else {
                    MainScreen.FourthMiniGameFinish.createRoute(updatedCorrectAnswers, questions.size)
                }
                navController.navigate(nextRoute)
            }
        )
    }
}

@Preview
@Composable
fun PreviewAnswerFourthMiniGameScreen() {
    FourthMiniGameAnswer(
        questionIndex = 0,
        selectedButton = 1,
        correctAnswers = 0,
        navController = rememberNavController()
    )
}
