package com.example.csi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.csi.Adapters.EventsAdapter
import com.example.csi.Interfaces.RetrofitInterface
import com.example.csi.databinding.ActivityEventsDetBinding
import com.example.csi.modelclasses.EventDataClassItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class EventsDetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventsDetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventsDetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position", 0)

        val retrofitBuilder =
            Retrofit.Builder().baseUrl("https://csi-website-backend.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create()).build()

        val request = retrofitBuilder.create(RetrofitInterface::class.java)
        val call = request.EventGetData()
        call.enqueue(object : Callback<List<EventDataClassItem>?> {
            override fun onResponse(
                call: Call<List<EventDataClassItem>?>,
                response: Response<List<EventDataClassItem>?>
            ) {
                if (response.isSuccessful) {
                    val eventList = response.body()!!
                    binding.title.text = eventList[position].title

                    binding.StartingDate.text = eventList[position].startingDate
                    binding.description.text=eventList[position].description
                    binding.endingDate.text = eventList[position].endingDate
                    Glide.with(this@EventsDetActivity)
                        .load(eventList[position].image)
                        .placeholder(R.drawable.fakeimage)
                        .into(binding.image)
                }
            }

            override fun onFailure(call: Call<List<EventDataClassItem>?>, t: Throwable) {
                Toast.makeText(
                    this@EventsDetActivity,
                    "Check Internet Connection",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        binding.back.setOnClickListener {
            finish()
        }

    }

}