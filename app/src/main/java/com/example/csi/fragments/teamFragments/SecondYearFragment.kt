package com.example.csi.fragments.teamFragments

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.csi.Adapters.TeamMembersRecyclerAdapter
import com.example.csi.Interfaces.OnItemClicked
import com.example.csi.Interfaces.RetrofitInterface
import com.example.csi.R
import com.example.csi.databinding.FragmentSecondYearBinding
import com.example.csi.modelclasses.TeamDataClassItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SecondYearFragment : Fragment(), OnItemClicked {
    private lateinit var binding: FragmentSecondYearBinding
    private lateinit var dialog: Dialog
    val membersList = mutableListOf<TeamDataClassItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondYearBinding.inflate(layoutInflater)
        binding.teamMemberRecyclerView.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)

        val retrofitBuilder =
            Retrofit.Builder().baseUrl("https://csi-website-backend.onrender.com/")
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

                    for (res in response.body()!!) {
                        if (res.year == "2nd") {
                            membersList.add(res)
                        }
                    }
                    binding.teamMemberRecyclerView.adapter =
                        TeamMembersRecyclerAdapter(
                            membersList!!,
                            context!!,
                            this@SecondYearFragment
                        )
                }
            }

            override fun onFailure(call: Call<List<TeamDataClassItem>?>, t: Throwable) {
                Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show()
            }
        })

        //dialog popup
        dialog = Dialog(requireContext())

        return binding.root
    }

    override fun clickedItem(position: Int) {
        dialog.setContentView(R.layout.team_member_popup)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.findViewById<TextView>(R.id.personName).text = membersList[position].name
        dialog.findViewById<TextView>(R.id.personDomain).text = membersList[position].domain
        Glide.with(this).load(membersList[position].video).placeholder(R.drawable.fakeimage).into(
            dialog.findViewById<ImageView>(
                R.id.personImage
            )
        )

        dialog.findViewById<ImageView>(R.id.linkedin).setOnClickListener {
            openLinkInApp(membersList[position].linkedin)
        }
        dialog.findViewById<ImageView>(R.id.instagram).setOnClickListener {
            openLinkInApp(membersList[position].Insta)
        }
        dialog.findViewById<ImageView>(R.id.github).setOnClickListener {
            openLinkInApp(membersList[position].github)
        }
        dialog.show()

    }

    fun openLinkInApp(url: String) {

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)

        // Verify that there is an app available to handle the intent
//        if (intent.resolveActivity(requireContext().packageManager) != null) {
//            startActivity(intent)
//        }
    }

}