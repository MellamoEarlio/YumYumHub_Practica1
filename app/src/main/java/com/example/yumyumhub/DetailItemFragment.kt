package com.example.yumyumhub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.yumyumhub.data.Datasource

class DetailItemFragment : Fragment() {
    private val args: DetailItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_item, container, false)

        val recipeTitle = view.findViewById<TextView>(R.id.recipeTitle)
        val recipeAuthor = view.findViewById<TextView>(R.id.recipeAuthor)
        val recipeTiempo = view.findViewById<TextView>(R.id.recipeTiempo)
        val recipeDescription = view.findViewById<TextView>(R.id.recipeDescription)
        val recipeIngredients = view.findViewById<TextView>(R.id.recipeIngredients)
        val recipeImage = view.findViewById<ImageView>(R.id.recipeImage)

        // Obtiene la posición de la receta desde los argumentos
        val pos = args.pos

        // Obtiene la lista de recetas desde el Datasource
        val recetaList = Datasource.getRecetaList()

        // Obtiene la receta correspondiente a la posición dada
        val receta = recetaList[pos]

        recipeTitle.text = receta.nombre
        recipeAuthor.text = receta.autor
        recipeTiempo.text = receta.tiempo.toString()
        recipeDescription.text = receta.descripcion
        recipeIngredients.text = receta.ingredientes.joinToString(", ")

        Glide.with(this)
            .load(receta.imagen)
            .into(recipeImage)

        return view
    }
}
