package com.example.winnipegtransitappbutbetter

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

// Yes, I know the example routes no longer exist,
// but its just an example (Plus I don't know the new routes' names very well...)

@Composable
fun BusCard(modifier: Modifier, navController: NavHostController){
    Column(
        modifier = modifier
            .border(1.dp, Color.Black, shape= RoundedCornerShape(10.dp))
            .fillMaxSize()
            .padding(5.dp)
    ){
        Text(
            text = "Bus Routes",
            modifier = Modifier,
            fontWeight = FontWeight.Bold,
        )

        Row(
            modifier = modifier
                .background((Color.DarkGray))
                .fillMaxWidth()
                .padding(15.dp)
                .clickable{
                    navController.navigate("busdetail")
                }
        ) {
            Text(
                text = "77 Crosstown North",
                modifier = Modifier,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Row(
            modifier = modifier
                .background((Color.DarkGray))
                .fillMaxWidth()
                .padding(15.dp),
        ) {
            Text(
                text = "78 Crosstown West",
                modifier = Modifier,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun BusesScreen(modifier: Modifier.Companion, navController: NavHostController) {
    Box(
        modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        BusCard(
            navController = navController,
            modifier = modifier
        )
    }
}