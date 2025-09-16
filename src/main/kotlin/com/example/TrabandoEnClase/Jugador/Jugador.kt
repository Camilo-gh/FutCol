package com.example.TrabandoEnClase.Jugador

data class Jugador(
    val id: Int,
    val nombre: String,
    val n_documento: String,
    val fecha_nacimiento: String,
    val email: String,
    val password: String,
    val genero: String,
    val edad: Int,
    val user_id: Int,
    val equipo_id: Int
)

// SENTENCIA SQL:
// CREATE TABLE jugadores (
//    id INT AUTO_INCREMENT PRIMARY KEY,
//    nombre VARCHAR(100) NOT NULL,
//    n_documento VARCHAR(50) NOT NULL,
//    fecha_nacimiento DATE NOT NULL,
//    email VARCHAR(150) NOT NULL UNIQUE,
//    password VARCHAR(255) NOT NULL,
//    genero ENUM('M','F','Otro') NOT NULL,
//    edad INT NOT NULL,
//    user_id INT NOT NULL,
//    equipo_id INT NOT NULL,
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
//    );