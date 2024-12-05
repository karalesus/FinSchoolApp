package com.example.finschoolapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@Composable
fun FourthMiniGameAnswerComponent(
    backgroundColor: Color,
    text: String
) {
    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)

    Box(
        modifier = Modifier
            .padding(all = 4.dp)
            .width(150.dp)
            .heightIn(min = 150.dp)
            .background(color = backgroundColor, shape = roundedShape)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = textViewBaseVariant,
            color = ThemeColors.LightTheme.thirdLight
        )
    }
}