package com.example.winnipegtransitappbutbetter.api.Model.cow_data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName="routes")
    data class Route(
        @SerializedName("badge-label")
        val badgeLabel: Int?,
        //@SerializedName("badge-style")
        //val badgeStyle: BadgeStyle?,
        @SerializedName("coverage")
        val coverage: String?,
        @SerializedName("customer-type")
        val customerType: String?,

        @PrimaryKey
        @SerializedName("key")
        val key: String,


        @SerializedName("name")
        val name: String?,
        @SerializedName("number")
        val number: String?,
        //@SerializedName("variants")
        //val variants: List<Variant?>?
    )
