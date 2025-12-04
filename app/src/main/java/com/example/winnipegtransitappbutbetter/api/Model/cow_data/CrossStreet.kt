package com.example.winnipegtransitappbutbetter.api.Model.cow_data


import com.google.gson.annotations.SerializedName

data class CrossStreet(
    @SerializedName("key")
    val key: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("type")
    val type: String?
)