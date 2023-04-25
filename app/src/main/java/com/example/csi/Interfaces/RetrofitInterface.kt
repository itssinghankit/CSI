package com.example.csi.Interfaces

import com.example.csi.modelclasses.AchievementsDataClass
import com.example.csi.modelclasses.AchievementsDataClassItem
import com.example.csi.modelclasses.LoginResponseDataClass
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("api/postAchievementDetails")
    fun AchievementGetData(): Call<List<AchievementsDataClassItem>>

}