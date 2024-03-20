package com.example.yumyumhub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.yumyumhub.databinding.FragmentNegroBinding


class NegroFragment : Fragment() {

    private var _binding: FragmentNegroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNegroBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Set click listener for the button using binding
        binding.btnMenu.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_menuFragment)
        }

        return root // Return the root view from binding
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun closeFragment() {
        requireActivity().supportFragmentManager.popBackStack()
    }
}