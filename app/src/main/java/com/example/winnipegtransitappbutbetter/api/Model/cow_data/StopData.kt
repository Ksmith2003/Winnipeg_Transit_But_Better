package com.example.winnipegtransitappbutbetter.api.Model.cow_data


import com.google.gson.annotations.SerializedName

data class StopData(
    @SerializedName("query-time")
    val queryTime: String?,
    @SerializedName("stops")
    val stops: List<Stop?>?
)