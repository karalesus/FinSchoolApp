package com.example.finschoolapp.ui.components.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@Composable
fun MainButtonOutlined(
    modifier: Modifier,
    palette: ThemeColors,
    text: String,
    onButtonClick: () -> Unit
) {
    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)

    Button(
        onClick = {onButtonClick()},
        modifier = modifier.border(
            width = dimensions.borderNormal,
            shape = roundedShape,
            color = palette.third
        )
            .height(35.dp)
            .fillMaxWidth(1f),
        shape = roundedShape,
        colors = ButtonDefaults.buttonColors(containerColor = palette.thirdLight)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = text,
                style = textViewBaseVariant,
                color = palette.secondary
            )
        }
    }
}