package com.example.finschoolapp.ui.components.ProgressLine

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finschoolapp.ui.theme.mainBackground
import com.example.finschoolapp.ui.theme.moduleBackground
import com.example.finschoolapp.ui.theme.smallDescription
import com.example.finschoolapp.ui.theme.thirdLight


@Preview
@Composable
fun ProgressLine(title: String, progress: Float, image: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp), // Отступы между строками
        colors = CardDefaults.cardColors(
            containerColor = moduleBackground.copy(0.5f),
        ),
        border = BorderStroke(3.dp, moduleBackground.copy(0.6f)),
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .height(25.dp), // Увеличена высота строки
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // Размещаем элементы по краям
        ) {
            Icon(
                painter = painterResource(id = image), // Замените на нужную иконку
                contentDescription = "Achievement Icon",
                //modifier = Modifier.size(40.dp), // Увеличен размер иконки
                tint = moduleBackground // Замените на нужный цвет иконки
            )
            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Top // Размещаем элементы в верхней части
            ) {
                Text(
                    text = title,
                    color = thirdLight,
                    style = smallDescription.copy(),
                    modifier = Modifier.padding(bottom = 4.dp) // Отступ снизу для текста
                )
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .clip(RoundedCornerShape(2.dp)), // Высота линии прогресса
                    color = thirdLight, // Цвет индикатора прогресса
                    trackColor = mainBackground
                )
            }
        }
    }
}
