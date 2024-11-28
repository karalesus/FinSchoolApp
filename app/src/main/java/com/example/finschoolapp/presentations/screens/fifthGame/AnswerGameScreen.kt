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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.presentations.screens.games.GameScreen
import com.example.finschoolapp.ui.components.buttons.PrimaryButton
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AnswerGameScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    scenario: FifthGameScenario,
    fromButton: Int
) {
    val dimensions = LocalDimensions.current
    val palette = ThemeColors.LightTheme
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)

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

            Image(

                imageVector =
                if( scenario.correctOptionIndex == fromButton) {
                    ImageVector.vectorResource(R.drawable.image_game_5_screen_1)
                }else{
                    ImageVector.vectorResource(R.drawable.image_game_5_screen_2)
                }

                ,
                contentDescription = "Character_lvl_4"
            )
            Spacer(modifier = modifier.height(20.dp))



            Text(
                modifier = modifier.padding(10.dp),
                text = scenario.result.get(fromButton),
                textAlign = TextAlign.Center,
                style = textViewBaseVariant.copy(color = palette.secondary)
            )
            Spacer(modifier = modifier.height(dimensions.verticalSLarge))
            Text(

                modifier = modifier.padding(10.dp),

                text =
                if( scenario.correctOptionIndex == fromButton) {
                    scenario.trueAnswer
                }else{
                     scenario.falseAnswer
                 },
                textAlign = TextAlign.Center,
                style = textViewBaseVariant.copy(
                if( scenario.correctOptionIndex == fromButton) {
                    Color(0xFF366A20)
//                    palette.secondary
                }else{
                    Color(0xFFBA1A1A) },
                    fontWeight = FontWeight.Bold

                )
            )



            Spacer(modifier = modifier.height(dimensions.verticalSLarge))
            PrimaryButton(
                modifier = modifier
                    .fillMaxHeight(0.12f)
                    .fillMaxWidth(0.85f),

                palette = palette,
                text = stringResource(id = R.string.button_continue),

                navController = navController,
                route = GameScreen.Game1Screen1.route
            )

        }
    }
}

@Preview
@Composable
fun AnswerGameScreenPreview() {
    AnswerGameScreen(navController = rememberNavController(),
        scenario = scenarios.get(0),
        fromButton = 2)
}