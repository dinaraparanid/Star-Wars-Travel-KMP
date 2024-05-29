package com.paranid5.star_wars_travel

import android.app.Application
import com.paranid5.star_wars_travel.di.initKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}