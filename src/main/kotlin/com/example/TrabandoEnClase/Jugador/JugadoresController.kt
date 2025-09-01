package com.example.TrabandoEnClase.Jugador

import com.example.TrabandoEnClase.Jugador.JugadoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
    fun agregarJugador(@RequestBody jugador: Jugador): String {
        jugadoresService.agregarJugador(
            jugador.nombre,
            jugador.n_documento,
            jugador.fecha_nacimiento,
            jugador.email,
            jugador.password,
            jugador.genero,
            jugador.edad,
            jugador.user_id,
            jugador.equipo_id
        )
        return "Jugador agregado correctamente"
    }

    @PutMapping("/{id}")
    fun actualizarJugador(@PathVariable id: Int, @RequestBody jugador: Jugador): String {
        jugadoresService.actualizarJugador(
            id,
            jugador.nombre,
            jugador.n_documento,
            jugador.fecha_nacimiento,
            jugador.email,
            jugador.password,
            jugador.genero,
            jugador.edad,
            jugador.user_id,
            jugador.equipo_id
        )
        return "Jugador actualizado correctamente"
    }

    @DeleteMapping("/{id}")
    fun eliminarJugador(@PathVariable id: Int): String {
        jugadoresService.eliminarJugador(id)
        return "Jugador eliminado correctamente"
    }
}