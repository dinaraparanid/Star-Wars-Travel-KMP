package com.paranid5.star_wars_travel.data.di

import com.paranid5.star_wars_travel.data.sqldelight.SqlDelightClient
import com.paranid5.star_wars_travel.data.sqldelight.SqlDelightClientImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.multiton
import org.kodein.di.new

internal actual val sqlDelightClientModule = DI.Module("sqlDelightClientModule") {
    bind<SqlDelightClient>() with multiton { new(::SqlDelightClientImpl) }
}