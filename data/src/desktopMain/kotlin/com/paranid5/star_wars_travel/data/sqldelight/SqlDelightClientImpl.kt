package com.paranid5.star_wars_travel.data.sqldelight

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.paranid5.star_wars_travel.data.Planets
import java.io.File

class SqlDelightClientImpl : SqlDelightClient {
    private companion object {
        const val DATABASE_NAME = "planets.db"
    }

    override val driver by lazy {
        JdbcSqliteDriver(url = "jdbc:sqlite:${File(DATABASE_NAME).absolutePath}").also {
            Planets.Schema.create(driver = it)
        }
    }
}