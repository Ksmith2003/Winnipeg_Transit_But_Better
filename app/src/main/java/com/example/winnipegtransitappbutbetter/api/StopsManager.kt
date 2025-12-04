package com.example.winnipegtransitappbutbetter.api

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.winnipegtransitappbutbetter.api.Model.StopData
import com.example.winnipegtransitappbutbetter.api.Model.StopResponse
import retrofit2.Call
import retrofit2.Response

class StopsManager {
    private var _stopsResponse= mutableStateOf<List<StopData>>(emptyList())
    val api_key="abbefkfsdfkjk"

    val stopsResponse: MutableState<List<StopData>>
        @Composable get() = remember {
            _stopsResponse
        }
    init{
        getStops()
    }
    private fun getStops(){
        val service = Api.retrofitService.getBusStops(lon = -97.138475, lat= 49.895493, distance= 250, api_key)


        service.enqueue(object : retrofit2.Callback<StopResponse> {
            override fun onResponse(
                call: Call<StopResponse>,
                response: Response<StopResponse>
            ) {
                if (response.isSuccessful){
                    val list = response.body()?.stops ?: emptyList()
                    _stopsResponse.value = list
                    Log.i("DataStream", list.toString())
                }
                else {
                    Log.e("API", "Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(
                call: Call<StopResponse>,
                t: Throwable
            ) {
                Log.d("error","${t.message}")
            }

        })
    }
}