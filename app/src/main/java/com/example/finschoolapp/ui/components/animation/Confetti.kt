package com.example.finschoolapp.ui.components.animation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random
@Composable
fun ConfettiAnimation(visible: Boolean) {
    val confettiColors = listOf(Color.Red, Color.Blue, Color.Green, Color.Yellow)

    if (visible) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val random = Random(System.currentTimeMillis())
            for (i in 0 until 100) {
                val x = random.nextFloat() * size.width
                val y = random.nextFloat() * size.height
                drawRect(
                    color = confettiColors[random.nextInt(confettiColors.size)],
                    topLeft = Offset.Infinite,
                    size = Size(10f, 10f)
                )
            }
        }
    }
}