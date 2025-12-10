package com.example.winnipegtransitappbutbetter.api

import com.example.winnipegtransitappbutbetter.api.Model.cow_data.StopData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.Stop
import com.example.winnipegtransitappbutbetter.api.StopsManager

interface ScheduleService {
    @GET("/schedule.json")
    fun getBusSchedules(
                    @Query("api-key") apiKey: String) : Call<StopData>
}
