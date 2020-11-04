package com.ac.ac.controller

import com.ac.ac.entity.Assassin
import com.ac.ac.service.AssassinService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors
import javax.validation.Valid

@RestController
@RequestMapping("/api/asesinos")
class AssassinController constructor(
        @Autowired
        private val assassinService: AssassinService){

    companion object {
        const val type = "application/json;charset=UTF-8"
    }

    @GetMapping(produces = [type])
    private fun findAll(): ResponseEntity<List<Assassin>>{
        val assassins: List<Assassin> = this.assassinService.findAll()

        if (assassins.isEmpty()){
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }

        return ResponseEntity(assassins, HttpStatus.OK)
    }

    @GetMapping(value = ["page/{page}"], produces = [type])
    private fun findAll(@PathVariable page: Int): ResponseEntity<Page<Assassin>>{
        val page1: Pageable = PageRequest.of(page, 4)
        val assassins: Page<Assassin> = this.assassinService.findAll(page1)

        return ResponseEntity(assassins, HttpStatus.OK)
    }

    @RequestMapping(method = [RequestMethod.POST, RequestMethod.PUT], consumes = [type], produces = [type])
    private fun addAssassin(@RequestBody @Valid assassin: Assassin, result: BindingResult): ResponseEntity<*>{
        val errors: List<String>
        val response: MutableMap<String, Any?> = HashMap()
        val assassin1: Assassin

        if (result.hasErrors()) {
            errors = result.fieldErrors.stream()
                    .map { err: FieldError -> "El campo: " + err.field + " " + err.defaultMessage }
                    .collect(Collectors.toList())
            response["Errores"] = errors
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }

        try {
            assassin1 = this.assassinService.addAssassin(assassin)
        } catch (e: DataAccessException) {
            response["Message"] = "Error al guardar/actualizar al asesino " + assassin.name + " en la base de datos"
            response["Error"] = e.mostSpecificCause.message
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }

        return ResponseEntity(assassin1, HttpStatus.CREATED)
    }

    @GetMapping("{idAssassin}", produces = [type])
    private fun findAssassinById(@PathVariable idAssassin: Int): ResponseEntity<Optional<Assassin>>{
        val assassin: Optional<Assassin> = this.assassinService.findById(idAssassin)

        return ResponseEntity(assassin, HttpStatus.OK)
    }

    @DeleteMapping("{idAssassin}")
    private fun deleteAssassin(@PathVariable idAssassin: Int): ResponseEntity<Unit>{
        val assassin: Unit = this.assassinService.deleteAssassin(idAssassin)

        return ResponseEntity(assassin, HttpStatus.NO_CONTENT)
    }

    @GetMapping("/pais/{name}", produces = [type])
    private fun findAssassinByCountry(@PathVariable name: String): ResponseEntity<List<Assassin>> {
        val assassin: List<Assassin> = this.assassinService.findAssassinByCountry(name)

        return ResponseEntity(assassin, HttpStatus.OK)
    }

}