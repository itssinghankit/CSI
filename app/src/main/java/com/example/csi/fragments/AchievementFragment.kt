package com.example.csi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csi.Adapters.AchievementAdapter
import com.example.csi.Interfaces.RetrofitInterface
import com.example.csi.databinding.FragmentAchievementBinding
import com.example.csi.modelclasses.AchievementsDataClassItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AchievementFragment : Fragment() {

    private lateinit var binding: FragmentAchievementBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAchievementBinding.inflate(layoutInflater)

        binding.AchievementRecyclerview.layoutManager=LinearLayoutManager(context)

        val retrofitBuilder= Retrofit.Builder().baseUrl("https://csiwebsitebackend-production.up.railway.app/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val request=retrofitBuilder.create(RetrofitInterface::class.java)
        val call =request.AchievementGetData()
        call.enqueue(object : Callback<List<AchievementsDataClassItem>?> {
            override fun onResponse(
                call: Call<List<AchievementsDataClassItem>?>,
                response: Response<List<AchievementsDataClassItem>?>
            ) {
                if(response.isSuccessful){
                    val achievementList=response.body()
                    binding.AchievementRecyclerview.adapter=AchievementAdapter(achievementList!!,context!!)
                }
            }

            override fun onFailure(call: Call<List<AchievementsDataClassItem>?>, t: Throwable) {
                Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show()
            }
        })

//        val arraylist=ArrayList<AchievementDataClass>()
//        arraylist.add(AchievementDataClass("Smart India Hackathon 0"))
//        arraylist.add(AchievementDataClass("Smart India Hackathon 1"))
//        arraylist.add(AchievementDataClass("Smart India Hackathon 2"))
//        arraylist.add(AchievementDataClass("Smart India Hackathon 3"))
//        arraylist.add(AchievementDataClass("Smart India Hackathon 4"))
//        arraylist.add(AchievementDataClass("Smart India Hackathon 5"))
//        arraylist.add(AchievementDataClass("Smart India Hackathon 6"))
//        arraylist.add(AchievementDataClass("Smart India Hackathon 7"))
//        arraylist.add(AchievementDataClass("Smart India Hackathon 8"))




        return binding.root
    }


}