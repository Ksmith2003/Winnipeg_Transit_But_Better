package com.example.winnipegtransitappbutbetter.api.Model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StopData(
    @Json(name = "query-time")
    var queryTime: String?,
    @Json(name = "stops")
    var stops: List<Stop?>?
) {
    @JsonClass(generateAdapter = true)
    data class Stop(
        @Json(name = "centre")
        var centre: Centre?,
        @Json(name = "cross-street")
        var crossStreet: CrossStreet?,
        @Json(name = "direction")
        var direction: String?,
        @Json(name = "distances")
        var distances: Distances?,
        @Json(name = "key")
        var key: Int?,
        @Json(name = "name")
        var name: String?,
        @Json(name = "number")
        var number: Int?,
        @Json(name = "side")
        var side: String?,
        @Json(name = "street")
        var street: Street?
    ) {
        @JsonClass(generateAdapter = true)
        data class Centre(
            @Json(name = "geographic")
            var geographic: Geographic?,
            @Json(name = "utm")
            var utm: Utm?
        ) {
            @JsonClass(generateAdapter = true)
            data class Geographic(
                @Json(name = "latitude")
                var latitude: Double?,
                @Json(name = "longitude")
                var longitude: Double?
            )

            @JsonClass(generateAdapter = true)
            data class Utm(
                @Json(name = "x")
                var x: Int?,
                @Json(name = "y")
                var y: Int?,
                @Json(name = "zone")
                var zone: String?
            )
        }

        @JsonClass(generateAdapter = true)
        data class CrossStreet(
            @Json(name = "key")
            var key: Int?,
            @Json(name = "name")
            var name: String?,
            @Json(name = "type")
            var type: String?
        )

        @JsonClass(generateAdapter = true)
        data class Distances(
            @Json(name = "direct")
            var direct: Double?
        )

        @JsonClass(generateAdapter = true)
        data class Street(
            @Json(name = "key")
            var key: Int?,
            @Json(name = "leg")
            var leg: String?,
            @Json(name = "name")
            var name: String?,
            @Json(name = "type")
            var type: String?
        )
    }
}