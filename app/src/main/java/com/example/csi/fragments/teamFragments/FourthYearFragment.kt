package com.example.csi.fragments.teamFragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.csi.Adapters.TeamFouthRecyclerAdapter
import com.example.csi.Adapters.TeamMembersRecyclerAdapter
import com.example.csi.Interfaces.OnItemClicked
import com.example.csi.Interfaces.RetrofitInterface
import com.example.csi.R
import com.example.csi.databinding.FragmentFourthYearBinding
import com.example.csi.modelclasses.TeamDataClassItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FourthYearFragment : Fragment(), OnItemClicked {
    private lateinit var binding: FragmentFourthYearBinding
    private lateinit var dialog:Dialog
    val membersList = mutableListOf<TeamDataClassItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFourthYearBinding.inflate(layoutInflater)

        //for head coordinators
        var headArrayList= mutableListOf<TeamDataClassItem>()
        binding.teamHeadRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        //for other fourth year members
        binding.teamMemberRecyclerView.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)

        val retrofitBuilder =
            Retrofit.Builder().baseUrl("https://csi-website-backend.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        val request = retrofitBuilder.create(RetrofitInterface::class.java)
        val call = request.TeamGetData()
        call.enqueue(object : Callback<List<TeamDataClassItem>?> {
            override fun onResponse(
                call: Call<List<TeamDataClassItem>?>,
                response: Response<List<TeamDataClassItem>?>
            ) {
                if (response.isSuccessful) {

                    for (res in response.body()!!) {
                        if (res.year == "4th") {
                            membersList.add(res)
                              }
                        if(res.coordinator=="TRUE"){
                            headArrayList.add(res)
                        }
                    }
                    //for heads
                    binding.apply {
                        binding.teamHeadRecyclerView.adapter = TeamFouthRecyclerAdapter(headArrayList,context!!)
                        teamHeadRecyclerView.set3DItem(true)
                        teamHeadRecyclerView.setAlpha(true)
                        teamHeadRecyclerView.setInfinite(true)
                    }

                    //for members
                    binding.teamMemberRecyclerView.adapter =
                        TeamMembersRecyclerAdapter(membersList!!, context!!,this@FourthYearFragment)
                }
            }

            override fun onFailure(call: Call<List<TeamDataClassItem>?>, t: Throwable) {
                Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show()
            }
        })

        //dialog popup
        dialog= Dialog(requireContext())

        return binding.root
    }

    override fun clickedItem(position: Int) {
        dialog.setContentView(R.layout.team_member_popup)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.findViewById<TextView>(R.id.personName).text=membersList[position].name
        dialog.findViewById<TextView>(R.id.personDomain).text=membersList[position].domain
        Glide.with(this).load(membersList[position].video).placeholder(R.drawable.fakeimage).into( dialog.findViewById<ImageView>(R.id.personImage))


        dialog.findViewById<ImageView>(R.id.linkedin).setOnClickListener{
            Toast.makeText(context, membersList[position].linkedin, Toast.LENGTH_SHORT).show()
        }
        dialog.findViewById<ImageView>(R.id.instagram).setOnClickListener{
            Toast.makeText(context, membersList[position].Insta, Toast.LENGTH_SHORT).show()
        }
        dialog.findViewById<ImageView>(R.id.github).setOnClickListener{
            Toast.makeText(context, membersList[position].github, Toast.LENGTH_SHORT).show()

        }
        dialog.show()
    }

}