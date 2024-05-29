package com.paranid5.star_wars_travel.presentation.ui


import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import starwarstravel.composeapp.generated.resources.Res
import starwarstravel.composeapp.generated.resources.starjedi

val StarJediFont
    @Composable
    get() = FontFamily(
        Font(Res.font.starjedi, weight = FontWeight.Normal)
    )