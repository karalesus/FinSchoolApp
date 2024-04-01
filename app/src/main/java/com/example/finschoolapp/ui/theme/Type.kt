package com.example.finschoolapp.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.finschoolapp.R

val NunitoFontFamily = FontFamily(
    Font(R.font.nunito_regular, FontWeight.Medium)
)

private val regularNunitoStyle = TextStyle(
    fontFamily = NunitoFontFamily,
    fontWeight = FontWeight.Medium
)

val textViewBaseVariant = regularNunitoStyle.copy(fontSize = 16.sp)
val mainHeader = regularNunitoStyle.copy(fontSize = 28.sp)
val smallHeader = regularNunitoStyle.copy(fontSize = 24.sp)