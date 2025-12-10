package com.example.winnipegtransitappbutbetter.api.Model.cow_data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName="stops")
data class Stop(
    @SerializedName("centre")
    val centre: Centre?,
    @SerializedName("cross-street")
    val crossStreet: CrossStreet?,
    @SerializedName("direction")
    val direction: String?,
    @SerializedName("distances")
    val distances: Distances?,

    @PrimaryKey
    @SerializedName("key")
    val key: Int?,

    @SerializedName("name")
    val name: String?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("side")
    val side: String?,
    @SerializedName("street")
    val street: Street?
)