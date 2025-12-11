package com.example.winnipegtransitappbutbetter.Screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.Route

import com.example.winnipegtransitappbutbetter.api.RoutesManager
import com.example.winnipegtransitappbutbetter.db.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


// Yes, I know the example routes no longer exist,
// but its just an example (Plus I don't know the new routes' names very well...)

@Composable
fun BusRouteCard(navController: NavHostController, modifier: Modifier.Companion, route: Route) {
    Column(
        modifier = Modifier
            .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp))
            .fillMaxSize()
            .padding(5.dp)
    )

    {
        Row(
            modifier = Modifier
                .background((Color.DarkGray))
                .fillMaxWidth()
                .padding(15.dp)
                .clickable {
                    navController.navigate("busdetail/${route.key}")
                }
        ) {
            Text(
                //text = "Stop 20254 - Eastbound Portage at Rouge",
                text = route.name.toString(),
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                color = (Color.White)
            )
        }

        Spacer(modifier = Modifier.padding(5.dp))
//        Row(
//            modifier = Modifier
//                .background((Color.DarkGray))
//                .fillMaxWidth()
//                .padding(15.dp),
//        ) {
//            Text(
//                text = "Stop 20237 - Westbound Portage at Rouge",
//                modifier = Modifier,
//                fontWeight = FontWeight.Bold,
//                color = (Color.White)
//            )
//        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun BusesScreen(navController: NavHostController, modifier: Modifier, routesManager: RoutesManager, database: AppDatabase) {
    val routes = routesManager.routesResponse.value
    Log.i("MJB", routes.toString())

    GlobalScope.launch {
        database.WTDao().getAllRoutes()
    }

    Box(
        modifier
            .fillMaxSize()
            .background(Color.Black)
    ){

        LazyColumn {
            items(routes){
                    route->
                BusRouteCard(
                    navController = navController,
                    modifier = Modifier,
                    route
                )
            }
        }

    }
}