package com.example.winnipegtransitappbutbetter.Destinations

open class Destination(val route:String) {
    object Bus: Destination("bus")
    object Stop: Destination("stop")
    object Map: Destination("map")
    object Trip: Destination("trip")
    object BusDetail: Destination("busdetail")
    object StopDetail: Destination("stopdetail")
}