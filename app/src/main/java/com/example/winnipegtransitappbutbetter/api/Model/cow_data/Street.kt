package com.example.winnipegtransitappbutbetter.api.Model.cow_data


import com.google.gson.annotations.SerializedName

data class Street(
    @SerializedName("key")
    val key: Int?,
    @SerializedName("leg")
    val leg: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("type")
    val type: String?
)