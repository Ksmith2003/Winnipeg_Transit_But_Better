package com.example.winnipegtransitappbutbetter.Screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.maplibre.compose.camera.CameraPosition
import org.maplibre.compose.camera.rememberCameraState
import org.maplibre.compose.map.MaplibreMap
import org.maplibre.compose.style.BaseStyle
import org.maplibre.spatialk.geojson.Position



@Composable
fun MapScreen(
    navController: NavHostController,
) {
    val camera =
        rememberCameraState(
            firstPosition =
                CameraPosition(target = Position(latitude = 49.895493, longitude = -97.138475), zoom = 16.5)


        )
    MaplibreMap(
        baseStyle = BaseStyle.Uri("https://tiles.openfreemap.org/styles/liberty"),
        cameraState = camera
    )
}