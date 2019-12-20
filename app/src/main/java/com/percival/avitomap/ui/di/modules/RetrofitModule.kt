package com.percival.avitomap.ui.di.modules

import android.content.Context
import com.google.gson.Gson
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.percival.avitomap.data.remote.services.MyService
import dagger.Module
import dagger.Provides
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [OkHttpModule::class, GsonModule::class])
class RetrofitModule{

    val baseurl = "https://sashaukl.github.io/tasks_api/"

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseurl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun getFactsService(okHttpClient: OkHttpClient, gson: Gson): MyService{
        return provideRetrofit(okHttpClient, gson).create(MyService::class.java)
    }

}