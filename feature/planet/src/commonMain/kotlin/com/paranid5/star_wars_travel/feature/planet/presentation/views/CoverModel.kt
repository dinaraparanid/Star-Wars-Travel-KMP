package com.paranid5.star_wars_travel.feature.planet.presentation.views

import coil3.PlatformContext
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.size.Precision
import coil3.size.Scale

fun coverModel(
    coverUrl: String?,
    context: PlatformContext,
    animationMillis: Int = 400,
): ImageRequest = ImageRequest.Builder(context)
    .data(coverUrl)
    .networkCachePolicy(CachePolicy.ENABLED)
    .diskCachePolicy(CachePolicy.ENABLED)
    .memoryCachePolicy(CachePolicy.ENABLED)
    .precision(Precision.EXACT)
    .scale(Scale.FILL)
    .crossfade(animationMillis)
    .build()