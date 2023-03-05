package com.example.csi.fragments.teamFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csi.Adapters.TeamFouthHeadRecyclerAdapter
import com.example.csi.R
import com.example.csi.databinding.FragmentFourthYearBinding
import com.example.csi.databinding.FragmentThirdYearBinding
import com.example.csi.modelclasses.TeamMemberDataClass


class ThirdYearFragment : Fragment() {
    private lateinit var binding: FragmentThirdYearBinding
    private lateinit var headArrayList: ArrayList<TeamMemberDataClass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentThirdYearBinding.inflate(layoutInflater)

        headArrayList= ArrayList()

        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))
        headArrayList.add(TeamMemberDataClass("Ankit Singh","app developer"))

        binding.teamMemberRecyclerView.layoutManager=
            GridLayoutManager(context,2, GridLayoutManager.VERTICAL,false)
        binding.teamMemberRecyclerView.adapter= TeamFouthHeadRecyclerAdapter(headArrayList)
        return binding.root
    }


}