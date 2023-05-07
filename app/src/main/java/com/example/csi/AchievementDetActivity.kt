package com.example.csi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.csi.Adapters.SliderAdapater
import com.example.csi.Interfaces.RetrofitInterface
import com.example.csi.databinding.ActivityAchievementDetBinding
import com.example.csi.modelclasses.AchievementImagesDataClass
import com.example.csi.modelclasses.AchievementsDataClassItem
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AchievementDetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAchievementDetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAchievementDetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position", 0)
        val arrayList = ArrayList<AchievementImagesDataClass>()

        val retrofitBuilder =
            Retrofit.Builder().baseUrl("https://csiwebsitebackend-production.up.railway.app/")
                .addConverterFactory(GsonConverterFactory.create()).build()

        val request = retrofitBuilder.create(RetrofitInterface::class.java)
        val call = request.AchievementGetData()
        call.enqueue(object : Callback<List<AchievementsDataClassItem>?> {
            override fun onResponse(
                call: Call<List<AchievementsDataClassItem>?>,
                response: Response<List<AchievementsDataClassItem>?>
            ) {
                if (response.isSuccessful) {
                    val achievementList = response.body()!!
                    binding.venue.text = achievementList[position].venue
                    arrayList.add(AchievementImagesDataClass(achievementList[position].photo1))
                    arrayList.add(AchievementImagesDataClass(achievementList[position].photo2))
                    arrayList.add(AchievementImagesDataClass(achievementList[position].photo3))

                    binding.sliderCarousel.setSliderAdapter(
                        SliderAdapater(
                            arrayList,
                            this@AchievementDetActivity
                        )
                    )
                    binding.sliderCarousel.setIndicatorAnimation(IndicatorAnimationType.WORM)
                    binding.sliderCarousel.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
                    binding.sliderCarousel.startAutoCycle()

                    binding.teamname.text = achievementList[position].Teamname
                    binding.date.text = achievementList[position].date
                    var members = ""
                    for (member in achievementList[position].members) {
                        if (members == "") {
                            members = members + member
                        } else {
                            members = members + ", " + member
                        }
                    }
                    binding.members.text = members
                }
            }

            override fun onFailure(call: Call<List<AchievementsDataClassItem>?>, t: Throwable) {
                Toast.makeText(
                    this@AchievementDetActivity,
                    "Check Internet Connection",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        binding.back.setOnClickListener {
            finish()
        }

    }

}