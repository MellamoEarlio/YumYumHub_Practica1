package com.example.yumyumhub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yumyumhub.adapter.RecetasAdapter
import com.example.yumyumhub.data.Recetas
import com.example.yumyumhub.data.RecetasProvider
import com.example.yumyumhub.databinding.FragmentRecyclerBinding

class RecyclerFragment : Fragment() {

    // Variable para la vista binding para evitar fugas de memoria
    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento utilizando view binding
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        // Crear un LinearLayoutManager con el contexto proporcionado
        val manager = LinearLayoutManager(context)

        // Crear una DividerItemDecoration con el contexto y la orientación del LinearLayoutManager
        val decoration = DividerItemDecoration(binding.recyclerRecetas.context, manager.orientation)

        // Configurar el RecyclerView con el layout manager y el adaptador
        binding.recyclerRecetas.layoutManager = manager
        binding.recyclerRecetas.adapter = RecetasAdapter(RecetasProvider.RecetasList) { receta ->
            onItemSelected(receta)
        }

        // Añadir la decoración de ítems al RecyclerView
        binding.recyclerRecetas.addItemDecoration(decoration)
    }

    private fun onItemSelected(receta: Recetas) {
        // Mostrar un mensaje toast con el nombre de la receta seleccionada
        Toast.makeText(requireContext(), receta.nombre, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Limpiar el binding cuando la vista es destruida para evitar fugas de memoria
        _binding = null
    }
}
