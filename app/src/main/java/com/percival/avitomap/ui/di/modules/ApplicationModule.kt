package com.percival.avitomap.ui.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule (appContext: Context) {
    private val context = appContext

    @Provides
    @Singleton
    fun provideContext(): Context = context

}