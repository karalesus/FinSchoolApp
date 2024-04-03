package com.example.finschoolapp.ui.theme

import androidx.compose.ui.graphics.Color


val mainBackground: Color = Color(0xFFC3C8BB)
val thirdLight: Color = Color(0xFFE0E0C6)
val third: Color = Color(0xFFA9A969)
val secondary: Color = Color(0xFF545A21)
val lessonBackground: Color = Color(0xFFFAFAF3)
val moduleBackground: Color = Color(0xFF386667)
val moduleBackgroundDark: Color = Color(0xFF1E4E4F)

sealed class ThemeColors (
    val background: Color,
    val thirdLight: Color,
    val third: Color,
    val secondary: Color,
    val lessonBackground : Color,
    val moduleBackground: Color,
    val moduleBackgroundDark: Color) {
    object LightTheme : ThemeColors (
        background = mainBackground,
        thirdLight = thirdLight,
        third = third,
        secondary = secondary,
        lessonBackground = lessonBackground,
        moduleBackground = moduleBackground,
        moduleBackgroundDark = moduleBackgroundDark)
}