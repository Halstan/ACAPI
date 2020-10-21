package com.ac.ac.controller

import com.ac.ac.entity.Country
import com.ac.ac.service.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import kotlin.collections.HashMap

@RestController
@CrossOrigin(origins = ["*"], methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE])
@RequestMapping("api/paises")
class CountryController constructor(
        @Autowired
        private val countryService: CountryService){

    companion object {
        const val type = "application/json;charset=UTF-8"
    }

    @GetMapping(produces = [type])
    private fun findAll(): ResponseEntity<List<Country>> {
        val countries: List<Country> = this.countryService.findAll()

        return ResponseEntity(countries, HttpStatus.OK)
    }

    @PostMapping(consumes = [type], produces = [type])
    private fun addCountry(@RequestBody country: @Valid Country): ResponseEntity<*> {
        val response: MutableMap<String, Any?> = HashMap()
        val country1: Country?

        try {
            country1 = this.countryService.addCountry(country)
        }catch (e: DataAccessException){
            response["Message"] = "Error al guardar al pais ${country.nameCountry} en la base de datos"
            response["Error"] = e.mostSpecificCause.message
            return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
        }

        return ResponseEntity(country1, HttpStatus.CREATED)
    }

    @GetMapping("{idCountry}", produces = [type])
    private fun findCountry(@PathVariable idCountry: Int): ResponseEntity<*>{
        val response: MutableMap<String, Any> = HashMap()
        val country: Optional<Country> = this.countryService.findById(idCountry)

        return if (country.isPresent){
            ResponseEntity(country, HttpStatus.OK)
        }else{
            response["Error"] = "El pais: $idCountry no existe en la base de datos!"
            ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping(produces = [type], consumes = [type])
    private fun updateCountry(@RequestBody country: @Valid Country): ResponseEntity<Country> {
        val country1: Country = this.countryService.updateCountry(country)

        return ResponseEntity(country1, HttpStatus.ACCEPTED)
    }

    @DeleteMapping("{idCountry}")
    private fun deleteCountry(@PathVariable idCountry: Int): ResponseEntity<*>{
        val response: MutableMap<String, Any?> = HashMap()

        return try {
            this.countryService.deleteCountry(idCountry)
            response["Message"] = "Pais eliminado con éxito"
            ResponseEntity(response, HttpStatus.OK)
        }catch (e: DataAccessException){
            response["Message"] = "Error al eliminar al país"
            response["Error"] = e.mostSpecificCause.message
            ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

}