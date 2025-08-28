package com.example.TrabandoEnClase

import java.time.LocalDate
import java.time.LocalTime

data class Encuentro(
    val id: Long? = null,
    val torneoId: Long? = null,
    val equipoLocalId: Long? = null,
    val equipoVisitanteId: Long? = null,
    val juezId: Long? = null,
    val sedeId: Long? = null,
    val fecha: LocalDate? = null,       // Utilizando LocalDate para la fecha
    val hora: LocalTime? = null,        // Utilizando LocalTime para la hora
    val golesLocal: Int? = null,
    val golesVisitante: Int? = null,
    val estado: String? = null
)
