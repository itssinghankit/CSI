package com.example.csi.Interfaces

import com.example.csi.modelclasses.AchievementsDataClassItem
<<<<<<< HEAD
import com.example.csi.modelclasses.EventDataClassItem
=======
import com.example.csi.modelclasses.LoginResponseDataClass
import com.example.csi.modelclasses.TeamDataClassItem
>>>>>>> 55de12170ccdd7f88b495e5b0cefd764e9958646
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("api/postAchievementDetails")
    fun AchievementGetData(): Call<List<AchievementsDataClassItem>>

<<<<<<< HEAD
    @GET ("api/posteventDetails")
    fun EventGetData(): Call<List<EventDataClassItem>>
=======
    @GET("api/postDetails")
    fun TeamGetData():Call<List<TeamDataClassItem>>
>>>>>>> 55de12170ccdd7f88b495e5b0cefd764e9958646

}