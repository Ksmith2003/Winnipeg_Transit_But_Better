package com.example.winnipegtransitappbutbetter.api.Model.cow_data

import com.google.gson.annotations.SerializedName

data class RouteSchedule(
    @SerializedName("route")
    val route: Route?,
    @SerializedName("scheduled-stops")
    val scheduledStops: List<ScheduledStop?>?
)
