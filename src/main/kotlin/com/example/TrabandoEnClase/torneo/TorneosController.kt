package com.example.TrabandoEnClase

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.example.TrabandoEnClase.torneo.TorneosService
import com.example.TrabandoEnClase.torneo.Torneo

@RestController
@RequestMapping("/torneos")
class TorneosController {

    @Autowired
    lateinit var torneoService: TorneosService


    @GetMapping
    fun obtenerTorneos(): List<Torneo> {
        return torneoService.obtenerTorneos()
    }

    @GetMapping("/{id}")
    fun obtenerTorneoPorId(@PathVariable id: Int): Any {
        return try {
            torneoService.obtenerTorneoPorId(id) ?: "Torneo no encontrado"
        } catch (e: Exception) {
            "Error al obtener el torneo: ${e.message}"
        }
    }


    @PostMapping
    fun agregarTorneo(@RequestBody torneo: Torneo): String {
        return try {
            torneoService.agregarTorneo(torneo)
            "Torneo agregado correctamente"
        } catch (e: Exception) {
            "Error al agregar el torneo: ${e.message}"
        }
    }


    @PutMapping("/{id}")
    fun actualizarTorneo(@PathVariable id: Int, @RequestBody torneo: Torneo): String {
        return try {
            torneoService.actualizarTorneo(id, torneo)
            "Torneo actualizado correctamente"
        } catch (e: Exception) {
            "Error al actualizar el torneo: ${e.message}"
        }
    }

    @DeleteMapping("/{id}")
    fun eliminarTorneo(@PathVariable id: Int): String {
        return try {
            torneoService.eliminarTorneo(id)
            "Torneo eliminado correctamente"
        } catch (e: Exception) {
            "Error al eliminar el torneo: ${e.message}"
        }
    }
}