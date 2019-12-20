package com.percival.avitomap.ui.di.components

import com.percival.avitomap.ui.di.modules.*
import com.percival.avitomap.ui.viewmodels.SharedViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class, RetrofitModule::class, GsonModule::class, OkHttpModule::class, PinsRepositoryModule::class])
@Singleton
interface AppComponent{
    fun inject(mainPresenter: SharedViewModel)

}