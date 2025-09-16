package com.example.TrabandoEnClase.Encuentros

import java.time.LocalDate
import java.time.LocalTime

data class Encuentro(
    val id: Long? = null,
    val torneoId: Long? = null,
    val equipoLocalId: Long? = null,
    val equipoVisitanteId: Long? = null,
    val juezId: Long? = null,
    val sedeId: Long? = null,
    val fecha: LocalDate? = null,
    val hora: LocalTime? = null,
    val golesLocal: Int? = null,
    val golesVisitante: Int? = null,
    val estado: String? = null
)

// SENTENCIA SQL:
// CREATE TABLE encuentros (
//  id BIGINT AUTO_INCREMENT PRIMARY KEY,
//  torneo_id BIGINT NULL,
//  equipo_local_id BIGINT NULL,
//  equipo_visitante_id BIGINT NULL,
//  juez_id BIGINT NULL,
//  sede_id BIGINT NULL,
//  fecha DATE NOT NULL,
//  hora TIME NOT NULL,
//  goles_local INT NULL,
//  goles_visitante INT NULL,
//  estado VARCHAR(50) NULL
//  );