package com.percival.avitomap.domain.repositories

import com.percival.avitomap.data.remote.services.MyService
import com.percival.avitomap.domain.converters.ResponseConverter
import com.percival.avitomap.domain.models.Pin
import com.percival.avitomap.domain.repositories.implementations.PinsRepositoryImpl

class PinsRepository(private val myService: MyService, private val responseConverter: ResponseConverter): PinsRepositoryImpl{

    override suspend fun getPinsMap(): Map<String, List<Pin>> {
        return responseConverter.fromResponseToMap(myService.getJson())
    }

}