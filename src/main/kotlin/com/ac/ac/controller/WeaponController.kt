package com.ac.ac.controller

import com.ac.ac.entity.Weapon
import com.ac.ac.service.WeaponService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@CrossOrigin(origins = ["*"], methods = [RequestMethod.GET, RequestMethod.POST])
@RequestMapping("api/armas")
class WeaponController constructor(
        @Autowired
        private val weaponService: WeaponService){

    @GetMapping(produces = ["application/json"])
    private fun findAll(): ResponseEntity<List<Weapon>>{
        val weapon: List<Weapon> = this.weaponService.findAll()

        return ResponseEntity(weapon, HttpStatus.OK)
    }

    @PostMapping(produces = ["application/json"], consumes = ["application/json"])
    private fun addWeapon(@RequestBody @Valid weapon: Weapon): ResponseEntity<Weapon>{
        val weapon1: Weapon = this.weaponService.addWeapon(weapon)

        return ResponseEntity(weapon1, HttpStatus.CREATED)
    }

    @GetMapping("{idWeapon}", produces = ["application/json"])
    private fun findWeapon(@PathVariable idWeapon: Int): ResponseEntity<Optional<Weapon>>{
        val weapon: Optional<Weapon> = this.weaponService.findById(idWeapon)

        return ResponseEntity(weapon, HttpStatus.OK)
    }

    @PutMapping(produces = ["application/json"], consumes = ["application/json"])
    private fun updateWeapon(@RequestBody @Valid weapon: Weapon): ResponseEntity<Weapon>{
        val weapon1: Weapon = this.weaponService.updateWeapon(weapon)

        return ResponseEntity(weapon1, HttpStatus.ACCEPTED)
    }

    @DeleteMapping("{idWeapon}", produces = ["application/json"])
    private fun deleteWeapon(@PathVariable idWeapon: Int) {

        this.weaponService.deleteWeapon(idWeapon)
    }

}