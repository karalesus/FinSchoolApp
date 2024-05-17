package com.example.finschoolapp.presentations.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.components.buttons.MainButtonOutlined
import com.example.finschoolapp.ui.theme.LocalDimensions
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.smallHeader
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.onConsumedWindowInsetsChanged
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource


@Composable
fun Hello(
    modifier: Modifier = Modifier,
    onWhatToDoClick: () -> Unit,
) {
    val dimensions = LocalDimensions.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val palette = ThemeColors.LightTheme

    val roundedShape = RoundedCornerShape(dimensions.shapeNormal)
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = palette.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.image_character_lvl1_1),

            contentDescription = "Character_lvl_1"
        )
        Spacer(modifier = modifier.height(20.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxWidth(0.85f)
                .fillMaxHeight(0.45f)
                .clip(roundedShape)
                .background(color = palette.thirdLight)
                .border(
                    width = dimensions.borderNormal,
                    color = palette.third,
                    shape = roundedShape
                )
                .padding(vertical = dimensions.verticalNormalPadding)
        ) {
            Text(
                modifier = modifier.padding(10.dp),
                text = stringResource(id = R.string.welcome_text),
                style = smallHeader.copy(color = palette.secondary)
            )
        }
        Spacer(modifier = modifier.height(dimensions.verticalSLarge))
        MainButtonOutlined(
            modifier = modifier
                .shadow(
                    elevation = 7.dp,
                    shape = RoundedCornerShape(30)
                )
                .fillMaxHeight(0.13f)
                .fillMaxWidth(0.85f),
            palette = palette,
            text = stringResource(id = R.string.button_what_to_do),
            onButtonClick = {
                focusManager.clearFocus()
                keyboardController?.hide()
                onWhatToDoClick()
            },
        )
    }
}

@Preview
@Composable
fun HelloPreview() {
    Hello(onWhatToDoClick = {})
}