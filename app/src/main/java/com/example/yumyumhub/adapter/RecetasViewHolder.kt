package com.example.yumyumhub.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yumyumhub.R
import com.example.yumyumhub.data.Recetas

class RecetasViewHolder (view:View):RecyclerView.ViewHolder(view){
    val recetas = view.findViewById<TextView>(R.id.tvrecetaNombre)
    val autor = view.findViewById<TextView>(R.id.tvrecetaAutor)
    val tiempo = view.findViewById<TextView>(R.id.tvrecetaTiempo)
    val descripcion = view.findViewById<TextView>(R.id.tvrecetaDescripcion)
    val ingrediente = view.findViewById<TextView>(R.id.tvrecetaIngredientes)
    val foto = view.findViewById<ImageView>(R.id.ivreceta)

    fun render(recetasModel: Recetas){
        recetas.text = recetasModel.nombre
        autor.text = recetasModel.autor
        tiempo.text = recetasModel.tiempo.toString()
        descripcion.text = recetasModel.descripcion
        ingrediente.text = recetasModel.ingredientes.joinToString(", ")
    }
}