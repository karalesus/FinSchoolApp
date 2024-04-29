package com.example.finschoolapp.presentations.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.navigation.main.MainScreen
import com.example.finschoolapp.ui.components.buttons.PrimaryButton
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.smallHeader

@Composable
fun WalletScreen(modifier: Modifier = Modifier,
                 navController: NavHostController
) {

    val dimensions = LocalDimensions.current

    val palette = ThemeColors.LightTheme

    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = palette.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextToolbar(
            text = stringResource(id = R.string.label_wallet),
            titleColor = palette.secondary,
            backgroundColor = palette.thirdLight
        )

        Spacer(modifier = modifier.height(dimensions.verticalXLarge))

        Box(
            modifier = modifier
                .background(color = palette.background)
                .size(height = 237.dp, width = 237.dp)
                .clip(roundedShape)
        )

        Spacer(modifier = modifier.height(dimensions.verticalNormal))

        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .background(color = palette.background)
                .size(height = 67.dp, width = 237.dp)
                .clip(roundedShape)
        ) {
            Text(
                text = stringResource(id = R.string.label_no_goal),
                style = smallHeader.copy(color = palette.secondary),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = modifier.height(dimensions.verticalNormal))

        PrimaryButton(
            modifier = modifier.size
                (width = 296.dp, height = 46.dp),
            palette = ThemeColors.LightTheme,
            text = stringResource(id = R.string.button_add_goal),
            navController = navController,
            route = MainScreen.AddGoal.route
        )
    }
}


@Composable
@Preview
fun WalletScreenPreview() {
    WalletScreen(navController = rememberNavController())
}