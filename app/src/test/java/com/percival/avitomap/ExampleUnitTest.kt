package com.percival.avitomap

import com.google.gson.Gson
import com.percival.avitomap.data.remote.models.ResponseApi
import com.percival.avitomap.domain.converters.PinConverter
import com.percival.avitomap.domain.converters.ResponseConverter
import com.percival.avitomap.domain.models.Pin
import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    private val json = """{ "services": ["a","b","c"],"pins": [{"id": 1,"service": "a","coordinates": {"lat": 55.725432,"lng": 37.584802}},{ "id": 2, "service": "b",
            "coordinates": { "lat": 55.769504, "lng": 37.644908}}]}"""

    @Test
    fun gsonDeserializerTest(){
        val responseApi: ResponseApi = Gson().fromJson(json, ResponseApi::class.java)

        assertEquals( 3, responseApi.services.size)
        assertEquals( "b", responseApi.services[1])
        assertEquals( 2, responseApi.pins.size)
        assertEquals( 37.644908, responseApi.pins[1].coordinates.lng, 0.000001)
    }

    @Test
    fun pinConverterTest(){
        val responseApi: ResponseApi = Gson().fromJson(json, ResponseApi::class.java)
        val pinConverter = PinConverter()
        assertEquals( Pin(1, 55.725432, 37.584802), pinConverter.convertPin(responseApi.pins[0]))
    }

    @Test
    fun responseConverter(){
        val responseApi: ResponseApi = Gson().fromJson(json, ResponseApi::class.java)
        val pinConverter = PinConverter()
        val responseConverter = ResponseConverter(pinConverter)
        val hashMap = responseConverter.fromResponseToMap(responseApi)
        assertEquals(2, hashMap.size)
        assertEquals(true, hashMap.containsKey("a"))
        assertEquals(true, hashMap.containsKey("b"))
        assertEquals(false, hashMap.containsKey("c"))
        assertEquals(1, hashMap["a"]?.size)
        assertEquals( 37.644908, hashMap["b"]?.get(0)?.lng)
    }

}
