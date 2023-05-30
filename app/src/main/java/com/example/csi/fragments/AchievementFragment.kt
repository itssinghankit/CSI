package com.example.csi.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csi.AchievementDetActivity
import com.example.csi.Adapters.AchievementAdapter
import com.example.csi.Adapters.onItemClicked
import com.example.csi.Interfaces.RetrofitInterface
import com.example.csi.databinding.FragmentAchievementBinding
import com.example.csi.modelclasses.AchievementsDataClassItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AchievementFragment : Fragment(), onItemClicked {

    private lateinit var binding: FragmentAchievementBinding
    private lateinit var achievementList:List<AchievementsDataClassItem>
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
                    achievementList=response.body()!!
                    binding.AchievementRecyclerview.adapter=AchievementAdapter(achievementList!!,context!!,this@AchievementFragment)
                }
            }

            override fun onFailure(call: Call<List<AchievementsDataClassItem>?>, t: Throwable) {
                Toast.makeText(getContext(), "Check Internet Connection", Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }

    override fun onAchievementclicked(position: Int) {
        val intent=Intent(context,AchievementDetActivity::class.java)
        intent.putExtra("position",position)
        startActivity(intent)
    }

}