package com.example.winnipegtransitappbutbetter.api.Model.cow_data

import com.google.gson.annotations.SerializedName

data class BadgeStyle(
    @SerializedName("background-color")
    val backgroundColor: String?,
    @SerializedName("border-color")
    val borderColor: String?,
    @SerializedName("class-names")
    val classNames: ClassNames?,
    @SerializedName("color")
    val color: String?
)