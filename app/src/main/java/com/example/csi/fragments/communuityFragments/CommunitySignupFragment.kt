package com.example.csi.fragments.communuityFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.csi.R
import com.example.csi.databinding.FragmentCommunityLoginBinding
import com.example.csi.databinding.FragmentCommunitySignupBinding


class CommunitySignupFragment : Fragment() {
    private lateinit var binding: FragmentCommunitySignupBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCommunitySignupBinding.inflate(layoutInflater)

        binding.next.setOnClickListener{
            findNavController().navigate(R.id.communitySignupDetFragment)
        }

        binding.signin.setOnClickListener{
            findNavController().navigate(R.id.communityLoginFragment)
        }

        return binding.root
    }

}