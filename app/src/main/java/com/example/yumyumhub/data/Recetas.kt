package com.example.yumyumhub.data

data class Recetas(
    val id: Int, // Nuevo campo id para identificar la receta
    val nombre: String,
    val autor: String,
    val tiempo: Int,
    val imagen: String,
    val descripcion: String,
    val ingredientes: List<String>
)