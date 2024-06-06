package com.example.yumyumhub.adapter

import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yumyumhub.R
import com.example.yumyumhub.data.Recetas
import com.example.yumyumhub.databinding.ItemRecetasBinding

class RecetasViewHolder (view:View):RecyclerView.ViewHolder(view){

    val binding = ItemRecetasBinding.bind(view)


    fun render(recetasModel: Recetas, onClickListener:(Recetas)-> Unit){
        binding.tvrecetaNombre.text = recetasModel.nombre
        binding.tvrecetaAutor.text = recetasModel.autor
        binding.tvrecetaTiempo.text = recetasModel.tiempo.toString()
        binding.tvrecetaDescripcion.text = recetasModel.descripcion
        binding.tvrecetaIngredientes.text = recetasModel.ingredientes.joinToString(", ")

        Glide.with(binding.ivreceta.context).load(recetasModel.imagen).into(binding.ivreceta)

        itemView.setOnClickListener{onClickListener(recetasModel)}
        //binding.detalles.setOnClickListener{ findNavController().navigate(R.id.action_recyclerFragment_to_detailItemFragment)}
    }
}