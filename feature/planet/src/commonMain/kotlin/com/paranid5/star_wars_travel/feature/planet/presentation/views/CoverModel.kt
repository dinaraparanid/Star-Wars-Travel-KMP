package com.paranid5.star_wars_travel.feature.planet.presentation.views

import androidx.compose.runtime.Composable
import coil3.Image
import coil3.PlatformContext
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.size.Precision
import coil3.size.Scale
import com.paranid5.star_wars_travel.core.resources.Res
import com.paranid5.star_wars_travel.core.resources.deathstar
import org.jetbrains.compose.resources.painterResource

fun coverModel(
    coverUrl: String?,
    context: PlatformContext,
    animationMillis: Int = 400,
    isPlaceholderRequired: Boolean = false
) {
    ImageRequest.Builder(context)
        .data(coverUrl)
//        .run {
//            when {
//                isPlaceholderRequired -> placeholder(Res.drawable.deathstar)
//                else -> this
//            }
//        }
//        .error(Res.drawable.deathstar)
//        .fallback(Res.drawable.deathstar)
        .networkCachePolicy(CachePolicy.ENABLED)
        .diskCachePolicy(CachePolicy.ENABLED)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .precision(Precision.EXACT)
        .scale(Scale.FILL)
        .crossfade(animationMillis)
        .build()
}