package com.example.winnipegtransitappbutbetter.api.Model.cow_data

import com.google.gson.annotations.SerializedName

data class Departure(
    @SerializedName("estimated")
    val estimated: String?,
    @SerializedName("scheduled")
    val scheduled: String?
)
