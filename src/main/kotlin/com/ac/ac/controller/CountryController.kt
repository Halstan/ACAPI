package com.ac.ac.controller

import com.ac.ac.entity.Country
import com.ac.ac.service.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@CrossOrigin(origins = ["*"], methods = [RequestMethod.GET, RequestMethod.POST])
@RequestMapping("api/paises")
class CountryController(
        @Autowired
        private val countryService: CountryService){

    @GetMapping
    fun findAll(): ResponseEntity<List<Country>> {
        val countries: List<Country> = this.countryService.findAll()

        return ResponseEntity(countries, HttpStatus.OK)
    }

    @PostMapping(consumes = ["application/json"], produces = ["application/json"])
    fun addCountry(@RequestBody country: @Valid Country): ResponseEntity<Country> {
        val country1: Country = this.countryService.addCountry(country)

        return ResponseEntity(country1, HttpStatus.CREATED)
    }

    @GetMapping("{idCountry}", produces = ["application/json"])
    fun findCountry(@PathVariable idCountry: Int): ResponseEntity<Optional<Country>>{
        val country: Optional<Country> = this.countryService.findById(idCountry)

        return ResponseEntity(country, HttpStatus.OK)
    }

    @PutMapping(produces = ["application/json"], consumes = ["application/json"])
    fun updateCountry(@RequestBody country: @Valid Country): ResponseEntity<Country> {
        val country1: Country = this.countryService.updateCountry(country)

        return ResponseEntity(country1, HttpStatus.ACCEPTED)
    }

    @DeleteMapping("{idCountry}")
    fun deleteCountry(@PathVariable idCountry: Int): ResponseEntity<Unit>{
        val country: Unit = this.countryService.deleteCountry(idCountry)

        return ResponseEntity(country, HttpStatus.OK)
    }

}