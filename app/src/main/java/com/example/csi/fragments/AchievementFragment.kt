package com.example.csi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csi.Adapters.AchievementAdapter
import com.example.csi.R
import com.example.csi.databinding.FragmentAchievementBinding
import com.example.csi.databinding.FragmentThirdYearBinding
import com.example.csi.modelclasses.AchievementDataClass

class AchievementFragment : Fragment() {

    private lateinit var binding: FragmentAchievementBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAchievementBinding.inflate(layoutInflater)

        val arraylist=ArrayList<AchievementDataClass>()
        arraylist.add(AchievementDataClass("Smart India Hackathon 0"))
        arraylist.add(AchievementDataClass("Smart India Hackathon 1"))
        arraylist.add(AchievementDataClass("Smart India Hackathon 2"))
        arraylist.add(AchievementDataClass("Smart India Hackathon 3"))
        arraylist.add(AchievementDataClass("Smart India Hackathon 4"))
        arraylist.add(AchievementDataClass("Smart India Hackathon 5"))
        arraylist.add(AchievementDataClass("Smart India Hackathon 6"))
        arraylist.add(AchievementDataClass("Smart India Hackathon 7"))
        arraylist.add(AchievementDataClass("Smart India Hackathon 8"))

        binding.AchievementRecyclerview.layoutManager=LinearLayoutManager(context)
        binding.AchievementRecyclerview.adapter=AchievementAdapter(arraylist)

        return binding.root
    }


}