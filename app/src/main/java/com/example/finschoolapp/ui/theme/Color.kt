package com.example.finschoolapp.ui.theme

import androidx.compose.ui.graphics.Color

val mainBackground: Color = Color(0xFFC3C8BB)
val thirdLight: Color = Color(0xFFE0E0C6)
val third: Color = Color(0xFFA9A969)
val secondary: Color = Color(0xFF545A21)


sealed class ThemeColors (
    val background: Color,
    val thirdLight: Color,
    val third: Color,
    val secondary: Color) {
    object Theme : ThemeColors (
        background = mainBackground,
        thirdLight = thirdLight,
        third = third,
        secondary = secondary)
}