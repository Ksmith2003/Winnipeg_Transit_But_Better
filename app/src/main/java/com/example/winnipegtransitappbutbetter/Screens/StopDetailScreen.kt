package com.example.winnipegtransitappbutbetter.Screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.Stop
import com.example.winnipegtransitappbutbetter.api.StopsManager

// Empty because I need to implement the API first to know how I wanna do this screen

@Composable
fun StopDetailScreen(modifier: Modifier.Companion, navController: NavHostController, stop: Stop, stopsManager: StopsManager) {
    Box(
        modifier
            .background(Color.Black)
            .fillMaxSize()
    ){
        Log.i("asdf","${stop.number}")
        Log.i("asdf","${stop.name}")
    }
    Column{
        Text(
            text = "Stop ${stop.number.toString()} - ${stop.name.toString()}",
            modifier = Modifier,
            fontWeight = FontWeight.Bold,
            color = (Color.White)
        )

        // Image Box with overlaid buttons similar to
        // a div in web dev
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
        )
        Column(
            Modifier.padding(20.dp)
        ){
            Spacer(
                modifier = Modifier.padding(5.dp))

            stop.number?.let{
                Text(
                    text = "Stop: $it",
                    modifier = Modifier.padding(end=5.dp),
                    maxLines = 1,
                    fontSize = 12.sp,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(5.dp))
                stop.name?.let {
                    Text(
                        text= "$it",
                        modifier = Modifier.padding(end=8.dp),
                        maxLines = 3,
                        fontSize = 16.sp,
                        overflow= TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyMedium,
                        color=Color.White
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
//                Row {
//                    movie.voteAverage?.let {
//                        Text(
//                            text = "Avg Vote: $it",
//                            modifier = Modifier.padding(end = 8.dp),
//                            maxLines = 1,
//                            fontSize = 20.sp,
//                            overflow = TextOverflow.Ellipsis,
//                            style = MaterialTheme.typography.labelLarge,
//                            color = Color.White
//                        )
//                    }
//                    movie.voteCount?.let {
//                        Text(
//                            text = "# of votes: $it",
//                            modifier = Modifier.padding(end = 8.dp),
//                            maxLines = 1,
//                            fontSize = 20.sp,
//                            overflow = TextOverflow.Ellipsis,
//                            style = MaterialTheme.typography.labelLarge,
//                            color = Color.White
//                        )
//                    }
                }
            }
        }
    }
