package com.example.winnipegtransitappbutbetter.api.Model.cow_data

import com.google.gson.annotations.SerializedName

data class ScheduleData(
    @SerializedName("query-time")
    val queryTime: String?,
    @SerializedName("stop-schedule")
    val stopSchedule: StopSchedule?
)