package com.paranid5.star_wars_travel.domain.di

import com.paranid5.star_wars_travel.domain.OpenBrowserUseCaseImpl
import com.paranid5.star_wars_travel.domain.use_case.OpenBrowserUseCase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.multiton
import org.kodein.di.new

actual val openBrowserModule: DI.Module = DI.Module("openBrowserModule") {
    bind<OpenBrowserUseCase>() with multiton { new(::OpenBrowserUseCaseImpl) }
}
