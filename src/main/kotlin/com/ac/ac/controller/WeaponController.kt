package com.ac.ac.controller

import com.ac.ac.entity.Weapon
import com.ac.ac.service.WeaponService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/armas")
class WeaponController{

    @Autowired
    lateinit var weaponService: WeaponService

    @GetMapping(produces = ["application/json"])
    fun findAll(): List<Weapon>{
        return this.weaponService.findAll()
    }

}