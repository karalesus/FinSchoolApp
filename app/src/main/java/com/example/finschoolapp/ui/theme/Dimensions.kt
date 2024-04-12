package com.example.finschoolapp.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val verticalSmall: Dp = 10.dp,
    val verticalNormal: Dp = 12.dp,
    val verticalSLarge: Dp = 16.dp,
    val verticalXLarge: Dp = 82.dp,
    val verticalXXLarge: Dp = 134.dp,

    val verticalNormalPadding: Dp = 16.dp,

    val shapeNormal: Dp = 10.dp,

    val borderNormal: Dp = 3.dp

)

val LocalDimensions = compositionLocalOf { Dimensions() }