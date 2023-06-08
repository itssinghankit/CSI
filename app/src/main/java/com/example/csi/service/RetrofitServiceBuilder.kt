package com.example.csi.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitServiceBuilder {

    private val BASE_URL="https://csi-app-backend.onrender.com/"

    //retrofit builder
    private val builder=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())

    //retrofit instance
    private val retrofit= builder.build()

    fun<T> buildService(serviceType:Class<T>):T{
        return retrofit.create(serviceType)
    }

}