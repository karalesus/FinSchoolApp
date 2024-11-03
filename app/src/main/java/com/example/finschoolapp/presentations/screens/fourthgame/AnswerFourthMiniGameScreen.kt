package com.example.finschoolapp.presentations.screens.fourthgame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import com.example.finschoolapp.ui.components.FourthMiniGameAnswerComponent
import com.example.finschoolapp.ui.components.buttons.PrimaryButton
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.smallHeader
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@Composable
fun AnswerFourthMiniGameScreen(
    modifier: Modifier = Modifier,
    selectedButton: Int,
    isAnswerLeftCorrect: Boolean,
    questionText: String,
    answerButtonLeft: String,
    answerButtonRight: String,
    resultText: String,
    explanationText: String,
    navController: NavHostController,
    buttonRoute: String
) {
    val dimensions = LocalDimensions.current
    val palette = ThemeColors.LightTheme

    val isLeftButtonSelected = selectedButton == 1
    val isRightButtonSelected = selectedButton == 2
    val isCorrectAnswer =
        (isLeftButtonSelected && isAnswerLeftCorrect) || (isRightButtonSelected && !isAnswerLeftCorrect)

    val textColor = if (isCorrectAnswer) palette.correctBackground else palette.errorBackground

    val backgroundColorLeft = if (isLeftButtonSelected) {
        if (isAnswerLeftCorrect) palette.correctBackground else palette.errorBackground
    } else {
        palette.third
    }

    val backgroundColorRight = if (isRightButtonSelected) {
        if (!isAnswerLeftCorrect) palette.correctBackground else palette.errorBackground
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
            text = questionText,
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
                text = answerButtonLeft
            )

            FourthMiniGameAnswerComponent(
                backgroundColor = backgroundColorRight,
                text = answerButtonRight
            )
        }

        Spacer(modifier = modifier.height(dimensions.verticalSLarge))

        Text(
            text = resultText,
            style = textViewBaseVariant.copy(
                color = textColor,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = modifier.height(dimensions.verticalNormal))

        Text(
            text = explanationText,
            style = textViewBaseVariant.copy(
                color = textColor,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = modifier.height(dimensions.verticalNormal))

        PrimaryButton(
            modifier = modifier
                .width(300.dp)
                .height(35.dp),
            palette = palette,
            text = stringResource(id = R.string.button_continue),
            navController = navController,
            route = buttonRoute
        )
    }
}

@Preview
@Composable
fun PreviewAnswerFourthMiniGameScreen() {
    AnswerFourthMiniGameScreen(
        selectedButton = 2,
        isAnswerLeftCorrect = true,
        questionText = "Что выгоднее?",
        answerButtonLeft = "Вариант 1",
        answerButtonRight = "Вариант 2",
        resultText = "Результат",
        explanationText = "Пояснение",
        navController = rememberNavController(),
        buttonRoute = ""
    )
}
