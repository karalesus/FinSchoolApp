package com.example.finschoolapp.ui.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
fun NextThemeButton(
        modifier : Modifier,
        text : String,
        palette: ThemeColors
) {
    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)

    Button(
            onClick = { /*TODO*/ },
            shape = roundedShape,
            colors = ButtonDefaults.buttonColors(containerColor = palette.thirdLight)
    ) {
        Row (
            modifier = modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically)
        {
            Text(
                modifier=Modifier.padding(horizontal = 8.dp),
                text = text,
                style = textViewBaseVariant,
                color = palette.secondary)
            Icon(
                painter = painterResource(id = R.drawable.next_theme_btn),
                contentDescription = "Иконка для следующей темы",
                tint = palette.secondary)
        }
    }
}

@Preview
@Composable
fun NextThemeButtonPreview(
        modifier : Modifier = Modifier,
) {
    NextThemeButton(
            modifier = modifier
                .size(width = 296.dp,height = 30.dp),
            palette = ThemeColors.LightTheme,
            text = stringResource(id = R.string.button_next_theme))
}


