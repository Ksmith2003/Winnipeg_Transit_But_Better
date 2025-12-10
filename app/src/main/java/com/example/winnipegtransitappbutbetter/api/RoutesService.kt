package com.example.winnipegtransitappbutbetter.api


import com.example.winnipegtransitappbutbetter.api.Model.cow_data.RouteData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RoutesService{

    @GET("routes.json")
    fun getBusRoutes(@Query("api-key") apiKey: String) : Call<RouteData>

}