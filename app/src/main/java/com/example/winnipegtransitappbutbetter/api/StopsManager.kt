package com.example.winnipegtransitappbutbetter.api

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.winnipegtransitappbutbetter.api.Model.StopData
import retrofit2.Call
import retrofit2.Response

class StopsManager {
    private var _stopsResponse= mutableStateOf<List<StopData>>(emptyList())
    val api_key="6FBr9kNoJUqq7ixuxyfm"

    val stopsResponse: MutableState<List<StopData>>
        @Composable get() = remember {
            _stopsResponse
        }
    init{
        getStops()
    }
    private fun getStops(){
        val service = Api.retrofitService.getBusStops(lon = -97.138475, lat= 49.895493, api_key)


        service.enqueue(object : retrofit2.Callback<StopData> {
            override fun onResponse(
                call: Call<StopData?>,
                response: Response<StopData?>
            ) {
                if (response.isSuccessful){
                    Log.i("Data","Data is locked and loaded. ")

                    _stopsResponse.value = (response.body()?.stops ?: emptyList()) as List<StopData>
                    Log.i("DataStream", _stopsResponse.value.toString())
                }
            }

            override fun onFailure(
                call: Call<StopData?>,
                t: Throwable
            ) {
                Log.d("error","${t.message}")
            }

        })
    }
}