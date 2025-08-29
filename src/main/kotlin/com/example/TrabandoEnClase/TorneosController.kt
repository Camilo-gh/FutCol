package com.example.TrabandoEnClase

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
        torneoService.agregarTorneo(torneo)
        return "Torneo agregado"
    }

    @PutMapping
    fun actualizarTorneo(@RequestBody torneo: Torneo): String {
        torneoService.actualizarTorneo(torneo)
        return "Torneo actualizado"
    }

    @DeleteMapping("/{id}")
    fun eliminarTorneo(@PathVariable id: Int): String {
        torneoService.eliminarTorneo(id)
        return "Torneo eliminado"
    }
}