package com.example.csi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csi.Adapters.DomainsAdapter
import com.example.csi.Adapters.EventsAdapter
import com.example.csi.Adapters.TeamFouthHeadRecyclerAdapter
import com.example.csi.R
import com.example.csi.databinding.FragmentDomainsBinding
import com.example.csi.databinding.FragmentHomeBinding
import com.example.csi.databinding.FragmentSecondYearBinding
import com.example.csi.modelclasses.Domains
import com.example.csi.modelclasses.HomeEvents

class DomainsFragment : Fragment() {

    private lateinit var bindings: FragmentDomainsBinding
    private lateinit var DomainsArrayList:ArrayList<Domains>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindings= FragmentDomainsBinding.inflate(layoutInflater)

        DomainsArrayList= ArrayList()
        DomainsArrayList.add(Domains("App Development","App development is the act or process by which a mobile app is developed for mobile devices, such as personal digital assistants, enterprise digital assistants or mobile phones. "))
        DomainsArrayList.add(Domains("Web Development","Web development is the work involved in developing a website for the Internet (World Wide Web) or an intranet (a private network). Web development can range from developing a simple website."))
        DomainsArrayList.add(Domains("Machine Learning","App development is the act or process by which a mobile app is developed for mobile devices, such as personal digital assistants, enterprise digital assistants or mobile phones. "))
        DomainsArrayList.add(Domains("UI/UX Designing","App development is the act or process by which a mobile app is developed for mobile devices, such as personal digital assistants, enterprise digital assistants or mobile phones. "))

       bindings.domainsrecylerview.layoutManager= LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

       bindings.domainsrecylerview.adapter= DomainsAdapter(DomainsArrayList)
        return bindings.root
    }

}



