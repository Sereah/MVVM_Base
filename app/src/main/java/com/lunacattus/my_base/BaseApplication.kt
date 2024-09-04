package com.lunacattus.my_base

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BaseApplication : Application() {
    @Inject
    lateinit var appContext: Context
}