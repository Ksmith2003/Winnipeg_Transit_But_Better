package com.example.winnipegtransitappbutbetter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.winnipegtransitappbutbetter.Destinations.Destination
import com.example.winnipegtransitappbutbetter.Screens.BusDetailScreen
import com.example.winnipegtransitappbutbetter.Screens.BusesScreen
import com.example.winnipegtransitappbutbetter.Screens.MapScreen
import com.example.winnipegtransitappbutbetter.Screens.StopDetailScreen
import com.example.winnipegtransitappbutbetter.Screens.StopsScreen
import com.example.winnipegtransitappbutbetter.Screens.TripsScreen
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.Stop
import com.example.winnipegtransitappbutbetter.api.StopsManager
import com.example.winnipegtransitappbutbetter.ui.theme.WinnipegTransitAppButBetterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WinnipegTransitAppButBetterTheme {
                val navController = rememberNavController()
                val stopsManager = StopsManager()

                Scaffold(
                    bottomBar = {
                        BottomNav(navController = navController)
                    }
                ) { paddingValues ->
                    paddingValues.calculateBottomPadding()
                    Spacer(modifier = Modifier.padding(10.dp))
                    NavHost(
                        navController = navController,
                        startDestination = Destination.Map.route,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable(Destination.Map.route) {
                            MapScreen(
                                navController = navController,
                            )
                        }
                        composable(Destination.Trip.route) {
                            TripsScreen(
                                modifier = Modifier,
                                navController = navController,

                                )
                        }
                        composable(Destination.Stop.route) {
                            StopsScreen(
                                modifier = Modifier,
                                navController = navController,
                                stopsManager = stopsManager
                            )
                        }

                        composable(Destination.Bus.route) {
                            BusesScreen(
                                modifier = Modifier,
                                navController = navController
                            )
                        }

                        composable(Destination.BusDetail.route) {
                            BusDetailScreen(
                                modifier = Modifier,
                                navController = navController
                            )
                        }

                        composable(Destination.StopDetail.route) {navBackStackEntry->
                            var stop by remember {
                                mutableStateOf<Stop?>(null)
                            }
                            //val movie_id:String?  = navBackStackEntry.arguments?.getString("movieID")

                            //Log.i("MJB", movie_id.toString() )
                            val s = Stop(
                                name = stop?.name,
                                centre = stop?.centre,
                                crossStreet = stop?.crossStreet,
                                direction = stop?.direction,
                                distances = stop?.distances,
                                key = stop?.key,
                                number = stop?.number,
                                side = stop?.side,
                                street = stop?.street
                            )
                            StopDetailScreen(
                                modifier = Modifier,
                                stop = s,
                                navController = navController,
                                stopsManager = stopsManager
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WinnipegTransitAppButBetterTheme {
        Greeting("Android")
    }
}