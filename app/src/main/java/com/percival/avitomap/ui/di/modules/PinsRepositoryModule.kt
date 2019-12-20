package com.percival.avitomap.ui.di.modules

import com.percival.avitomap.data.remote.services.MyService
import com.percival.avitomap.domain.converters.PinConverter
import com.percival.avitomap.domain.converters.ResponseConverter
import com.percival.avitomap.domain.repositories.PinsRepository
import com.percival.avitomap.domain.repositories.implementations.PinsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
class PinsRepositoryModule {

    private val pinConverter = PinConverter()
    private val responseConverter = ResponseConverter(pinConverter)


    @Provides
    @Singleton
    fun providePinsRepository(myService: MyService): PinsRepositoryImpl {
        return PinsRepository(myService, responseConverter)
    }
}