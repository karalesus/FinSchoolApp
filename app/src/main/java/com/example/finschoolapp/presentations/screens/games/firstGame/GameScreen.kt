package com.example.finschoolapp.presentations.screens.games.firstGame

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.ui.components.buttons.RightAnswerSmallButtonForGame
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.textViewBaseVariant


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    scenario: GameScenario,
    onClick: (Int) -> Unit,
    TomMoney:Int
) {

    val dimensions = LocalDimensions.current
    val focusManager = LocalFocusManager.current
    val palette = ThemeColors.LightTheme
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)
    val confettiVisible = remember { mutableStateOf(false) }



    Scaffold(
        topBar = {
            TextToolbar(text =scenario.day,
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

            Text(text = "У Тома $TomMoney рублей")
            Spacer(modifier = modifier.height(20.dp))

            Image(
                imageVector = ImageVector.vectorResource(scenario.image),

                contentDescription = "Character_lvl_1"
            )

            Spacer(modifier = modifier.height(20.dp))

            Box(

                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxWidth(0.85f)
                    .clip(roundedShape)
                    .background(color = palette.thirdLight)
                    .padding(vertical = dimensions.verticalNormalPadding)
            ) {

                Text(
                    modifier = modifier.padding(10.dp),
                    text = scenario.situation,
                    style = textViewBaseVariant.copy(color = palette.secondary)
                )
            }


            Spacer(modifier = modifier.height(dimensions.verticalSLarge))

            Text(
                text = scenario.question,
                style = textViewBaseVariant.copy(color = palette.secondary, fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = modifier.height(dimensions.verticalSLarge))
           Row(

               modifier = modifier
               .background(color = palette.background),
               horizontalArrangement =Arrangement.Center,
               verticalAlignment = Alignment.Bottom,
               ) {

               RightAnswerSmallButtonForGame(
                   modifier = modifier
                       .fillMaxHeight(0.12f)
                       .fillMaxWidth(0.41f)
                       .shadow(elevation = 7.dp, shape = RoundedCornerShape(30)),

                   palette = palette,
                   text = scenario.options.get(0),
                   onButtonClick = {
//                       confettiVisible.value = !confettiVisible.value
                       focusManager.clearFocus()
                       onClick(scenario.money.get(0))
                   },
                   route = MainScreen.AddGoal.route
               )
               
//               ConfettiAnimation(visible = confettiVisible.value)


               Spacer(modifier = modifier.width(dimensions.verticalNormal)  )

               RightAnswerSmallButtonForGame(
                   modifier = modifier
                       .shadow(
                           elevation = 7.dp,
                           shape = RoundedCornerShape(30)
                       )
                       .wrapContentSize()
                       .fillMaxHeight(0.12f)
                       .fillMaxWidth(0.74f),

                   palette = palette,
                   text = scenario.options.get(1),

                   onButtonClick = {
                       focusManager.clearFocus()
                       onClick(scenario.money.get(1))
                   },
                   route = MainScreen.AddGoal.route
               )

           }

            if(scenario.options.size ==6 ){
                Spacer(modifier = modifier.height(dimensions.verticalSLarge))



                Row( modifier = modifier
                    .background(color = palette.background),
                    horizontalArrangement =Arrangement.Center,
                    verticalAlignment = Alignment.Top
                ) {

                    RightAnswerSmallButtonForGame(
                        modifier = modifier
                            .shadow(elevation = 7.dp, shape = RoundedCornerShape(30))
                            .fillMaxHeight(0.14f)
                            .fillMaxWidth(0.41f),

                        palette = palette,
                        text = scenario.options.get(2),
                        onButtonClick = {
                            focusManager.clearFocus()
                            onClick(scenario.money.get(2))
                        },

                        route = MainScreen.AddGoal.route

                    )


                    Spacer(modifier = modifier.width(dimensions.verticalNormal)  )

                    RightAnswerSmallButtonForGame(
                        modifier = modifier
                            .shadow(
                                elevation = 7.dp,
                                shape = RoundedCornerShape(30)
                            )
                            .fillMaxHeight(0.14f)
                            .fillMaxWidth(0.74f),

                        palette = palette,
                        text = scenario.options.get(3),

                        onButtonClick = {
                            focusManager.clearFocus()
                            onClick(scenario.money.get(3))
                        },
                        route = MainScreen.AddGoal.route
                    )

                }
                Spacer(modifier = modifier.height(dimensions.verticalSLarge))



                Row( modifier = modifier
                    .background(color = palette.background),
                    horizontalArrangement =Arrangement.Center,
                    verticalAlignment = Alignment.Top
                ) {

                    RightAnswerSmallButtonForGame(
                        modifier = modifier
                            .shadow(elevation = 7.dp, shape = RoundedCornerShape(30))
                            .fillMaxHeight(0.18f)
                            .fillMaxWidth(0.41f),

                        palette = palette,
                        text = scenario.options.get(4),
                        onButtonClick = {
                            focusManager.clearFocus()
                            onClick(scenario.money.get(4))
                        },

                        route = MainScreen.AddGoal.route

                    )


                    Spacer(modifier = modifier.width(dimensions.verticalNormal)  )

                    RightAnswerSmallButtonForGame(
                        modifier = modifier
                            .shadow(
                                elevation = 7.dp,
                                shape = RoundedCornerShape(30)
                            )
                            .fillMaxHeight(0.18f)
                            .fillMaxWidth(0.74f),

                        palette = palette,
                        text = scenario.options.get(5),

                        onButtonClick = {
                            focusManager.clearFocus()
                            onClick(scenario.money.get(5))
                        },
                        route = MainScreen.AddGoal.route
                    )

                }
            }
            if(scenario.options.size == 3){
                Spacer(modifier = modifier.height(dimensions.verticalSLarge))



                Row( modifier = modifier
                    .background(color = palette.background),
                    horizontalArrangement =Arrangement.Center,
                    verticalAlignment = Alignment.Top
                ) {

                    RightAnswerSmallButtonForGame(
                        modifier = modifier
                            .shadow(elevation = 7.dp, shape = RoundedCornerShape(30))
                            .fillMaxHeight(0.17f)
                            .fillMaxWidth(0.41f),

                        palette = palette,
                        text = scenario.options.get(2),
                        onButtonClick = {
                            focusManager.clearFocus()
                            onClick(scenario.money.get(2))
                        },
                        route = MainScreen.AddGoal.route

                    )
                }
            }
        }
    }
}



@Preview
@Composable
fun MondayFunPreview() {
    GameScreen(
        onClick = {},
        scenario = scenarios.get(6),
        TomMoney = 0
    )
}




