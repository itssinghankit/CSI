package com.example.csi.Interfaces

import com.example.csi.modelclasses.*


import com.example.csi.modelclasses.EventDataClassItem
import com.example.csi.modelclasses.TeamDataClassItem


import retrofit2.Call
import retrofit2.http.*

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
     fun communitySignedIn(@Body requestBody: CommunitySigninRequestDataClass):Call<CommunityAfterSigninDataClass>

    @GET("community/my_questions/")
    fun communityMyQuestions(@Header("Authorization")token:String):Call<List<CommunityMyQuesDataClassItem>>



    @GET("community/community_page/")
    fun FeedGetData():Call<List<FeedItem>>

    @DELETE("/community/question_RUD/{id}")
    fun communityMyQuestionDelete(@Path("id")itemId:String, @Header("Authorization")token:String):Call<Void>

    @POST("/community/question_create/")
    fun communityQuestCreate(@Header("Authorization")token:String, @Body requestBody: CommunityQuesCreateUpdateReqDataClass):Call<CommunityQuesCreateUpdateRespDataClass>

    @PATCH("/community/question_RUD/{id}")
    fun communityQuesUpdate(@Header("Authorization")token:String,@Path("id") id: String, @Body requestBody:  CommunityQuesCreateUpdateReqDataClass): Call<CommunityQuesCreateUpdateRespDataClass>



}