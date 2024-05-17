package com.example.finschoolapp.presentations.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.finschoolapp.R
import com.example.finschoolapp.ui.components.buttons.MainButtonOutlined
import com.example.finschoolapp.ui.theme.ThemeColors
import com.example.finschoolapp.ui.theme.mainHeader
import com.example.finschoolapp.ui.theme.textViewBaseVariant
import com.example.finschoolapp.ui.theme.textForSignUp

@Composable
fun ForgotPasswordScreen(
    onEnterClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onReturnToMainClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val palette = ThemeColors.LightTheme

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = palette.background)
    ) {
        Spacer(modifier = Modifier.height(150.dp))

        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(400.dp)
                .background(color = palette.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row() {
                Text(
                    text = stringResource(id = R.string.label_password_recovery),
                    style = mainHeader.copy(color = palette.secondary),
                    modifier = Modifier.align(alignment = Alignment.CenterVertically)
                )
            }

            Spacer(modifier = modifier.height(20.dp))

            Row(modifier = modifier.padding(horizontal = 5.dp)) {
                Text(
                    text = stringResource(id = R.string.label_we_send_code),
                    style = textForSignUp.copy(color = palette.secondary),
                    textAlign = TextAlign.Center
                )

            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top

            ) {

                val email = remember { mutableStateOf(TextFieldValue()) }

                Text(
                    text = stringResource(id = R.string.label_email),
                    style = textViewBaseVariant.copy(color = palette.secondary),
                    textAlign = TextAlign.End
                )
                Row(
                    modifier = Modifier
                        .shadow(
                            elevation = 7.dp,
                            shape = RoundedCornerShape(30)
                        )
                        .background(
                            color = palette.thirdLight,
                            shape = RoundedCornerShape(30.dp))
                        .height(35.dp)
                        .fillMaxWidth()
                        .border(
                            width = 3.dp,
                            color = palette.third,
                            shape = RoundedCornerShape(30)
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    BasicTextField(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        value = email.value,
                        onValueChange = { email.value = it },
                        )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = modifier
                        .clickable { onReturnToMainClick() }
                        .align(Alignment.End),
                    text = AnnotatedString("Вернуться на главный экран"),
                    style = textForSignUp.copy(
                        textAlign = TextAlign.Start,
                        color = palette.secondary,
                    )

                )

                Spacer(modifier = Modifier.height(10.dp))

                MainButtonOutlined(
                    modifier = modifier
                        .shadow(
                            elevation = 7.dp,
                            shape = RoundedCornerShape(30)
                        ),
                    palette = palette,
                    text = stringResource(id = R.string.button_send),
                    onButtonClick = {
                        focusManager.clearFocus()
                        keyboardController?.hide()
                        onEnterClick()
                    })

            }

            Box(modifier = modifier.fillMaxWidth())
            {
                Text(
                    text = AnnotatedString("Еще нет аккаунта? Зарегистрироваться"),
                    modifier = modifier
                        .align(Alignment.BottomCenter)
                        .clickable { onSignUpClick() }
                        .padding(1.dp),
                    style = textForSignUp.copy(color = palette.secondary)
                )
            }
        }
    }
}

@Preview
@Composable
fun ForgotPasswordScreenPreview(){
    ForgotPasswordScreen(
        onEnterClick = {},
        onSignUpClick = {},
        onReturnToMainClick = {}
    )
}