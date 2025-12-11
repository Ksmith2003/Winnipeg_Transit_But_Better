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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.Route
import com.example.winnipegtransitappbutbetter.api.RoutesManager
import com.example.winnipegtransitappbutbetter.db.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Empty because I need to implement the API first to know how I wanna do this screen

@Composable
fun BusDetailScreen(modifier: Modifier,
                    route: Route,
                    routesManager: RoutesManager,
                    db: AppDatabase,
                    navController: NavController) {
    Box(
        modifier
            .background(Color.Black)
            .fillMaxSize()
    ){
        Log.i("yippee","${route.number}}")
        Log.i("yippee","${route.name}")


        Column{
            Text(
                modifier = Modifier
                    .background(Color.Black)
                    .padding(vertical = 5.dp)
                    .fillMaxWidth(),
                text = "Bus Route",
                style = MaterialTheme.typography.headlineMedium,
                color=Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left
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

                route.number?.let{
                    Text(
                        text = "Route $it",
                        modifier = Modifier.padding(end=5.dp),
                        maxLines = 1,
                        fontSize = 12.sp,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.labelLarge,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    route.name?.let {
                        Text(
                            text= it,
                            modifier = Modifier.padding(end=8.dp),
                            maxLines = 3,
                            fontSize = 16.sp,
                            overflow= TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyMedium,
                            color=Color.White
                        )
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    }
                }
            }
        }
    }