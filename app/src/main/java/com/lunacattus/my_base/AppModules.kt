package com.lunacattus.my_base

import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.generationConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

class AppModules private constructor() {

    @Module
    @InstallIn(SingletonComponent::class)
    class SingleModule {
        @Singleton
        @Provides
        fun provideGenerativeModel(): GenerativeModel {
            val config = generationConfig {
                temperature = 0.9f
            }
            return GenerativeModel(
                modelName = "gemini-1.5-pro",
                apiKey = BuildConfig.apiKey,/*apikey is defined in local.properties*/
                generationConfig = config
            )
        }
    }

    @Module
    @InstallIn(ActivityComponent::class)
    class ActivityModule {

    }
}