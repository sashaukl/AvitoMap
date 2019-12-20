package com.percival.avitomap.data.remote.models

data class ResponseApi(
    val services: List<String>,
    val pins: List<PinApi>
)