package com.example.csi.Interfaces

import com.example.csi.modelclasses.*


import com.example.csi.modelclasses.EventDataClassItem
import com.example.csi.modelclasses.LoginResponseDataClass
import com.example.csi.modelclasses.TeamDataClassItem
import okhttp3.RequestBody
import okhttp3.ResponseBody


import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitInterface {

    @GET("api/postAchievementDetails")
    fun AchievementGetData(): Call<List<AchievementsDataClassItem>>


    @GET ("api/posteventDetails")
    fun EventGetData(): Call<List<EventDataClassItem>>

    @GET("api/postDetails")
    fun TeamGetData():Call<List<TeamDataClassItem>>

    //community page
    @GET("community/token_check/")
     fun communityIsSignedIn(@Header("Authorization")token:String):Call<CommunityIsSignedInDataClass>

     @POST("accounts/login/")
     fun signedIn(@Body requestBody: CommunitySigninRequestDataClass):Call<CommunityAfterSigninDataClass>

    @GET("community/my_questions/")
    fun myQuestions(@Header("Authorization")token:String):Call<List<CommunityMyQuesDataClassItem>>

    @DELETE("/community/question_RUD/{id}")
    fun myQuestionDelete():

}