package com.example.finschoolapp.presentations.screens.secondgame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.components.buttons.PrimaryButton
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.viewmodel.SecondMiniGameViewModel

@Composable
fun FinalScreen(
    modifier: Modifier = Modifier,
    viewModel: SecondMiniGameViewModel,
    navController: NavHostController,
    nextRoute: String
) {
    val totalSpent = viewModel.totalSpent.value

    val resultText = if (totalSpent > 25000) {
        "Что ж, кажется Тому не удастся накопить на ноутбук в скором времени...\n" +
                "\n" +
                "Стоит бережнее относиться к своим деньгам. Будьте умерены в своих желаниях и учитесь экономить!"
    } else {
        "Том приобретает свой ноутбук спустя пару месяцев! \n" +
                "\n" +
                "Все благодаря тому, что ты помог ему сэкономить деньги, молодец!"
    }

    val buttonText = if (totalSpent > 25000) {
        stringResource(id = R.string.button_restart_level)
    } else {
        stringResource(id = R.string.button_finish_module)
    }

    val palette = ThemeColors.LightTheme
    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)
    val scrollState = rememberScrollState()


    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = palette.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextToolbar(
            text = stringResource(id = R.string.label_results),
            titleColor = palette.secondary,
            backgroundColor = palette.thirdLight
        )

        Spacer(modifier = modifier.height(69.dp))

        Image(
            painter = painterResource(id = R.drawable.image_character_lvl2_final),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .fillMaxWidth()
                .clip(roundedShape)
        )

        Spacer(modifier = modifier.height(dimensions.verticalSLarge))

        Text(
            modifier = modifier.padding(20.dp),
            text = stringResource(id = R.string.spent_text),
            color = ThemeColors.LightTheme.secondary,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = modifier.height(dimensions.verticalSLarge))

        Text(
            modifier = modifier.padding(20.dp),
            text = "$totalSpent р.",
            color = ThemeColors.LightTheme.secondary,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = modifier.height(dimensions.verticalSLarge))

        Text(
            modifier = modifier.padding(20.dp),
            text = resultText,
            color = ThemeColors.LightTheme.secondary,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        PrimaryButton(
            modifier = modifier.size(height = 40.dp, width = 320.dp).padding(10.dp),
            palette = ThemeColors.LightTheme,
            text = buttonText,
            navController = navController,
            route = if (totalSpent > 25000) "main_screen" else nextRoute
        )
    }
}
