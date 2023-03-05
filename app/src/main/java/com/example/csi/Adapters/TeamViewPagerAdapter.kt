package com.example.csi.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.csi.fragments.teamFragments.FourthYearFragment
import com.example.csi.fragments.teamFragments.SecondYearFragment
import com.example.csi.fragments.teamFragments.ThirdYearFragment

class TeamViewPagerAdapter(fragmentManager: FragmentManager,lifecycle:Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                FourthYearFragment()
            }
            1->{
                ThirdYearFragment()
            }
            2->{
                SecondYearFragment()
            }
            else->{
                Fragment()
            }
        }
    }
}