package com.example.finschoolapp.presentations.screens.secondgame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.finschoolapp.ui.components.buttons.PrimaryButton
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors

@Composable
fun QuestionScreen(
    modifier: Modifier = Modifier,
    questionTitle: String,
    questionText: String,
    answers: List<String>,
    imageResId: Int,
    navController: NavHostController,
    nextRoute: String
) {
    val palette = ThemeColors.LightTheme
    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = palette.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextToolbar(
            text = questionTitle,
            titleColor = palette.secondary,
            backgroundColor = palette.thirdLight
        )

        Spacer(modifier = modifier.height(69.dp))

        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .fillMaxWidth()
                .clip(roundedShape)
        )

        Spacer(modifier = modifier.height(dimensions.verticalSLarge))

        Text(
            text = questionText,
            color = ThemeColors.LightTheme.secondary,
            fontWeight = FontWeight.Bold
        )

        answers.forEach { answer ->
            Spacer(modifier = modifier.height(dimensions.verticalSLarge))
            PrimaryButton(
                modifier = modifier.size(height = 40.dp, width = 320.dp),
                palette = ThemeColors.LightTheme,
                text = answer,
                navController = navController,
                route = nextRoute
            )
        }
    }
}
