package com.example.finschoolapp.ui.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@Composable
fun FourthMiniGameButton(
    text: String,
    onClick: () -> Unit,
) {
    val palette = ThemeColors.LightTheme
    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)

    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(all = 4.dp)
            .width(150.dp)
            .heightIn(min = 150.dp),
        shape = roundedShape,
        colors = ButtonDefaults.buttonColors(containerColor = palette.third),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Center,
            style = textViewBaseVariant,
            color = ThemeColors.LightTheme.thirdLight
        )
    }
}