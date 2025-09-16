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

// SENTENCIA SQL:
// CREATE TABLE torneos (
//  id INT AUTO_INCREMENT PRIMARY KEY,
//  nombre VARCHAR(150) NOT NULL,
//  fecha_inicio DATE NOT NULL,
//  fecha_fin DATE NOT NULL,
//  categoria VARCHAR(100) NOT NULL,
//  modalidad VARCHAR(100) NOT NULL,
//  organizador VARCHAR(150) NOT NULL,
//  precio DECIMAL(10,2) NOT NULL,
//  sedes VARCHAR(255) NOT NULL,
//  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
//  );