package com.example.TablaJugadores

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/jugadores")
class JugadoresController {

    @Autowired
    lateinit var jugadoresService: JugadoresService

    @GetMapping
    fun obtenerJugadores(): List<Jugador> {
        return jugadoresService.obtenerJugadores()
    }

    @PostMapping
    fun agregarJugador(@RequestBody body: Map<String, Any>): String {
        jugadoresService.agregarJugador(
            body["nombre"] as String,
            body["n_documento"] as String,
            body["fecha_nacimiento"] as String,
            body["email"] as String,
            body["password"] as String,
            body["genero"] as String,
            (body["edad"] as Number).toInt(),
            (body["user_id"] as Number).toInt(),
            (body["equipo_id"] as Number).toInt()
        )
        return "Jugador agregado correctamente"
    }

    @PutMapping("/{id}")
    fun actualizarJugador(@PathVariable id: Int, @RequestBody body: Map<String, Any>): String {
        jugadoresService.actualizarJugador(
            id,
            body["nombre"] as String,
            body["n_documento"] as String,
            body["fecha_nacimiento"] as String,
            body["email"] as String,
            body["password"] as String,
            body["genero"] as String,
            (body["edad"] as Number).toInt(),
            (body["user_id"] as Number).toInt(),
            (body["equipo_id"] as Number).toInt()
        )
        return "Jugador actualizado correctamente"
    }

    @DeleteMapping("/{id}")
    fun eliminarJugador(@PathVariable id: Int): String {
        jugadoresService.eliminarJugador(id)
        return "Jugador eliminado correctamente"
    }
}