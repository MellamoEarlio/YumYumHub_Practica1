package com.example.yumyumhub.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yumyumhub.data.Recetas
import com.example.yumyumhub.databinding.ItemRecetasBinding

class RecetasViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemRecetasBinding.bind(view)

    fun render(receta: Recetas, onClickListener: (Int) -> Unit, onDetallesClickListener: (Int) -> Unit) {
        binding.tvrecetaNombre.text = receta.nombre
        binding.tvrecetaAutor.text = receta.autor
        binding.tvrecetaTiempo.text = receta.tiempo.toString()
        binding.tvrecetaDescripcion.text = receta.descripcion
        binding.tvrecetaIngredientes.text = receta.ingredientes.joinToString(", ")

        Glide.with(binding.ivreceta.context).load(receta.imagen).into(binding.ivreceta)

        itemView.setOnClickListener { onClickListener(adapterPosition) }
        binding.detalles.setOnClickListener { onDetallesClickListener(adapterPosition) }
    }
}
