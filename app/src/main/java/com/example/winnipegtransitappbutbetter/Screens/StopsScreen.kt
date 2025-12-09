package com.example.winnipegtransitappbutbetter.Screens

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
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.Stop
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.StopData
import com.example.winnipegtransitappbutbetter.api.StopsManager

// This will eventually show nearby bus stops

@Composable
fun BusStopCard(navController: NavHostController, modifier: Modifier.Companion, stop: Stop) {
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
                    navController.navigate("stopdetail/${stop.key}")
                }
        ) {
            Text(
                //text = "Stop 20254 - Eastbound Portage at Rouge",
                text = "Stop ${stop.number.toString()} - ${stop.name.toString()}",
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

@Composable
fun StopsScreen(navController: NavHostController, modifier: Modifier, stopsManager: StopsManager) {
    val stops = stopsManager.stopsResponse.value
    Log.i("MJB", stops.toString())

    Box(
        modifier
            .fillMaxSize()
            .background(Color.Black)
    ){

        LazyColumn {
            items(stops){
                stop->
                BusStopCard(
                    navController = navController,
                    modifier = Modifier,
                    stop
                )
            }
        }

    }
}