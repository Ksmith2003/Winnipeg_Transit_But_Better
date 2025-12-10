package com.example.winnipegtransitappbutbetter.api.Model.cow_data

import com.google.gson.annotations.SerializedName

data class Route(
    @SerializedName("badge-label")
    val badgeLabel: String?,
    @SerializedName("badge-style")
    val badgeStyle: BadgeStyle?,
    @SerializedName("coverage")
    val coverage: String?,
    @SerializedName("customer-type")
    val customerType: String?,
    @SerializedName("effective-from")
    val effectiveFrom: String?,
    @SerializedName("effective-to")
    val effectiveTo: String?,
    @SerializedName("key")
    val key: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("number")
    val number: String?
)
