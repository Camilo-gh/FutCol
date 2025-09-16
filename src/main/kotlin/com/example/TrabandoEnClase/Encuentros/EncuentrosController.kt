package com.example.TrabandoEnClase.Encuentros

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/encuentros")
class EncuentrosControllerRef {

    @Autowired
    lateinit var service: EncuentrosService

    @GetMapping
    fun obtenerEncuentros(): List<Encuentro> {
        return service.findAll()
    }

    @GetMapping("/{id}")
    fun obtenerEncuentroPorId(@PathVariable id: Long): Any {
        return service.findById(id) ?: "Encuentro no encontrado"
    }

    @PostMapping
    fun agregarEncuentro(@RequestBody e: Encuentro): String {
        val id = service.create(e)
        return if (service.findById(id) != null)
            "Encuentro creado correctamente"
        else
            "Error al crear el encuentro"
    }

    @PutMapping("/{id}")
    fun actualizarEncuentro(@PathVariable id: Long, @RequestBody e: Encuentro): String {
        val ok = service.update(id, e)
        return if (ok) "Encuentro actualizado correctamente"
        else "No se pudo actualizar: encuentro id=$id no existe"
    }

    @DeleteMapping("/{id}")
    fun eliminarEncuentro(@PathVariable id: Long): String {
        val ok = service.delete(id)
        return if (ok) "Encuentro eliminado correctamente"
        else "No se pudo eliminar: encuentro id=$id no existe"
    }
}