package com.example.finschoolapp.presentations.screens.secondgame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.example.finschoolapp.ui.theme.smallDescription
import com.example.finschoolapp.ui.theme.smallHeader
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@Composable
fun SecondMiniGameMainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    buttonRoute: String
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
            text = stringResource(id = R.string.label_second_and_third_mini_game),
            titleColor = palette.secondary,
            backgroundColor = palette.thirdLight
        )

        Spacer(modifier = modifier.height(24.dp))

        Image(
            painter = painterResource(id = R.drawable.second_mini_game_main_image),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
                .clip(roundedShape)
        )

        Spacer(modifier = modifier.height(dimensions.verticalSLarge))

        Box (modifier = modifier
            .fillMaxHeight(0.52f)
            .fillMaxWidth(0.9f)
            .clip(roundedShape)
            .background(color = palette.thirdLight)
            ) {
            Text(
                modifier = modifier.padding(10.dp),
                text = stringResource(id = R.string.task_second_and_third_mini_game),
                style = textViewBaseVariant.copy(color = palette.secondary),
                textAlign = TextAlign.Left
            )
        }

        Spacer(modifier = modifier.height(dimensions.verticalSLarge))

        PrimaryButton(
            modifier = modifier.size(height = 40.dp, width = 320.dp),
            palette = ThemeColors.LightTheme,
            text = stringResource(id = R.string.button_continue),
            navController = rememberNavController(),
            route = ""
        )
    }
}

@Preview
@Composable
fun SecondMiniGamePreview() {
    SecondMiniGameMainScreen(
        navController = rememberNavController(),
        buttonRoute = ""
    )
}