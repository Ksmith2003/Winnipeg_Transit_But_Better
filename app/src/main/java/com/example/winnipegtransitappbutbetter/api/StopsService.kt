package com.example.winnipegtransitappbutbetter.api


import com.example.winnipegtransitappbutbetter.api.Model.cow_data.StopData
import com.example.winnipegtransitappbutbetter.api.Model.old.StopResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StopsService {

    @GET("stops.json")
    fun getBusStops(@Query("lon") lon: Double,
                    @Query("lat") lat: Double,
                    @Query("distance") distance: Int,
                    @Query("api-key") apiKey: String) : Call<StopData>
}