package com.example.winnipegtransitappbutbetter

import android.annotation.SuppressLint
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
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.Route
import com.example.winnipegtransitappbutbetter.api.StopsManager
import com.example.winnipegtransitappbutbetter.api.RoutesManager
import com.example.winnipegtransitappbutbetter.db.AppDatabase
import com.example.winnipegtransitappbutbetter.ui.theme.WinnipegTransitAppButBetterTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WinnipegTransitAppButBetterTheme {
                val navController = rememberNavController()
                val db = AppDatabase.getInstance(applicationContext)
                val stopsManager = StopsManager(db)
                val routesManager = RoutesManager(db)

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
                                stopsManager = stopsManager,
                                database = db
                            )
                        }

                        composable(Destination.Bus.route) {
                            BusesScreen(
                                modifier = Modifier,
                                navController = navController,
                                routesManager = routesManager,
                                database = db
                            )
                        }

                        composable(Destination.BusDetail.route) {navBackStackEntry->
                            var route by remember {
                                mutableStateOf<Route?>(null)
                            }
                            val route_id:String?  = navBackStackEntry.arguments?.getString("stopID")

                            //Log.i("MJB", movie_id.toString() )
                            GlobalScope.launch {
                                if (route_id != null ){
                                    route = db.WTDao().getRouteByKey(route_id)
                                }
                            }
                            route?.let{
                                BusDetailScreen(
                                    modifier = Modifier,
                                    navController = navController,
                                    routesManager = routesManager,
                                    db = db,
                                    route = route!!
                                )
                            }
                        }

                        composable(Destination.StopDetail.route) {
                            StopDetailScreen(
                                modifier = Modifier,
                                navController = navController
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