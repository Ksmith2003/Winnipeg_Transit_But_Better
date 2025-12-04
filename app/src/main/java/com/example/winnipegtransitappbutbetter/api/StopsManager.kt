package com.example.winnipegtransitappbutbetter.api

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.winnipegtransitappbutbetter.BuildConfig

import com.example.winnipegtransitappbutbetter.api.Model.cow_data.StopData


import com.example.winnipegtransitappbutbetter.api.Model.old.StopResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StopsManager {
    private var _stopsResponse= mutableStateOf<List<StopData>>(emptyList())
    val api_key= BuildConfig.WT_API_KEY

    val stopsResponse: MutableState<List<StopData>>
        @Composable get() = remember {
            _stopsResponse
        }
    init{
        getStops()
    }
    private fun getStops(){
        val service = Api.retrofitService.getBusStops(
            lon = -97.138475,
            lat= 49.895493,
            distance= 250,
            api_key
        )

        service.enqueue( object: Callback<StopData>{
            override fun onResponse(
                call: Call<StopData?>,
                response: Response<StopData?>
            ) {
                if (response.isSuccessful){
                    val list = response.body()?.stops ?: emptyList()
                    Log.i("DataStream", list.toString())
                }
                else {
                    Log.e("API", "Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(
                call: Call<StopData?>,
                t: Throwable
            ) {
                Log.d("error","${t.message}")
            }


        }
        )





    }
}