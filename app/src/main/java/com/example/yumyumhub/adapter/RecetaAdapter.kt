package com.example.yumyumhub.adapter

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yumyumhub.R
import com.example.yumyumhub.data.Recetas

class RecetasAdapter(private val recetasList: List<Recetas>, private val onClickListener:(Recetas)-> Unit) : RecyclerView.Adapter<RecetasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecetasViewHolder(layoutInflater.inflate(R.layout.item_recetas, parent, false))
    }

    override fun getItemCount(): Int = recetasList.size

    override fun onBindViewHolder(holder: RecetasViewHolder, position: Int) {
    val item = recetasList [position]
        holder.render(item, onClickListener)
    }

}
