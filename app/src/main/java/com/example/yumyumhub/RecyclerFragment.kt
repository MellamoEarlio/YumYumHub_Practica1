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
import com.example.yumyumhub.adapter.RecetasAdapter
import com.example.yumyumhub.data.Recetas
import com.example.yumyumhub.data.RecetasProvider
import com.example.yumyumhub.databinding.FragmentRecyclerBinding

class RecyclerFragment : Fragment() {

    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
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
        binding.recyclerRecetas.adapter = RecetasAdapter(RecetasProvider.RecetasList, { receta ->
            onItemSelected(receta)
        }, { receta ->
            onDetallesSelected(receta)
        })

        binding.recyclerRecetas.addItemDecoration(decoration)
    }

    private fun onItemSelected(receta: Recetas) {
        Toast.makeText(requireContext(), receta.nombre, Toast.LENGTH_SHORT).show()
    }

    private fun onDetallesSelected(receta: Recetas) {
        // Obtener el índice de la receta seleccionada en la lista RecetasList
        val index = RecetasProvider.RecetasList.indexOf(receta)
        // Crear la acción con el argumento adecuado (el índice de la receta)
        val action = RecyclerFragmentDirections.actionRecyclerFragmentToDetailItemFragment(recetaIndex = index)
        // Navegar al fragmento de detalles con la acción creada
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
