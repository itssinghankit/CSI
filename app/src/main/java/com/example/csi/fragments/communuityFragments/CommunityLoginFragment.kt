package com.example.csi.fragments.communuityFragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.csi.Interfaces.RetrofitInterface
import com.example.csi.MainActivity
import com.example.csi.R
import com.example.csi.databinding.FragmentCommunityLoginBinding
import com.example.csi.modelclasses.CommunityAfterSigninDataClass
import com.example.csi.modelclasses.CommunitySigninRequestDataClass
import com.example.csi.service.RetrofitServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CommunityLoginFragment : Fragment() {
    private lateinit var binding: FragmentCommunityLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCommunityLoginBinding.inflate(layoutInflater)

        binding.login.setOnClickListener{
            //sending the data to server
            val signinObject=CommunitySigninRequestDataClass(binding.email.text.toString(),binding.password.text.toString())

            val service=RetrofitServiceBuilder.buildService(RetrofitInterface::class.java)
            val call=service.signedIn(signinObject)

            call.enqueue(object : Callback<CommunityAfterSigninDataClass?> {
                override fun onResponse(
                    call: Call<CommunityAfterSigninDataClass?>,
                    response: Response<CommunityAfterSigninDataClass?>
                ) {

                    if (response.isSuccessful){
                        val sharedPreferences=requireContext().getSharedPreferences("Login", Context.MODE_PRIVATE)
                        sharedPreferences.edit().putString("Authorization","Bearer ${response.body()!!.access}").apply()

                        //if signin is successful move to main activity
                        val intent=Intent(context,MainActivity::class.java)
                        startActivity(intent)
                        requireActivity().finish()
                    }else{
                        Toast.makeText(context, "Enter correct Email or Password", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<CommunityAfterSigninDataClass?>, t: Throwable) {
                    Toast.makeText(context, "Check Your Network", Toast.LENGTH_SHORT).show()
                }
            })

        }

        binding.signup.setOnClickListener{
            findNavController().navigate(R.id.communitySignupFragment)
        }

        return binding.root
    }

}