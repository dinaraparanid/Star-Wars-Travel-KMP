package com.paranid5.star_wars_travel

import android.app.Application
import com.paranid5.star_wars_travel.di.initKodein
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule

class MainApplication : Application(), DIAware {
    override val di = initKodein {
        import(androidXModule(this@MainApplication))
    }
}