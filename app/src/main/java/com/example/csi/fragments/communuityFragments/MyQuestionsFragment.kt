package com.example.csi.fragments.communuityFragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csi.Adapters.CommunityMyQuestionsAdapter
import com.example.csi.Adapters.EventsAdapter
import com.example.csi.Interfaces.RetrofitInterface
import com.example.csi.R
import com.example.csi.databinding.FragmentCommunitySignupBinding
import com.example.csi.databinding.FragmentMyQuestionsBinding
import com.example.csi.modelclasses.CommunityMyQuesDataClass
import com.example.csi.modelclasses.CommunityMyQuesDataClassItem
import com.example.csi.service.RetrofitServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MyQuestionsFragment : Fragment() {
    private lateinit var binding: FragmentMyQuestionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMyQuestionsBinding.inflate(layoutInflater)

        binding.recyclerView.layoutManager=LinearLayoutManager(context)

        fetchQuestions()

        return binding.root

    }

    private fun fetchQuestions() {
        val sharedPreferences=requireContext().getSharedPreferences("Login", Context.MODE_PRIVATE)

        val call = RetrofitServiceBuilder.buildService(RetrofitInterface::class.java).myQuestions(sharedPreferences.getString("Authorization","")!!)

        call.enqueue(object : Callback<List<CommunityMyQuesDataClassItem>?> {
            override fun onResponse(
                call: Call<List<CommunityMyQuesDataClassItem>?>,
                response: Response<List<CommunityMyQuesDataClassItem>?>
            ) {

                if (response.isSuccessful) {
                    val eventList = response.body()
                    binding.recyclerView.adapter=CommunityMyQuestionsAdapter(eventList!!,context!!)
                }

                Log.d("meow",response.body().toString())
            }

            override fun onFailure(call: Call<List<CommunityMyQuesDataClassItem>?>, t: Throwable) {
                Toast.makeText(context, "Check Your Network", Toast.LENGTH_SHORT).show()
            }
        })
    }

}