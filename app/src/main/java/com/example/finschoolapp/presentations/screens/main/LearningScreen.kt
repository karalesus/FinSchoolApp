package com.example.finschoolapp.presentations.screens.main

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.finschoolapp.presentations.screens.slider.ThemeSliderScreen
import com.example.finschoolapp.presentations.viewModels.ArticleViewModel
import com.example.finschoolapp.presentations.viewModels.ModuleViewModel
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.ThemeColors
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LearningScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    moduleViewModel: ModuleViewModel,
    ) {
    val articleViewModel: ArticleViewModel = koinViewModel()
    val modules = moduleViewModel.modules.observeAsState(initial = emptyList())
    Scaffold(
        topBar = {
            TextToolbar(
                text = "Обучение",
                titleColor = ThemeColors.LightTheme.thirdLight,
                backgroundColor = ThemeColors.LightTheme.moduleBackgroundDark
            )
        },
    ) {
        ThemeSliderScreen(
            navController = navController,
            modules = modules.value,
            onContinueModuleButton = {
                navController.navigate("articleList/${modules.value.firstOrNull()?.id}")
            })
    }
}