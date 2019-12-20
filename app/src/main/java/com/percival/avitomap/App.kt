package com.percival.avitomap

import android.app.Application
import com.percival.avitomap.ui.di.components.AppComponent
import com.percival.avitomap.ui.di.components.DaggerAppComponent
import com.percival.avitomap.ui.di.modules.ApplicationModule
import com.percival.avitomap.ui.di.modules.GsonModule
import com.percival.avitomap.ui.di.modules.OkHttpModule
import com.percival.avitomap.ui.di.modules.RetrofitModule

class App: Application(){
    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger(){
        appComponent = DaggerAppComponent.builder().build()

    }



}