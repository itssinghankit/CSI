package com.example.csi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.csi.Adapters.CommunityViewPagerAdapter
import com.example.csi.R
import com.example.csi.databinding.FragmentCommunityBinding
import com.google.android.material.tabs.TabLayoutMediator


class CommunityFragment : Fragment() {
private lateinit var binding:FragmentCommunityBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCommunityBinding.inflate(layoutInflater)

        binding.communityViewPager.adapter=CommunityViewPagerAdapter(requireActivity()!!.supportFragmentManager,lifecycle)
        TabLayoutMediator(binding.communityTabLayout,binding.communityViewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "com.example.csi.modelclasses.Feed"
                }
                1 -> {
                    tab.text = "Questions"
                }
                2 -> {
                    tab.text = "My Questions"
                }
            }

        }.attach()
        return binding.root
    }


}