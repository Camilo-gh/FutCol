package com.example.TrabandoEnClase.torneo

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Date

data class Torneo(
    val id: Int,
    val nombre: String,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val fecha_inicio: Date,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val fecha_fin: Date,

    val categoria: String,
    val modalidad: String,
    val organizador: String,
    val precio: Double,
    val sedes: String
)