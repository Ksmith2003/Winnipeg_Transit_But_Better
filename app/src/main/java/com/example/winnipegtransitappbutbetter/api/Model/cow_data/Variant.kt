package com.example.winnipegtransitappbutbetter.api.Model.cow_data

import com.google.gson.annotations.SerializedName

data class Variant(
    @SerializedName("effective-from")
    val effectiveFrom: String?,
    @SerializedName("effective-to")
    val effectiveTo: String?,
    @SerializedName("key")
    val key: String?,
    @SerializedName("name")
    val name: String?
)