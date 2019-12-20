package com.percival.avitomap.domain.converters

import com.percival.avitomap.data.remote.models.ResponseApi
import com.percival.avitomap.domain.models.Pin

class ResponseConverter(private val pinConverter: PinConverter) {
    fun fromResponseToMap(responseApi: ResponseApi): Map<String, List<Pin>>{
        return responseApi.pins
            .groupBy { it.service }
            .mapValues {it.value.map { pinApi -> pinConverter.convertPin(pinApi) }}
    }
}