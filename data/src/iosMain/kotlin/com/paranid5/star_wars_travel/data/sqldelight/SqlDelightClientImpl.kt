package com.paranid5.star_wars_travel.data.sqldelight

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.paranid5.star_wars_travel.data.Planets

class SqlDelightClientImpl : SqlDelightClient {
    private companion object {
        const val DatabaseName = "planets.db"
    }

    override val driver: SqlDriver = NativeSqliteDriver(
        schema = Planets.Schema,
        name = DatabaseName,
    )
}