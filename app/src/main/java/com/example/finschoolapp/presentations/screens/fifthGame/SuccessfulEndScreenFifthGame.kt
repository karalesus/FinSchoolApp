package com.example.finschoolapp.presentations.screens.fifthGame

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import com.example.finschoolapp.ui.components.buttons.PrimaryButton
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.textViewBaseVariant


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SuccessfulEndScreenFifthGame(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    answerCount:Int
) {
    val dimensions = LocalDimensions.current
    val palette = ThemeColors.LightTheme
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)

    Scaffold(
        topBar = {
            TextToolbar(text = stringResource(id = R.string.label_results) ,
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
                imageVector = ImageVector.vectorResource(R.drawable.image_character_lvl5_1),

                contentDescription = "Character_lvl_5"
            )
            Spacer(modifier = modifier.height(20.dp))


            Text(
                modifier = modifier.padding(10.dp),
                text = stringResource(id = R.string.chosen_right_strategy)+" $answerCount раза!",
                textAlign = TextAlign.Center,
                style = textViewBaseVariant.copy(color = palette.secondary)
            )
            Spacer(modifier = modifier.height(dimensions.verticalSLarge))
            Text(
                modifier = modifier.padding(10.dp),
                text = stringResource(id = R.string.fifth_game_end),
                textAlign = TextAlign.Center,
                style = textViewBaseVariant.copy(color = palette.secondary)
            )
            Spacer(modifier = modifier.height(dimensions.verticalSLarge))

            Text(
                text = stringResource(id = R.string.increase_level),
                style = textViewBaseVariant.copy(color = palette.secondary, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(vertical = 8.dp).align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = modifier.height(dimensions.verticalSLarge))


            PrimaryButton(
                modifier = modifier
                    .fillMaxWidth(0.85f),
                palette = palette,
                text = stringResource(id = R.string.button_complete_module),
                navController = navController,
                route = ""
            )
        }
    }
}

@Preview
@Composable
fun SuccessfulEndScreenFifthGamePreview() {
    SuccessfulEndScreenFifthGame(navController = rememberNavController(),
        answerCount = 0)
}