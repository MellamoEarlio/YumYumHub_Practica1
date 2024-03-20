package com.example.yumyumhub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yumyumhub.databinding.FragmentBlancoBinding


class BlancoFragment : Fragment() {


    private var _binding : FragmentBlancoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_about1, container, false)

        _binding = FragmentBlancoBinding.inflate(inflater, container, false)

        return binding.root
    }


}