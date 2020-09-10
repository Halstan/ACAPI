package com.ac.ac.controller

import com.ac.ac.entity.Assassin
import com.ac.ac.service.AssassinService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@CrossOrigin(origins = ["*"], methods = [RequestMethod.GET, RequestMethod.POST])
@RequestMapping("api/asesinos")
class AssassinController constructor(
        @Autowired
        private val assassinService: AssassinService){

    @GetMapping(produces = ["application/json"])
    fun findAll(): ResponseEntity<List<Assassin>>{
        val assassins: List<Assassin> = this.assassinService.findAll()

        return ResponseEntity(assassins, HttpStatus.OK)
    }

    @PostMapping(consumes = ["application/json"], produces = ["application/json"])
    fun addAssassin(@RequestBody @Valid assassin: Assassin): ResponseEntity<Assassin>{
        val assassin1: Assassin = this.assassinService.addAssassin(assassin)

        return ResponseEntity(assassin1, HttpStatus.CREATED)
    }

    @GetMapping("{idAssassin}", produces = ["application/json"])
    fun findAssassinById(@PathVariable idAssassin: Int): ResponseEntity<Optional<Assassin>>{
        val assassin: Optional<Assassin> = this.assassinService.findById(idAssassin)

        return ResponseEntity(assassin, HttpStatus.OK)
    }

    @PutMapping
    fun updateAssassin(@RequestBody @Valid assassin: Assassin): ResponseEntity<Assassin>{
        val assassin1: Assassin = this.assassinService.updateAssassin(assassin)

        return ResponseEntity(assassin1, HttpStatus.ACCEPTED)
    }

    @DeleteMapping("{idAssassin}")
    fun deleteAssassin(@PathVariable idAssassin: Int): ResponseEntity<Unit>{
        val assassin: Unit = this.assassinService.deleteAssassin(idAssassin)

        return ResponseEntity(assassin, HttpStatus.OK)
    }

}