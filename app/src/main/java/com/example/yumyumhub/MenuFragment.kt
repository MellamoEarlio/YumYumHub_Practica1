package com.example.yumyumhub

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.yumyumhub.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)

        //boton de play que lleva al framento CreditFragment.
        binding.creditos.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_creditFragment)
        }
        binding.lista.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_itemListFragment)
        }
        //boton de play que lleva al framento CreditFragment.
        binding.salir.setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_loginFragment)
        }
        return binding.root
    }
}