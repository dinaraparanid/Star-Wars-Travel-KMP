package com.paranid5.star_wars_travel.data.sqldelight

import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.paranid5.star_wars_travel.data.Planets

class SqlDelightClientImpl(private val context: Context) : SqlDelightClient {
    private companion object {
        const val DATABASE_NAME = "planets.db"
    }

    override val driver by lazy {
        AndroidSqliteDriver(
            schema = Planets.Schema,
            context = context,
            name = DATABASE_NAME,
            callback = object : AndroidSqliteDriver.Callback(Planets.Schema) {
                override fun onOpen(db: SupportSQLiteDatabase) =
                    db.setForeignKeyConstraintsEnabled(true)
            }
        )
    }
}