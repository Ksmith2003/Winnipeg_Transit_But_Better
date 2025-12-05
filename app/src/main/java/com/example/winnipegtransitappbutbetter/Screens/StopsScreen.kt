package com.example.winnipegtransitappbutbetter.Screens

import android.R
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.Stop
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.StopData
import com.example.winnipegtransitappbutbetter.api.StopsManager

// This will eventually show nearby bus stops

private val List<Stop?>?.name: Any
    get() = this!!::class.java.simpleName

@Composable
fun StopsScreen(navController: NavHostController, modifier: Modifier, stopsManager: StopsManager) {
    val stops = stopsManager.stopsResponse

    Box(
        modifier
            .fillMaxSize()
            .background(Color.Black)
    ){


        val stops = stopsManager.stopsResponse.value
        LazyColumn {
            items(stops) {stop->
                StopCard(StopItem =stop, navController =navController,modifier)
                Log.i("DataStream:", "${stop.stops.name}}")
            }
        }

    }
}

@Composable
fun StopCard(
    StopItem: StopData,
    navController: NavController,
    modifier: Modifier
){
    Column(
        modifier = modifier
            .border(1.dp, Color.Red, shape = RoundedCornerShape(10.dp))
            .fillMaxSize()
            .padding(5.dp)
    ){
        Row(
            modifier = modifier
                .background((Color.DarkGray))
                .fillMaxSize()
                .padding(5.dp)
        ){
                Text(
                    text = "${StopItem.stops.name}",
                    modifier = Modifier,
                    color = (Color.White),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left
                )
        }
    }
}