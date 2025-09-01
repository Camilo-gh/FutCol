package com.example.TrabandoEnClase.Encuentros

import com.example.TrabandoEnClase.Encuentros.EncuentrosService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/encuentros")
class EncuentrosController(
    private val service: EncuentrosService
) {


    @GetMapping
    fun all(): List<Encuentro> = service.findAll()


    @GetMapping("/{id}")
    fun byId(@PathVariable id: Long): ResponseEntity<Encuentro> {
        val encuentro = service.findById(id)
        return if (encuentro != null) {
            ResponseEntity.ok(encuentro)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
        }
    }


    @PostMapping
    fun create(@RequestBody e: Encuentro): ResponseEntity<Encuentro> {
        val id = service.create(e)
        val created = service.findById(id) ?: throw ResponseStatusException(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "Error al crear el encuentro"
        )
        return ResponseEntity.status(HttpStatus.CREATED).body(created)
    }


    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody e: Encuentro): ResponseEntity<Encuentro> {
        val updated = service.update(id, e)
        return if (updated) {
            val updatedEncuentro = service.findById(id)!!
            ResponseEntity.ok(updatedEncuentro)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
        }
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (service.delete(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }
}