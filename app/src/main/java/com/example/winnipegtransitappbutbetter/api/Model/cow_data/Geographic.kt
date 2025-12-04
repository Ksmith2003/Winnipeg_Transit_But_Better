package com.example.winnipegtransitappbutbetter.api.Model.cow_data


import com.google.gson.annotations.SerializedName

data class Geographic(
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?
)