package com.example.winnipegtransitappbutbetter.api

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.winnipegtransitappbutbetter.BuildConfig
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.Route
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.RouteData
import com.example.winnipegtransitappbutbetter.db.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoutesManager (
    database: AppDatabase
){
    private var _routesResponse= mutableStateOf<List<Route>>(emptyList())
    val api_key= BuildConfig.WT_API_KEY

    private val database = database

    val routesResponse: MutableState<List<Route>>
        @Composable get() = remember {
            _routesResponse
        }
    init {
        getRoutes(database)
    }

    private fun getRoutes(
        database: AppDatabase
    ){
        val service = Api.retrofitService2.getBusRoutes(
            api_key
        )
        service.enqueue( object: Callback<RouteData>{
            override fun onResponse(
                call: Call<RouteData?>,
                response: Response<RouteData?>
            ) {
                if (response.isSuccessful){
                    _routesResponse.value = (response.body()?.routes ?: emptyList()) as List<Route>
                    Log.i("DataStream", _routesResponse.value.toString())
                    GlobalScope.launch {
                        saveDataToDatabase(database=database, _routesResponse.value)
                    }
                }
                else {
                    Log.e("API", "Error: ${response.errorBody()?.string()}")
                }
            }

            private suspend fun saveDataToDatabase(
                database: AppDatabase,
                routes: List<Route>
            ){
                database.WTDao().insertAllRoutes(routes)
            }

            override fun onFailure(
                call: Call<RouteData?>,
                t: Throwable
            ) {
                Log.d("error","${t.message}")
            }


        }
        )
    }
    suspend fun  refreshStops(){
        var routes = database.WTDao().getAllRoutes()
        _routesResponse.value = routes
    }
}