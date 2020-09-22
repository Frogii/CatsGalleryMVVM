package com.example.mymvvm2.network

import com.example.mymvvm2.network.model.CatItem
import retrofit2.Call
import retrofit2.http.GET

const val BASE_URL = "https://api.thecatapi.com/v1/images/"

interface CatNetwork {

    @GET("search?mime_types=jpg&limit=20&page=10&order=Desc")
    fun getData(): Call<List<CatItem>>
}