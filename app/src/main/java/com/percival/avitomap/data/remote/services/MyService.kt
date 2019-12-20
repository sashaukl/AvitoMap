package com.percival.avitomap.data.remote.services

import com.percival.avitomap.data.remote.models.ResponseApi
import retrofit2.http.GET

interface MyService {
    @GET("pins.json")
    suspend fun getJson(): ResponseApi
}