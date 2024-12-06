package com.example.finschoolapp.presentations.screens.games.sixthGame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.navigation.navBars.BottomNavigationBar
import com.example.finschoolapp.ui.components.buttons.GameButton
import com.example.finschoolapp.ui.theme.textForSignUp
import com.example.finschoolapp.ui.theme.textViewBaseVariant


@Composable
fun BaseGameScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    scenario: ScenarioSixGame,
    buttonActions: List<() -> Unit>,
    cashAmount: Int,
) {
    val dimensions = LocalDimensions.current
    val palette = ThemeColors.LightTheme
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)

    require(scenario.buttonTexts.size == buttonActions.size) { "Button texts and actions must have the same size." }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier,
                navController = navController,
                palette = ThemeColors.LightTheme
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = palette.background)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            scenario.titleText?.let {
                Text(
                    text = it,
                    style = textForSignUp.copy(
                        color = palette.secondary,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(horizontal = 10.dp),
                    textAlign = TextAlign.Center
                )
            }


                Spacer(modifier = Modifier.height(20.dp))
            scenario.imageResId?.let { ImageVector.vectorResource(it) }?.let {
                Image(
                    imageVector = it,
                    contentDescription = "Character Image"
                )
            }



            scenario.text?.let {
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentHeight()
                        .clip(roundedShape)
                        .background(color = palette.thirdLight)
                        .padding(16.dp)
                ) {
                    Text(
                        text = it,
                        style = textForSignUp.copy(
                            color = palette.secondary
                        ),
                        modifier = Modifier.padding(horizontal = 10.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }


            Spacer(modifier = Modifier.height(20.dp))

            scenario.buttonTexts.forEachIndexed { index, buttonText ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GameButton(
                        modifier = Modifier.width(340.dp),
                        palette = palette,
                        text = buttonText,
                        onClick = buttonActions[index]
                    )

                    Spacer(modifier = Modifier.height(70.dp))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.second_wallet),
                    contentDescription = "Cash Icon",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "Наличные: $cashAmount",
                    style = textViewBaseVariant.copy(color = palette.secondary)
                )
            }
            }
        }
    }



@Preview
@Composable
fun BaseGameScreenPreview() {
    BaseGameScreen(
        navController = rememberNavController(),
        scenario = sixGameScenarios.get(0),
        buttonActions = listOf(
            { /* Действие для первой кнопки */ },
            { /* Действие для второй кнопки */ }
        ),
        cashAmount = 1000
    )
}
