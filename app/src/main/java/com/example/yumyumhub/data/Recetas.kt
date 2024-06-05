package com.example.yumyumhub.data

//Clase con los objetos del RecyclerView.
data class Recetas(
    val nombre: String,
    val autor: String,
    val tiempo: Int,
    val imagen: String,
    val descripcion: String,
    val ingredientes: List<String>
)