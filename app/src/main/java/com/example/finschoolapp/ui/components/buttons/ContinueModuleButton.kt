package com.example.finschoolapp.ui.components.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@Composable
fun ContinueModuleButton(
    modifier: Modifier,
    palette: ThemeColors,
    text: String,
    onButtonClick: () -> Unit
) {
    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)
    Button(
        onClick = {
                onButtonClick()
        },
        shape = roundedShape,
        colors = ButtonDefaults.buttonColors(containerColor = palette.thirdLight)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = modifier.padding(vertical = 8.dp)) {
            Text(
                text = text,
                style = textViewBaseVariant,
                color = palette.moduleBackgroundDark
            )
        }
    }
}