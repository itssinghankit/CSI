package com.example.csi.Interfaces

import com.example.csi.modelclasses.AchievementsDataClassItem
import com.example.csi.modelclasses.EventDataClassItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("api/postAchievementDetails")
    fun AchievementGetData(): Call<List<AchievementsDataClassItem>>

    @GET ("api/posteventDetails")
    fun EventGetData(): Call<List<EventDataClassItem>>

}