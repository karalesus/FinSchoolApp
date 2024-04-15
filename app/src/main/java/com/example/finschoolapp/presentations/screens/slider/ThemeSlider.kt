package com.example.finschoolapp.presentations.screens.slider

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.components.buttons.ContinueModuleButton
import com.example.finschoolapp.ui.components.buttons.PrimaryButton
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.smallDescription
import com.example.finschoolapp.ui.theme.smallHeader

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ThemeSliderScreen(
    navController: NavHostController
) {
    val pagerState = rememberPagerState(pageCount = { modules.size })
//    Scaffold(
//        topBar = {
//            TextToolbar(
//                text = "Обучение",
//                titleColor = ThemeColors.LightTheme.thirdLight,
//                backgroundColor = ThemeColors.LightTheme.moduleBackgroundDark
//            )
//        },
//    )
//    {
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
            modifier = Modifier
                .width(318.dp),
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
