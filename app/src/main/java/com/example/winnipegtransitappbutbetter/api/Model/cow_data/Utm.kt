package com.example.winnipegtransitappbutbetter.api.Model.cow_data


import com.google.gson.annotations.SerializedName

data class Utm(
    @SerializedName("x")
    val x: Int?,
    @SerializedName("y")
    val y: Int?,
    @SerializedName("zone")
    val zone: String?
)