package com.example.mymvvm2.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.mymvvm2.network.BASE_URL
import com.example.mymvvm2.network.CatNetwork
import com.example.mymvvm2.network.model.CatItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityRepository(val application: Application) {

    val catsList = MutableLiveData<List<CatItem>>()

    fun getCats() {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(CatNetwork::class.java)
        service.getData().enqueue(object : Callback<List<CatItem>> {

            override fun onResponse(call: Call<List<CatItem>>, response: Response<List<CatItem>>) {
                catsList.value = response.body()
                Log.d("TAG", response.body().toString())
            }

            override fun onFailure(call: Call<List<CatItem>>, t: Throwable) {
                Toast.makeText(application, "Network ERROR", Toast.LENGTH_SHORT).show()
            }
        })
    }
}