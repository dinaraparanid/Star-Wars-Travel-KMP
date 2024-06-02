package com.paranid5.star_wars_travel.core.common.di

import com.paranid5.star_wars_travel.core.common.domain.use_case.OpenBrowserUseCase
import com.paranid5.star_wars_travel.core.common.utils.OpenBrowserUseCaseImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.multiton
import org.kodein.di.new

actual val openBrowserModule = DI.Module("openBrowserModule") {
    bind<OpenBrowserUseCase>() with multiton { new(::OpenBrowserUseCaseImpl) }
}