package com.example.csi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.csi.Adapters.TeamViewPagerAdapter
import com.example.csi.R
import com.example.csi.databinding.FragmentTeamBinding
import com.google.android.material.tabs.TabLayoutMediator


class TeamFragment : Fragment() {

private lateinit var binding:FragmentTeamBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentTeamBinding.inflate(layoutInflater)

        binding.teamViewPager.adapter=TeamViewPagerAdapter(requireActivity()!!.supportFragmentManager,lifecycle)
        TabLayoutMediator(binding.teamTabLayout,binding.teamViewPager){
            tab,position->
            when(position){
                0->{
                    tab.text="Fourth Year"
                }
                1->{
                    tab.text="Third Year"
                }
                2->{
                    tab.text="Second Year"
                }
            }
        }.attach()




        return binding.root
    }

}