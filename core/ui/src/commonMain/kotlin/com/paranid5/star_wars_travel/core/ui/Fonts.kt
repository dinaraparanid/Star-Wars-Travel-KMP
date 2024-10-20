package com.paranid5.star_wars_travel.core.ui


import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.starjedi
import org.jetbrains.compose.resources.Font

val StarJediFont: FontFamily
    @Composable
    get() = FontFamily(Font(Res.font.starjedi, weight = FontWeight.Normal))
