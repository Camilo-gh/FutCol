package com.example.TrabandoEnClase.Login

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class LoginsController {

    @Autowired
    lateinit var loginsService: LoginsService

    data class LoginResponse(
        val message: String,
        val userId: Int? = null,
        val role: String
    )

    @PostMapping("/login")
    fun login(@RequestBody credenciales: Login): ResponseEntity<LoginResponse> {
        val user = loginsService.autenticar(credenciales.email, credenciales.password)
        return if (user != null) {
            val role = if (user.email == "admin@torneo.com") "ADMIN" else "CAPITAN"
            ResponseEntity.ok(LoginResponse(message = "Login correcto", userId = user.id, role = role))
        } else {
            ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(LoginResponse(message = "Credenciales incorrectas", userId = null, role = "NONE"))
        }
    }
}