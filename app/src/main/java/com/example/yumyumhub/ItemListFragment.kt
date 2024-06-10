package com.example.yumyumhub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yumyumhub.adapter.RecetaAdapter
import com.example.yumyumhub.data.RecetasProvider
import com.example.yumyumhub.databinding.FragmentItemListBinding

class ItemListFragment : Fragment() {

    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

    private var listarecetas = RecetasProvider.RecetasList
    private lateinit var recetaadapter: RecetaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(context)
        val decoration = DividerItemDecoration(binding.recyclerRecetas.context, manager.orientation)

        binding.recyclerRecetas.layoutManager = manager
        binding.recyclerRecetas.adapter = RecetaAdapter(
            listarecetas,
            { pos -> onItemSelected(pos) },
            { pos -> onDetallesSelected(pos) }
        )

        binding.recyclerRecetas.addItemDecoration(decoration)
    }

    private fun onItemSelected(pos: Int) {
        Toast.makeText(requireContext(), listarecetas[pos].nombre, Toast.LENGTH_SHORT).show()
    }

    private fun onDetallesSelected(pos: Int) {
        findNavController().navigate(ItemListFragmentDirections.actionItemListFragmentToDetailItemFragment(pos))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
