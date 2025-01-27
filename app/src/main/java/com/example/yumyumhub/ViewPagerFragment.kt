package com.example.yumyumhub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yumyumhub.adapter.ViewPagerAdapter
import com.example.yumyumhub.databinding.FragmentViewPagerBinding


class ViewPagerFragment : Fragment() {
    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentViewPagerBinding.inflate(inflater,container,false)
        val adapter = ViewPagerAdapter(requireActivity())

        binding.pager.adapter=adapter

        return binding.root
    }

}