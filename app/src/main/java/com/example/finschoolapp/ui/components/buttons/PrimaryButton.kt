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
fun PrimaryButton(
    modifier: Modifier,
    palette: ThemeColors,
    text: String
) {
    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)
    Button(
        onClick = {},
        shape = roundedShape,
        colors = ButtonDefaults.buttonColors(containerColor = palette.third)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = modifier.padding(vertical = 8.dp)) {
            Text(
                text = text,
                style = textViewBaseVariant,
                color = palette.thirdLight
            )
        }
    }
}

@Preview
@Composable
fun PrimaryButtonPreview(modifier: Modifier = Modifier) {
    PrimaryButton(
        modifier = modifier.size
            (width = 296.dp, height = 36.dp),
        palette = ThemeColors.LightTheme,
        text = stringResource(id = R.string.button_continue)
    )
}