package com.example.finschoolapp.presentations.screens.wallet

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.components.buttons.PrimaryButton
import com.example.finschoolapp.ui.components.toolbars.TextToolbar
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.smallHeader
import com.example.finschoolapp.ui.theme.textViewBaseVariant

@Composable
fun OutlinedField(string: String){
    val palette = ThemeColors.LightTheme
    var value by remember { mutableStateOf("") }
    Box(contentAlignment = Alignment.Center){
        OutlinedTextField(
            modifier = Modifier
                .background(palette.thirdLight)
                .height(46.dp)
                .fillMaxWidth(0.9f)
                .border(
                    width = 2.dp,
                    color = palette.third,
                    shape = RoundedCornerShape(10.dp)
                ),
            value = value,
            onValueChange = { value = it },
            textStyle = smallHeader.copy(color = palette.secondary, fontSize = 14.sp ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = palette.third,
                unfocusedBorderColor = palette.secondary
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

        )
        AnimatedVisibility(visible = value.isEmpty()) {
            Text(string, style = textViewBaseVariant.copy(color = palette.secondary))
        }
    }

}

@Composable
fun AddGoalScreen(modifier: Modifier = Modifier,
                  navController: NavHostController
) {

    val dimensions = LocalDimensions.current

    val palette = ThemeColors.LightTheme

    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = palette.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextToolbar(
            text = "Учёт",
            titleColor = palette.secondary,
            backgroundColor = palette.thirdLight
        )

        Spacer(modifier = modifier.height(69.dp))

        Box(
            modifier = modifier
                .background(color = palette.background)
                .size(height = 148.dp, width = 156.dp)
                .clip(roundedShape)
        )

        Spacer(modifier = modifier.height(36.dp))

        PrimaryButton(
            modifier = modifier.size
                (width = 155.dp, height = 36.dp),
            palette = ThemeColors.LightTheme,
            text = stringResource(id = R.string.button_add_photo),
            navController = rememberNavController(),
            route = ""
        )

        Spacer(modifier = modifier.height(29.dp))

        OutlinedField("Название цели")

        Spacer(modifier = modifier.height(24.dp))

        OutlinedField("Необходимая сумма")

        Spacer(modifier = modifier.height(24.dp))

        PrimaryButton(
            modifier = modifier.size(
                height = 40.dp, width = 328.dp
            ),
            palette = ThemeColors.LightTheme,
            text = stringResource(id = R.string.button_create_goal),
            navController = rememberNavController(),
            route = ""
        )

    }
}

@Composable
@Preview
fun AddGoalScreenPreview() {
    AddGoalScreen(navController = rememberNavController())
}