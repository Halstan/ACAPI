package com.ac.ac.repository

import com.ac.ac.entity.Weapon
import org.springframework.data.jpa.repository.JpaRepository

interface WeaponRepository : JpaRepository<Weapon, Int>{
}