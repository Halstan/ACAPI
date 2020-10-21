package com.ac.ac.controller

import com.ac.ac.entity.Weapon
import com.ac.ac.service.WeaponService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors
import javax.validation.Valid
import kotlin.collections.ArrayList

@RestController
@CrossOrigin(origins = ["*"], methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE])
@RequestMapping("api/armas")
class WeaponController constructor(
        @Autowired
        private val weaponService: WeaponService){

    companion object {
        const val type = "application/json;charset=UTF-8"
    }

    @GetMapping(produces = [type])
    private fun findAll(): ResponseEntity<List<Weapon>>{
        val weapon: List<Weapon> = this.weaponService.findAll()

        return ResponseEntity(weapon, HttpStatus.OK)
    }

    @PostMapping(produces = [type], consumes = [type])
    private fun addWeapon(@RequestBody @Valid weapon: Weapon, bindingResult: BindingResult): ResponseEntity<*>{
        val response: MutableMap<String, Any?> = HashMap()
        val weapon1: Weapon?
        val errors: MutableList<String>

        if (bindingResult.hasErrors()){
            errors = bindingResult.fieldErrors.stream()
                    .map { err -> "El campo: ${ err.defaultMessage!! } no puede estar vacío" }
                    .collect(Collectors.toList())
            response["Errors"] = errors
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }

        try {
            weapon1 = this.weaponService.addWeapon(weapon)
        }catch (e: DataAccessException){
            response["Message"] = "Error al guardar el arma ${weapon.nameWeapon} en la base de datos"
            response["Error"] = e.mostSpecificCause.message
            return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
        }

        return ResponseEntity(weapon1, HttpStatus.CREATED)
    }

    @GetMapping("{idWeapon}", produces = [type])
    private fun findWeapon(@PathVariable idWeapon: Int): ResponseEntity<*>{
        val response: MutableMap<String, Any?> = HashMap()
        val weapon: Optional<Weapon> = this.weaponService.findById(idWeapon)

        return if (weapon.isPresent){
            ResponseEntity(weapon, HttpStatus.OK)
        }else{
            response["Error"] = "El arma: $idWeapon no existe en la base de datos!"
            ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @PutMapping(produces = [type], consumes = [type])
    private fun updateWeapon(@RequestBody @Valid weapon: Weapon, bindingResult: BindingResult): ResponseEntity<*>{
        val weapon1: Weapon = this.weaponService.updateWeapon(weapon)
        val errors: MutableList<String>
        val response: MutableMap<String, Any?> = HashMap()

        if (bindingResult.hasErrors()){
            errors = bindingResult.fieldErrors.stream()
                    .map { err -> "El campo: ${ err.defaultMessage!! } no puede estar vacío" }
                    .collect(Collectors.toList())
            response["Message"] = "Error al actualizar"
            response["Errors"] = errors
            return ResponseEntity(response, HttpStatus.BAD_REQUEST)
        }

        return ResponseEntity(weapon1, HttpStatus.ACCEPTED)
    }

    @DeleteMapping("{idWeapon}", produces = [type])
    private fun deleteWeapon(@PathVariable idWeapon: Int): ResponseEntity<*> {
        val response: MutableMap<String, Any?> = HashMap()

        return try{
            this.weaponService.deleteWeapon(idWeapon)
            response["Message"] = "El arma ha sido eliminada con éxito"
            return ResponseEntity(response, HttpStatus.OK)
        }catch (e: DataAccessException){
            response["Message"] = "Error al eliminar el arma"
            response["Error"] = e.mostSpecificCause.message
            ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}