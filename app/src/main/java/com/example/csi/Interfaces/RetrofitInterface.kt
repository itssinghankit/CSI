package com.example.csi.Interfaces

import com.example.csi.modelclasses.*

import okhttp3.ResponseBody

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitInterface {

    @GET("api/postAchievementDetails")
    fun AchievementGetData(): Call<List<AchievementsDataClassItem>>


    @GET ("api/posteventDetails")
    fun EventGetData(): Call<List<EventDataClassItem>>

    @GET("api/postDetails")
    fun TeamGetData():Call<List<TeamDataClassItem>>

    //community page
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjg4NjQxNzA4LCJpYXQiOjE2ODYwNDk3MDgsImp0aSI6IjI1YmFjMTgyMWZmNDRiZWQ4MGJlZDY0Y2QyMjMzYzIzIiwidXNlcl9pZCI6Mn0.0711K1FNBR__DD-9_-eWOPTDn0x6M0qe8OujmQuJy4F")
    @GET("community/token_check/")
     fun communityIsSignedIn():Call<CommunityIsSignedInDataClass>


}