package com.example.csi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csi.Adapters.EventsAdapter
import com.example.csi.R
import com.example.csi.databinding.FragmentHomeBinding
import com.example.csi.modelclasses.HomeEvents

class HomeFragment : Fragment() {

private lateinit var binding:FragmentHomeBinding
private lateinit var eventArrayList:ArrayList<HomeEvents>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(layoutInflater)


        eventArrayList= ArrayList()
        eventArrayList.add(HomeEvents("Carnivals","i am very happy to attend this event as i am the only one to ettand this event so i won and got crore rupees now i am richer than ambamni"))
        eventArrayList.add(HomeEvents("Carnivals","i am very happy to attend this event as i am the only one to ettand this event so i won and got crore rupees now i am richer than ambamni"))
        eventArrayList.add(HomeEvents("Carnivals","i am very happy to attend this event as i am the only one to ettand this event so i won and got crore rupees now i am richer than ambamni"))
        eventArrayList.add(HomeEvents("Carnivals","i am very happy to attend this event as i am the only one to ettand this event so i won and got crore rupees now i am richer than ambamni"))
//binding.eventsRecyclerView.layoutManager=GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
        binding.eventsRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.eventsRecyclerView.adapter=EventsAdapter(eventArrayList)

        return binding.root
    }


}