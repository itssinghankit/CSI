package com.example.csi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csi.Adapters.DomainsAdapter
import com.example.csi.Adapters.EventsAdapter
import com.example.csi.databinding.FragmentHomeBinding
import com.example.csi.modelclasses.Domains
import com.example.csi.modelclasses.HomeEvents

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

        eventArrayList= ArrayList()
        eventArrayList.add(HomeEvents("Carnivals","i am very happy to attend this event as i am the only one to ettand this event so i won and got crore rupees now i am richer than ambamni"))
        eventArrayList.add(HomeEvents("Carnivals","i am very happy to attend this event as i am the only one to ettand this event so i won and got crore rupees now i am richer than ambamni"))
        eventArrayList.add(HomeEvents("Carnivals","i am very happy to attend this event as i am the only one to ettand this event so i won and got crore rupees now i am richer than ambamni"))
        eventArrayList.add(HomeEvents("Carnivals","i am very happy to attend this event as i am the only one to ettand this event so i won and got crore rupees now i am richer than ambamni"))
        binding.eventsRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.eventsRecyclerView.adapter=EventsAdapter(eventArrayList)



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