package com.ac.ac.controller

import com.ac.ac.entity.Assassin
import com.ac.ac.service.AssassinService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@CrossOrigin(origins = ["*"], methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE])
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

        return ResponseEntity(assassins, HttpStatus.OK)
    }

    @GetMapping(value = ["page/{page}"], produces = [type])
    private fun findAll(@PathVariable page: Int): ResponseEntity<Page<Assassin>>{
        val page1: Pageable = PageRequest.of(page, 4)
        val assassins: Page<Assassin> = this.assassinService.findAll(page1)

        return ResponseEntity(assassins, HttpStatus.OK)
    }

    @PostMapping(consumes = [type], produces = [type])
    private fun addAssassin(@RequestBody @Valid assassin: Assassin): ResponseEntity<Assassin>{
        val assassin1: Assassin = this.assassinService.addAssassin(assassin)

        return ResponseEntity(assassin1, HttpStatus.CREATED)
    }

    @GetMapping("{idAssassin}", produces = [type])
    private fun findAssassinById(@PathVariable idAssassin: Int): ResponseEntity<Optional<Assassin>>{
        val assassin: Optional<Assassin> = this.assassinService.findById(idAssassin)

        return ResponseEntity(assassin, HttpStatus.OK)
    }

    @PutMapping(produces = [type], consumes = [type])
    private fun updateAssassin(@RequestBody @Valid assassin: Assassin): ResponseEntity<Assassin>{
        val assassin1: Assassin = this.assassinService.updateAssassin(assassin)

        return ResponseEntity(assassin1, HttpStatus.ACCEPTED)
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