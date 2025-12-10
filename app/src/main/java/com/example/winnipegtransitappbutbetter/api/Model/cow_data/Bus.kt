package com.example.winnipegtransitappbutbetter.api.Model.cow_data

import com.google.gson.annotations.SerializedName

data class Bus(
    @SerializedName("bike-rack")
    val bikeRack: String?,
    @SerializedName("key")
    val key: Int?,
    @SerializedName("wifi")
    val wifi: String?
)
