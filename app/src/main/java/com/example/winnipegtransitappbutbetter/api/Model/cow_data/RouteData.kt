package com.example.winnipegtransitappbutbetter.api.Model.cow_data

import com.google.gson.annotations.SerializedName

data class RouteData(
    @SerializedName("query-time")
    val queryTime: String?,
    @SerializedName("routes")
    val routes: List<Route?>?
)