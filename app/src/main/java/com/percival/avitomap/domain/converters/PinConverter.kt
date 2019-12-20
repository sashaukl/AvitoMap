package com.percival.avitomap.domain.converters

import com.percival.avitomap.data.remote.models.PinApi
import com.percival.avitomap.domain.models.Pin

class PinConverter(){
    fun convertPin(pinApi: PinApi): Pin {
        return Pin(id = pinApi.id, lat = pinApi.coordinates.lat, lng = pinApi.coordinates.lng)
    }
}