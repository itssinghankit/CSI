package com.example.csi.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csi.Adapters.DomainsAdapter
import com.example.csi.Adapters.EventsAdapter
import com.example.csi.Interfaces.RetrofitInterface
import com.example.csi.databinding.FragmentHomeBinding
import com.example.csi.modelclasses.Domains
import com.example.csi.modelclasses.EventDataClassItem
import com.example.csi.modelclasses.HomeEvents
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

private lateinit var binding:FragmentHomeBinding
private lateinit var eventArrayList:ArrayList<HomeEvents>
private lateinit var DomainsArrayList:ArrayList<Domains>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(layoutInflater)

        binding.eventsRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        val retrofitBuilder= Retrofit.Builder().baseUrl("https://csiwebsitebackend-production.up.railway.app/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val request=retrofitBuilder.create(RetrofitInterface::class.java)
        val call =request.EventGetData()

        call.enqueue(object : Callback<List<EventDataClassItem>?> {
            override fun onResponse(
                call: Call<List<EventDataClassItem>?>,
                response: Response<List<EventDataClassItem>?>
            ) {
                Log.d("checking",response.body().toString())
                if(response.isSuccessful){
                    val eventList=response.body()
                    binding.eventsRecyclerView.adapter=EventsAdapter(eventList!!,context!!)
                }
            }

            override fun onFailure(call: Call<List<EventDataClassItem>?>, t: Throwable) {
                Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show()
            }
        })

//        eventArrayList= ArrayList()
//        eventArrayList.add(HomeEvents("Carnivals","i am very happy to attend this event as i am the only one to ettand this event so i won and got crore rupees now i am richer than ambamni"))
//        eventArrayList.add(HomeEvents("Carnivals","i am very happy to attend this event as i am the only one to ettand this event so i won and got crore rupees now i am richer than ambamni"))
//        eventArrayList.add(HomeEvents("Carnivals","i am very happy to attend this event as i am the only one to ettand this event so i won and got crore rupees now i am richer than ambamni"))
//        eventArrayList.add(HomeEvents("Carnivals","i am very happy to attend this event as i am the only one to ettand this event so i won and got crore rupees now i am richer than ambamni"))
//        binding.eventsRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
//        binding.eventsRecyclerView.adapter=EventsAdapter(eventArrayList)



        DomainsArrayList = ArrayList()
        DomainsArrayList.add(Domains("App Development","Our team excels in application development, crafting highly functional and efficient mobile apps with passion and expertise. Our code is our craft, and we excel at it."))
        DomainsArrayList.add(Domains("Web Development","Our team pioneers web development with cutting-edge design and technology, creating powerful websites that empower people with ease and precision."))
        DomainsArrayList.add(Domains("Machine Learning","Our machine learning experts build adaptive algorithms using data-driven insights, enhancing efficiency, reliability, and cost-effectiveness beyond static instructions."))
        DomainsArrayList.add(Domains("UI/UX Designing","CSI's talented innovators create stunning visual masterpieces that captivate and inspire. Their imaginative ideas and skills yield awe-inspiring results."))

        val adapter= DomainsAdapter(DomainsArrayList)
        binding.apply {
            domainsrecylerview.adapter= adapter
            domainsrecylerview.set3DItem(true)
            domainsrecylerview.setAlpha(true)
            domainsrecylerview.setInfinite(true)
        }

        return binding.root
    }


}