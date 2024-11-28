package com.example.finschoolapp.presentations.screens.fifthGame

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.presentations.screens.games.GameScenario
import com.example.finschoolapp.presentations.screens.games.GameScreen
import com.example.finschoolapp.ui.components.buttons.PrimaryButton
import com.example.finschoolapp.ui.components.buttons.RightAnswerSmallButtonForGame
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QuestionGameScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    scenario: FifthGameScenario,
    onClick: (Int) -> Unit,

    ) {
    val dimensions = LocalDimensions.current
    val palette = ThemeColors.LightTheme
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)
    val focusManager = LocalFocusManager.current


    Scaffold(
        topBar = {
            TextToolbar(text = stringResource(id = R.string.investing) ,
                titleColor = palette.secondary,
                backgroundColor = palette.thirdLight)
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = palette.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                modifier = modifier.padding(10.dp),
                text = scenario.situation,
                textAlign = TextAlign.Center,
                style = textViewBaseVariant.copy(color = palette.secondary)
            )
            Spacer(modifier = modifier.height(20.dp))



            Text(
                text = stringResource(id = R.string.fifth_game_1_text_question),
                style = textViewBaseVariant.copy(color = palette.secondary, fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )





            Spacer(modifier = modifier.height(dimensions.verticalSLarge))





            PrimaryButton(
                modifier = modifier
                    .fillMaxHeight(0.08f)
                    .fillMaxWidth(0.85f),

                palette = palette,
                text = scenario.options.get(0),

                navController = navController,
                route = GameScreen.Game1Screen1.route
            )
            Spacer(modifier = modifier.height(dimensions.verticalSLarge))
            PrimaryButton(
                modifier = modifier
                    .fillMaxHeight(0.09f)
                    .fillMaxWidth(0.85f),

                palette = palette,
                text = scenario.options.get(1),

                navController = navController,
                route = GameScreen.Game1Screen1.route
            )
            Spacer(modifier = modifier.height(dimensions.verticalSLarge))
            PrimaryButton(
                modifier = modifier
                    .fillMaxHeight(0.10f)
                    .fillMaxWidth(0.85f),

                palette = palette,
                text = scenario.options.get(2),

                navController = navController,
                route = GameScreen.Game1Screen1.route
            )
            Spacer(modifier = modifier.height(dimensions.verticalSLarge))
            PrimaryButton(
                modifier = modifier
                    .fillMaxHeight(0.12f)
                    .fillMaxWidth(0.85f),

                palette = palette,
                text = scenario.options.get(3),

                navController = navController,
                route = ""
            )

        }
    }
}

@Preview
@Composable
fun QuestionGameScreenPreview() {
    QuestionGameScreen(
        navController = rememberNavController(),
        scenario = scenarios.get(0),
        onClick = {})
}