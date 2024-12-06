package com.example.finschoolapp.presentations.screens.games.secondGame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.components.buttons.PrimaryButton
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.textViewBaseVariant
import com.example.finschoolapp.viewmodel.SecondMiniGameViewModel

@Composable
fun SecondMiniGameMainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    buttonRoute: String,
    viewModel: SecondMiniGameViewModel
) {
    val palette = ThemeColors.LightTheme
    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)

    val scrollState = rememberScrollState()

    viewModel.resetSpent()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = palette.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextToolbar(
            text = stringResource(id = R.string.label_second_and_third_mini_game),
            titleColor = palette.secondary,
            backgroundColor = palette.thirdLight
        )

        Image(
            painter = painterResource(id = R.drawable.image_character_lvl2),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
                .clip(roundedShape)
        )

        Box(
            modifier = modifier
                .padding(10.dp)
                .wrapContentSize()
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
            navController = navController,
            route = buttonRoute
        )

        Spacer(modifier = modifier.height(dimensions.verticalNormal))
    }
}