package com.ac.ac.controller

import com.ac.ac.entity.Country
import com.ac.ac.service.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/paises")
class CountryController(
        @Autowired
        private val countryService: CountryService) {

    @GetMapping(produces = ["application/json"])
    fun findAll(): ResponseEntity<List<Country>>? {
        val countries: List<Country> = this.countryService.findAll()

        return ResponseEntity(countries, HttpStatus.OK)
    }

    @PostMapping(consumes = ["application/json"], produces = ["application/json"])
    fun addCountry(@RequestBody country: @Valid Country): ResponseEntity<Country> {
        val country1: Country = this.countryService.addCountry(country)

        return ResponseEntity(country1, HttpStatus.CREATED)
    }




}