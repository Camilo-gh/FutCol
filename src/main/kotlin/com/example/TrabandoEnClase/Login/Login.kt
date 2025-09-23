package com.example.TrabandoEnClase.Login

data class Login(
    val id: Int,
    val email: String,
    val password: String
)

// CREATE TABLE IF NOT EXISTS `login` (
//  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
//  `email` VARCHAR(255) NOT NULL,
//  `password` VARCHAR(255) NOT NULL,
//  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
//  `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
//  PRIMARY KEY (`id`),
//  UNIQUE KEY `uniq_login_email` (`email`)
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;