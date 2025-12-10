package com.example.winnipegtransitappbutbetter.api.Model.cow_data

import com.google.gson.annotations.SerializedName

data class StopSchedule(
    @SerializedName("route-schedules")
    val routeSchedules: List<RouteSchedule?>?,
    @SerializedName("stop")
    val stop: Stop?
)
