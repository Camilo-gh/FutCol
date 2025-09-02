package com.example.TrabandoEnClase.torneo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/torneos")
class TorneosController {

    @Autowired
    lateinit var torneoService: TorneosService


    @GetMapping
    fun obtenerTorneos(): List<Torneo> {
        return torneoService.obtenerTorneos()
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
            torneoService.actualizarTorneo(torneo)
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