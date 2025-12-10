package com.example.winnipegtransitappbutbetter.api.Model.cow_data

import com.google.gson.annotations.SerializedName

data class ScheduledStop(
    @SerializedName("bus")
    val bus: Bus?,
    @SerializedName("cancelled")
    val cancelled: String?,
    @SerializedName("key")
    val key: String?,
    @SerializedName("times")
    val times: Times?,
    @SerializedName("trip-key")
    val tripKey: Int?,
    @SerializedName("variant")
    val variant: Variant?
)
