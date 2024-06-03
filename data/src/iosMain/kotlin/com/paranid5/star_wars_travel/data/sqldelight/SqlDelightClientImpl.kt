package com.paranid5.star_wars_travel.data.sqldelight

import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.paranid5.star_wars_travel.data.Planets

class SqlDelightClientImpl : SqlDelightClient {
    private companion object {
        const val DATABASE_NAME = "planets.db"
    }

    override val driver = NativeSqliteDriver(
        schema = Planets.Schema,
        name = DATABASE_NAME
    )
}