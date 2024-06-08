package com.example.yumyumhub

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.yumyumhub.data.Recetas

private const val ARG_RECETA = "receta"

class DetailItemFragment : Fragment() {

    private lateinit var receta: Recetas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            receta = it.getParcelable(ARG_RECETA)!!
        }
    }

    @SuppressLint("MissingInflatedId")
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

        recipeTitle.text = receta.nombre
        recipeAuthor.text = receta.autor
        recipeTiempo.text = receta.tiempo.toString() // Asegúrate de convertirlo a String
        recipeDescription.text = receta.descripcion
        recipeIngredients.text = receta.ingredientes.joinToString(", ")

        Glide.with(this)
            .load(receta.imagen)
            .into(recipeImage)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(receta: Recetas) =
            DetailItemFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_RECETA, receta)
                }
            }
    }
}
