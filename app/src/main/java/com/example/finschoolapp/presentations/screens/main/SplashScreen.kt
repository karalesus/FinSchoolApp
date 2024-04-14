package com.example.finschoolapp.presentations.screens.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.finschoolapp.ui.theme.mainBackground
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finschoolapp.MainActivity
import com.example.finschoolapp.ui.theme.moduleBackgroundDark
import com.example.finschoolapp.ui.theme.thirdLight
import kotlinx.coroutines.delay
import androidx.compose.ui.Modifier
import com.example.finschoolapp.ui.theme.LargeHeader
import com.example.finschoolapp.ui.theme.textViewBaseVariant


@SuppressLint("CustomSplashScreen")
class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreenText()
        }
    }

    @Preview
    @Composable
    private fun SplashScreenText() {
        LaunchedEffect(key1 = true, block = {
            delay(2000)
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
            finish()
        })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = mainBackground),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Fin School", Modifier.padding(vertical = 30.dp),
                style = LargeHeader,
                color = moduleBackgroundDark
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp, vertical = 20.dp),
                shape = RoundedCornerShape(15.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(thirdLight),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Копейка рубль бережёт!",
                        Modifier.padding(vertical = 15.dp),
                        textAlign = TextAlign.Right,
                        style = textViewBaseVariant,
                        color = moduleBackgroundDark,
                    )
                }
            }
        }
    }
}