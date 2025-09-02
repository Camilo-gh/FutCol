package com.example.TrabandoEnClase.torneo

import java.sql.Date

data class Torneo(
    val id: Int,
    val nombre: String,
    val fecha_inicio: Date,
    val fecha_fin: Date,
    val categoria: String,
    val modalidad: String,
    val organizador: String,
    val precio: Double,
    val sedes: String
)