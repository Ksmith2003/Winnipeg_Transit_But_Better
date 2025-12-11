package com.example.winnipegtransitappbutbetter.api

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.winnipegtransitappbutbetter.BuildConfig
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.Route
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.RouteData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoutesManager {
    private var _routesResponse= mutableStateOf<List<Route>>(emptyList())
    val api_key= BuildConfig.WT_API_KEY

    val routesResponse: MutableState<List<Route>>
        @Composable get() = remember {
            _routesResponse
        }
    init {
        getRoutes()
    }

    private fun getRoutes(){
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
                }
                else {
                    Log.e("API", "Error: ${response.errorBody()?.string()}")
                }
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
}