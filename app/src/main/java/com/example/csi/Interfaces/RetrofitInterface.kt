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

<<<<<<< HEAD
<<<<<<< HEAD

    @GET("community/community_page/")
    fun FeedGetData():Call<List<FeedItem>>
=======
=======


    @GET("community/community_page/")
    fun FeedGetData():Call<List<FeedItem>>

>>>>>>> 032a589ddfba06be967f4b5eda0072669a83bba5
    @DELETE("/community/question_RUD/{id}")
    fun communityMyQuestionDelete(@Path("id")itemId:String, @Header("Authorization")token:String):Call<Void>

    @POST("/community/question_create/")
    fun communityQuestCreate(@Header("Authorization")token:String, @Body requestBody: CommunityQuesCreateUpdateReqDataClass):Call<CommunityQuesCreateUpdateRespDataClass>

    @PATCH("/community/question_RUD/{id}")
    fun communityQuesUpdate(@Header("Authorization")token:String,@Path("id") id: String, @Body requestBody:  CommunityQuesCreateUpdateReqDataClass): Call<CommunityQuesCreateUpdateRespDataClass>
<<<<<<< HEAD
>>>>>>> 9f8d9aef0114fa1747d7b44c7fb2b4f3a4b2c9c5
=======

>>>>>>> 032a589ddfba06be967f4b5eda0072669a83bba5


}