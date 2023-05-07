package com.example.csi.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.csi.fragments.communuityFragments.FeedFragment
import com.example.csi.fragments.communuityFragments.MyQuestionsFragment
import com.example.csi.fragments.communuityFragments.QuestionsFragment

class CommunityViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                FeedFragment()
            }
            1 -> {
                QuestionsFragment()
            }
            2 -> {
                MyQuestionsFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}