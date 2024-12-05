package com.example.finschoolapp.ui.components.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@Preview
@Composable
fun SaveThemeButton(
    modifier: Modifier,
    palette: ThemeColors,
    text: String,
    onButtonClick: () -> Unit
) {
    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)

    IconButton(
        onClick = { onButtonClick() },
        modifier = modifier
            .border(
                width = dimensions.borderNormal,
                shape = roundedShape,
                color = palette.third
            )
            .height(40.dp)
            .fillMaxWidth(),
        colors = IconButtonDefaults.iconButtonColors(containerColor = palette.thirdLight)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.save_theme_btn),
                contentDescription = "Сохраненная тема",
                tint = ThemeColors.LightTheme.secondary,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = text,
                style = textViewBaseVariant,
                color = palette.secondary
            )
        }
    }
}



