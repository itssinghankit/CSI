package com.example.csi.fragments.teamFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csi.Adapters.TeamFouthHeadRecyclerAdapter
import com.example.csi.Adapters.TeamFouthRecyclerAdapter
import com.example.csi.Interfaces.RetrofitInterface
import com.example.csi.databinding.FragmentFourthYearBinding
import com.example.csi.modelclasses.TeamDataClass
import com.example.csi.modelclasses.TeamDataClassItem
import com.example.csi.modelclasses.TeamMemberDataClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FourthYearFragment : Fragment() {
private lateinit var binding: FragmentFourthYearBinding
private lateinit var headArrayList: ArrayList<TeamMemberDataClass>
//private lateinit var membersList:MutableList<TeamDataClassItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentFourthYearBinding.inflate(layoutInflater)

        headArrayList= ArrayList()
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))

        binding.teamHeadRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        binding.apply {
            teamHeadRecyclerView.adapter= TeamFouthRecyclerAdapter(headArrayList)
            teamHeadRecyclerView.set3DItem(true)
            teamHeadRecyclerView.setAlpha(true)
            teamHeadRecyclerView.setInfinite(true)
        }

//        binding.teamHeadRecyclerView.adapter=TeamFouthHeadRecyclerAdapter(headArrayList)

        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))

        binding.teamMemberRecyclerView.layoutManager=GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)

        val retrofitBuilder=Retrofit.Builder().baseUrl("https://csiwebsitebackend-production.up.railway.app/").addConverterFactory(GsonConverterFactory.create()).build()
        val request=retrofitBuilder.create(RetrofitInterface::class.java)
        val call=request.TeamGetData()
        call.enqueue(object : Callback<List<TeamDataClassItem>?> {
            override fun onResponse(
                call: Call<List<TeamDataClassItem>?>,
                response: Response<List<TeamDataClassItem>?>
            ) {
               if (response.isSuccessful){
                   val membersList= mutableListOf<TeamDataClassItem>()
                   for (res in response.body()!!){
                       if (res.year=="4th"){
                           membersList.add(res)
                       }
                   }
                   binding.teamMemberRecyclerView.adapter=TeamFouthHeadRecyclerAdapter(membersList!!,context!!)
               }
            }

            override fun onFailure(call: Call<List<TeamDataClassItem>?>, t: Throwable) {
                Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show()
            }
        })

//        binding.teamMemberRecyclerView.adapter=TeamFouthHeadRecyclerAdapter(headArrayList)


        return binding.root
    }


}