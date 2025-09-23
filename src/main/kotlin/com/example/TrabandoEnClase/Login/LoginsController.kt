package com.example.TrabandoEnClase.Login

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/logins")
class LoginsController {

    @Autowired
    lateinit var loginsService: LoginsService

    @GetMapping
    fun obtenerLogins(): List<Login> {
        return loginsService.obtenerLogins()
    }

    @PostMapping
    fun agregarLogin(@RequestBody login: Login): String {
        loginsService.agregarLogin(
            email = login.email,
            password = login.password
        )
        return "Login agregado correctamente"
    }

    @PutMapping("/{id}")
    fun actualizarLogin(@PathVariable id: Int, @RequestBody login: Login): String {
        loginsService.actualizarLogin(
            id = id,
            email = login.email,
            password = login.password
        )
        return "Login actualizado correctamente"
    }

    @DeleteMapping("/{id}")
    fun eliminarLogin(@PathVariable id: Int): String {
        loginsService.eliminarLogin(id)
        return "Login eliminado correctamente"
    }
}