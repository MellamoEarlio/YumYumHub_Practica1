package com.example.yumyumhub.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yumyumhub.data.Recetas
import com.example.yumyumhub.databinding.ItemRecetasBinding

class RecetasViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val binding = ItemRecetasBinding.bind(view)

    fun render(recetasModel: Recetas, onClickListener: (Recetas) -> Unit, onDetallesClickListener: (Recetas) -> Unit) {
        binding.tvrecetaNombre.text = recetasModel.nombre
        binding.tvrecetaAutor.text = recetasModel.autor
        binding.tvrecetaTiempo.text = recetasModel.tiempo.toString()
        binding.tvrecetaDescripcion.text = recetasModel.descripcion
        binding.tvrecetaIngredientes.text = recetasModel.ingredientes.joinToString(", ")

        Glide.with(binding.ivreceta.context).load(recetasModel.imagen).into(binding.ivreceta)

        itemView.setOnClickListener { onClickListener(recetasModel) }
        binding.detalles.setOnClickListener { onDetallesClickListener(recetasModel) }
    }
}
