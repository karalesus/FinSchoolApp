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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier, // Убедитесь, что у вас есть значение по умолчанию
    palette: ThemeColors,
    text: String,
    navController: NavHostController,
    route: String
) {
    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)

    Button(
        onClick = { navController.navigate(route) },
        shape = roundedShape,
        colors = ButtonDefaults.buttonColors(containerColor = palette.third),
        modifier = modifier // Добавляем модификатор сюда
            .shadow(8.dp, roundedShape) // Добавляем тень к кнопке
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(vertical = 5.dp)) {
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
fun PrimaryButtonPreview(
    modifier : Modifier = Modifier,
) {
    PrimaryButton(
        modifier = modifier
            .size(width = 296.dp,height = 30.dp),
        palette = ThemeColors.LightTheme,
        text = stringResource(id = R.string.button_complete_module),
        navController = NavHostController(LocalContext.current),
        route = "Hello"
    )
}
