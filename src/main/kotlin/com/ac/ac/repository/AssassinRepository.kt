package com.ac.ac.repository

import com.ac.ac.entity.Assassin
import org.springframework.data.jpa.repository.JpaRepository

interface AssassinRepository : JpaRepository<Assassin, Int> {
}