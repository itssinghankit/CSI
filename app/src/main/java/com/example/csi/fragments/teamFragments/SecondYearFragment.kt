package com.example.csi.fragments.teamFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.csi.Adapters.TeamMembersRecyclerAdapter
import com.example.csi.Interfaces.RetrofitInterface
import com.example.csi.databinding.FragmentSecondYearBinding
import com.example.csi.modelclasses.TeamDataClassItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SecondYearFragment : Fragment() {
    private lateinit var binding: FragmentSecondYearBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSecondYearBinding.inflate(layoutInflater)
        binding.teamMemberRecyclerView.layoutManager=GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)

        val retrofitBuilder =
            Retrofit.Builder().baseUrl("https://csiwebsitebackend-production.up.railway.app/")
                .addConverterFactory(
                    GsonConverterFactory.create()
                ).build()
        val request = retrofitBuilder.create(RetrofitInterface::class.java)
        val call = request.TeamGetData()
        call.enqueue(object : Callback<List<TeamDataClassItem>?> {
            override fun onResponse(
                call: Call<List<TeamDataClassItem>?>,
                response: Response<List<TeamDataClassItem>?>
            ) {
                if (response.isSuccessful) {
                    val membersList = mutableListOf<TeamDataClassItem>()
                    for (res in response.body()!!) {
                        if (res.year == "2nd") {
                            membersList.add(res)
                        }
                    }
                    binding.teamMemberRecyclerView.adapter =
                        TeamMembersRecyclerAdapter(membersList!!, context!!)
                }
            }

            override fun onFailure(call: Call<List<TeamDataClassItem>?>, t: Throwable) {
                Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }


}