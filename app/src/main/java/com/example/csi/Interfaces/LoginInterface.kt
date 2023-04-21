package com.example.csi.Interfaces

import com.example.csi.modelclasses.LoginDataClass
import com.example.csi.modelclasses.LoginResponseDataClass
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginInterface {
    @POST("accounts/login/")
    fun sendData(@Body data:LoginDataClass):Call<LoginResponseDataClass> // response

}