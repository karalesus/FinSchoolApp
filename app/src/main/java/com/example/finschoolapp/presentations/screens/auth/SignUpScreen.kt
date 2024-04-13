package com.example.finschoolapp.presentations.screens.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
import com.example.finschoolapp.ui.theme.smallHeader
import com.example.finschoolapp.ui.theme.textViewBaseVariant
import com.example.finschoolapp.ui.theme.textforSignUp

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val palette = ThemeColors.LightTheme

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = palette.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row () {
            Text(
                text = stringResource(id = R.string.label_sign_in),
                style = mainHeader.copy(color = palette.secondary),
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )
        }
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top

        ) {

            val username = remember { mutableStateOf(TextFieldValue()) }
            val password = remember { mutableStateOf(TextFieldValue()) }


            Text(text = stringResource(id = R.string.label_login), style = textViewBaseVariant.copy(color = palette.secondary), textAlign = TextAlign.End,)
            OutlinedTextField(
                modifier = modifier
                    .background(palette.thirdLight)
                    .height(35.dp)
                    .fillMaxWidth(0.9f)
                    .shadow(2.dp, shape = RoundedCornerShape(30))
                    .border(
                        width = 3.dp,
                        color = palette.third
                    ),
                value = username.value,
                onValueChange = { username.value = it },

            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(text = stringResource(id = R.string.label_password), style = textViewBaseVariant.copy(color = palette.secondary), textAlign = TextAlign.End,)
            OutlinedTextField(
                modifier = modifier
                    .background(palette.thirdLight)
                    .height(35.dp)
                    .fillMaxWidth(0.9f)
                    .shadow(3.dp)
                    .border(
                        width = 3.dp,
                        color = palette.third,
                        shape = RoundedCornerShape(30)
                    ),
                value = password.value,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { password.value = it })


            Spacer(modifier = modifier
                .height(20.dp)
                .width(200.dp)
            )
            ClickableText(
                modifier = modifier.align(Alignment.End),
                text = AnnotatedString("Забыли пароль?"),
                onClick = { },
                style = textforSignUp.copy(
                    textAlign = TextAlign.Start,
                    color = palette.secondary,
                )

            )

            Spacer(modifier = Modifier.height(20.dp))

            MainButtonOutlined(
                modifier = modifier
                    .height(35.dp)
                    .shadow(3.dp)
                    .fillMaxWidth(0.9f),
                palette = palette,
                text = stringResource(id = R.string.button_sign_in),
                onButtonClick = {
                    focusManager.clearFocus()
                    keyboardController?.hide()
                })

            }

            Box(modifier = modifier.fillMaxWidth())
            {
                ClickableText(
                    text = AnnotatedString("Еще нет аккаунта? Зарегистрироваться"),
                    modifier = modifier
                        .align(Alignment.BottomCenter)
                        .padding(1.dp),
                    onClick = { },
                    style = textforSignUp.copy(color = palette.secondary)
                )
            }
        }
    }

@Preview
@Composable
fun SignUpPreview(){
    SignUpScreen(navController = rememberNavController())
}