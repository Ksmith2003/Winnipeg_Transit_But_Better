package com.example.winnipegtransitappbutbetter.api


import android.R
import com.example.winnipegtransitappbutbetter.api.Model.StopData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StopsService {

    @GET("stops.json")
    fun getBusStops(@Query("lon") lon: Double,
                    @Query("lat") lat: Double,
                    @Query("distance") distance: Int,
                    @Query("api_key") apiKey: String) : Call<StopData>
}