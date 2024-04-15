package com.example.finschoolapp.presentations.screens.slider

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.ui.components.buttons.ContinueModuleButton
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.smallDescription
import com.example.finschoolapp.ui.theme.smallHeader

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ThemeSliderScreen(
    navController: NavHostController
) {
    val pagerState = rememberPagerState(pageCount = { modules.size })
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ThemeColors.LightTheme.moduleBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(state = pagerState) { moduleIndex: Int ->
            SingleModule(module = modules[moduleIndex])
        }
        // TODO: add progress indicator

        Spacer(
            modifier = Modifier.size(16.dp)
        )
        ContinueModuleButton(
            modifier = Modifier,
            palette = ThemeColors.LightTheme,
            text = "Продолжить",
            onButtonClick = {
                //TODO:  navHostController.navigate()
            }
        )
    }
}

@Preview
@Composable
fun ThemeSliderScreenPreview() {
    ThemeSliderScreen(navController = rememberNavController())
}
