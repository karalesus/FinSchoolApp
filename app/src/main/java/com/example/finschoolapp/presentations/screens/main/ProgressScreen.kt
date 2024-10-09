package com.example.finschoolapp.presentations.screens.main

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.navigation.navBars.BottomNavigationBar
import com.example.finschoolapp.ui.components.ProgressLine.ProgressLine
import com.example.finschoolapp.ui.components.buttons.MainButtonOutlined
import com.example.finschoolapp.ui.components.buttons.SaveThemeButton
import com.example.finschoolapp.ui.components.toolbars.SettingToolbar
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.mainBackground
import com.example.finschoolapp.ui.theme.moduleBackground
import com.example.finschoolapp.ui.theme.smallDescription
import com.example.finschoolapp.ui.theme.smallHeader
import com.example.finschoolapp.ui.theme.smallHeaderLight
import com.example.finschoolapp.ui.theme.textViewBaseVariant
import com.example.finschoolapp.ui.theme.thirdLight

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProgressScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val palette = ThemeColors.LightTheme
    Scaffold(
        topBar = {
            SettingToolbar(
                text = stringResource(id = R.string.label_progress),
                palette = ThemeColors.LightTheme,
                navController = navController
            )
        },
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier,
                navController = navController,
                palette = ThemeColors.LightTheme
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Учитываем отступы, чтобы избежать наложения
                .background(color = palette.background),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f) // Занимает оставшееся пространство
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp), // Устанавливаем расстояние между элементами
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(20.dp)
                )// Общий отступ для всей колонки)
                { // Добавляем Column для вертикального размещения

                    Text(
                        //modifier = Modifier.padding(10.dp),
                        text = stringResource(id = R.string.label_username),
                        style = textViewBaseVariant.copy(color = palette.secondary)
                    )
                    Text(
                        // modifier = Modifier.padding(10.dp),
                        text = stringResource(id = R.string.label_level),
                        style = smallHeader.copy(color = palette.secondary, fontSize = 16.sp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.image_character_lvl1_1), // Замените на ваш ресурс
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp) // Задайте размер изображения
                        .align(Alignment.CenterEnd) // Выравнивание по верхнему краю

                )

                Image(
                    painter = painterResource(id = R.drawable.line_green), // Замените на ваш ресурс
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.BottomCenter) // Выравнивание по нижнему краю

                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Занимает оставшееся пространство
            ) {
                Column {

                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = mainBackground,
                        ),
                        border = BorderStroke(3.dp, moduleBackground.copy(0.6f)),
                        shape = RoundedCornerShape(16.dp), // Закругление углов
                        elevation = CardDefaults.cardElevation(
                            //тень
                            defaultElevation = 60.dp,
                        ),
                        modifier = Modifier.padding(16.dp) // Отступы для всего Card
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp) // Отступы внутри колонки
                        ) {
                            Text(
                                text = stringResource(id = R.string.progress),
                                style = textViewBaseVariant.copy(
                                    color = moduleBackground,
                                    fontSize = 18.sp,
                                ),
                                //style = MaterialTheme.typography.h6, // Или любой другой стиль
                                modifier = Modifier
                                    .padding(bottom = 16.dp)
                                    .graphicsLayer(alpha = 0.5f)
                            )

                            // Линии прогресса
                            ProgressLine(
                                stringResource(id = R.string.achievement_1),
                                0.7f,
                                R.drawable.achievement_icon_1
                            )
                            ProgressLine(
                                stringResource(id = R.string.achievement_2),
                                0.5f,
                                R.drawable.achievement_icon_2
                            )
                            ProgressLine(
                                stringResource(id = R.string.achievement_3),
                                0.3f,
                                R.drawable.achievement_icon_3
                            )
                            ProgressLine(
                                stringResource(id = R.string.achievement_4),
                                0.9f,
                                R.drawable.achievement_icon_4
                            )
                        }
                    }

                    SaveThemeButton(
                        modifier = modifier
                            .padding(10.dp)
                            .shadow(
                                elevation = 4.dp,
                                shape = RoundedCornerShape(30)
                            ),
                        palette = palette,
                        text = stringResource(id = R.string.saved_topics),
                        onButtonClick = {
                        })
                }
            }
        }
    }
}




@Composable
@Preview
fun ProgressScreenPreview() {
    ProgressScreen(navController = rememberNavController())
}
