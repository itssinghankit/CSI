package com.example.csi.fragments.communuityFragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.csi.Interfaces.RetrofitInterface
import com.example.csi.LoginActivity
import com.example.csi.R
import com.example.csi.databinding.FragmentFeedBinding
import com.example.csi.modelclasses.CommunityIsSignedInDataClass
import com.example.csi.service.RetrofitServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FeedFragment : Fragment() {
 private lateinit var binding:FragmentFeedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFeedBinding.inflate(layoutInflater)

        //checking if the shared preference details exist or not(for first time user)
        sharedPrefCheckStart()

        //checking if the Authorization header is valid or not
        isAuthDetCrt()

        return binding.root
    }

    private fun isAuthDetCrt() {
        var sharedPreferences=requireContext().getSharedPreferences("Login", Context.MODE_PRIVATE)

        val service=RetrofitServiceBuilder.buildService(RetrofitInterface::class.java)
        val requestCall=service.communityIsSignedIn(sharedPreferences.getString("Authorization","")!!)

        requestCall.enqueue(object : Callback<CommunityIsSignedInDataClass?> {
            override fun onResponse(
                call: Call<CommunityIsSignedInDataClass?>,
                response: Response<CommunityIsSignedInDataClass?>
            ) {
                if (response.isSuccessful){
                    Log.d("meow",response.code().toString())
                }else{
                    //if the header is not valid, delete previous shared preference and move again to login page

                    sharedPreferences=requireContext().getSharedPreferences("Login", Context.MODE_PRIVATE)
                    sharedPreferences.edit().putString("Authorization","").apply()

                    val intent=Intent(context,LoginActivity::class.java)
                    startActivity(intent)

                }
            }

            override fun onFailure(call: Call<CommunityIsSignedInDataClass?>, t: Throwable) {
                Toast.makeText(context, "Check Your Network", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun sharedPrefCheckStart(){
        //checking if user is already signedin or not
        val sharedPreferences=requireContext().getSharedPreferences("Login", Context.MODE_PRIVATE)

        if (sharedPreferences.getString("Authorization","")==""){
            Toast.makeText(context, "not signed in", Toast.LENGTH_SHORT).show()
            val intent=Intent(context,LoginActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(context, sharedPreferences.getString("Authorization",""), Toast.LENGTH_SHORT).show()
        }

    }

    }