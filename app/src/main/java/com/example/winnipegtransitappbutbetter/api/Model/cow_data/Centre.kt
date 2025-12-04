package com.example.winnipegtransitappbutbetter.api.Model.cow_data


import com.google.gson.annotations.SerializedName

data class Centre(
    @SerializedName("geographic")
    val geographic: Geographic?,
    @SerializedName("utm")
    val utm: Utm?
)