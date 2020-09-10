package com.ac.ac.service

import com.ac.ac.entity.Weapon
import com.ac.ac.repository.WeaponRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class WeaponService constructor(
        @Autowired
        private val weaponRepository: WeaponRepository) {

    fun findAll(): List<Weapon> =
            this.weaponRepository.findAll()

    fun addWeapon(weapon: Weapon): Weapon =
            this.weaponRepository.save(weapon)

    fun updateWeapon(weapon: Weapon): Weapon =
            this.weaponRepository.save(weapon)

    fun deleteWeapon(idWeapon: Int) =
            this.weaponRepository.deleteById(idWeapon)

    fun findById(idWeapon: Int): Optional<Weapon> =
            this.weaponRepository.findById(idWeapon)

}