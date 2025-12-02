package com.example.winnipegtransitappbutbetter

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.winnipegtransitappbutbetter.Destinations.Destination

@Composable
fun BottomNav(navController: NavController){
    NavigationBar {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry.value?.destination

        val ic_bus = painterResource(id = R.drawable.directions_bus_24px)
        val ic_trip = painterResource(id = R.drawable.near_me_24px)
        val ic_map = painterResource(id = R.drawable.explore_24px)
        val ic_schedule = painterResource(id = R.drawable.departure_board_24px)

        NavigationBarItem(
            selected = currentDestination?.route == Destination.Trip.route,
            onClick = {
                navController.navigate(Destination.Trip.route){
                    popUpTo(Destination.Trip.route)
                    launchSingleTop = true
                }},
            icon = { Icon(painter = ic_trip, contentDescription = null)},
            label = { Text(text= "Plan Trip") }
        )
        NavigationBarItem(
            selected = currentDestination?.route == Destination.Stop.route,
            onClick = {
                navController.navigate(Destination.Stop.route){
                    popUpTo(Destination.Stop.route)
                    launchSingleTop = true
                }},
            icon = { Icon(painter = ic_schedule, contentDescription = null)},
            label = { Text(text= "Stops") }
        )
        NavigationBarItem(
            selected = currentDestination?.route == Destination.Bus.route,
            onClick = {
                navController.navigate(Destination.Bus.route){
                    popUpTo(Destination.Bus.route)
                    launchSingleTop = true
                }},
            icon = { Icon(painter = ic_bus, contentDescription = null)},
            label = { Text(text= "Routes") }
        )
        NavigationBarItem(
            selected = currentDestination?.route == Destination.Map.route,
            onClick = {
                navController.navigate(Destination.Map.route){
                    popUpTo(Destination.Map.route)
                    launchSingleTop = true
                }},
            icon = { Icon(painter = ic_map, contentDescription = null)},
            label = { Text(text= "Map") }
        )
    }
}
