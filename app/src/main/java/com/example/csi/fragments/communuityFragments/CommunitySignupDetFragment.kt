package com.example.csi.fragments.communuityFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.csi.R
import com.example.csi.databinding.FragmentCommunitySignupDetBinding


class CommunitySignupDetFragment : Fragment() {
    private lateinit var binding:FragmentCommunitySignupDetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCommunitySignupDetBinding.inflate(layoutInflater)

        val arrayList= listOf("CSE","CS-IT","CSE(AIML)","CSE(DS)","CS","IT","ECE","ME","CE","EN")
        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item,arrayList)
        binding.branch.adapter=adapter

        return binding.root
    }

}