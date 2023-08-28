package com.example.csi

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.csi.Interfaces.RetrofitInterface
import com.example.csi.databinding.ActivityCommunityQeusAddBinding
import com.example.csi.modelclasses.CommunityQuesCreateUpdateReqDataClass
import com.example.csi.modelclasses.CommunityQuesCreateUpdateRespDataClass
import com.example.csi.service.RetrofitServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommunityQeusAddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommunityQeusAddBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityQeusAddBinding.inflate(layoutInflater)

        sharedPreferences = this.getSharedPreferences("Login", Context.MODE_PRIVATE)
        var domain = "FRONTEND"

        val arrayList = arrayListOf("FRONTEND", "BACKEND", "APP", "MACHINE LEARNING")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList)
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        binding.domain.adapter = adapter

        binding.domain.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                domain = parent?.getItemAtPosition(position).toString()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                domain = "FRONTEND"
            }

        }

        binding.add.setOnClickListener {
            val question = binding.question.text.toString()
            createQuestion(question, domain)
        }

        binding.back.setOnClickListener {

        }

        setContentView(binding.root)
    }

    private fun createQuestion(question: String, domain: String) {
        if (binding.question.text!!.isNotEmpty()) {

            val questionObject = CommunityQuesCreateUpdateReqDataClass(question, domain)

            val call = RetrofitServiceBuilder.buildService(RetrofitInterface::class.java)
                .communityQuestCreate(
                    sharedPreferences.getString("Authorization", "")!!,
                    questionObject
                )

            call.enqueue(object : Callback<CommunityQuesCreateUpdateRespDataClass?> {
                override fun onResponse(
                    call: Call<CommunityQuesCreateUpdateRespDataClass?>,
                    response: Response<CommunityQuesCreateUpdateRespDataClass?>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(
                            this@CommunityQeusAddActivity,
                            "Question Added Successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this@CommunityQeusAddActivity,
                            "Failed adding Question",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<CommunityQuesCreateUpdateRespDataClass?>, t: Throwable) {
                    Toast.makeText(
                        this@CommunityQeusAddActivity,
                        "Check Your Connection",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })

        } else {
            Toast.makeText(this, "Enter the question", Toast.LENGTH_SHORT).show()
        }

    }
}


