package com.example.winnipegtransitappbutbetter.api.Model.cow_data

import com.google.gson.annotations.SerializedName

data class Times(
    @SerializedName("arrival")
    val arrival: Arrival?,
    @SerializedName("departure")
    val departure: Departure?
)