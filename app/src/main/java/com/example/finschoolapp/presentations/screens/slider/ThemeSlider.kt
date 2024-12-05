package com.example.finschoolapp.presentations.screens.slider

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.finschoolapp.navigation.articles.ArticleScreen
import com.example.finschoolapp.ui.components.buttons.ContinueModuleButton
import com.example.finschoolapp.ui.theme.ThemeColors

@Composable
fun ThemeSliderScreen(
    navController: NavHostController,
    onContinueModuleButton: () -> Unit,
    modules: List<Module>
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

        Spacer(
            modifier = Modifier.size(16.dp)
        )
        ContinueModuleButton(
            modifier = Modifier,
            palette = ThemeColors.LightTheme,
            text = "Продолжить",
            onButtonClick = {
                val currentIndex = pagerState.currentPage
                if (modules.isNotEmpty() && currentIndex in modules.indices) {
                    val moduleId = modules[currentIndex].id
                    println("Navigating to Articles/articles_screen with moduleId: $moduleId") // Лог для проверки
                    println("Navigating to ArticlesList")
                    Log.d("NavController", "Graph: ${navController.graph}")
                    navController.navigate("${ArticleScreen.ArticleList.route}/$moduleId")
                } else {
                    println("Invalid module index or empty modules list")
                }
            }
        )
    }
}

