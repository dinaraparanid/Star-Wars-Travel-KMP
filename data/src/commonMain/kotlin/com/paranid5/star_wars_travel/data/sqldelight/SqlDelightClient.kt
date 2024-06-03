package com.paranid5.star_wars_travel.data.sqldelight

import app.cash.sqldelight.db.SqlDriver

interface SqlDelightClient {
    val driver: SqlDriver
}