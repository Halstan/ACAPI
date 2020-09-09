package com.ac.ac.repository

import com.ac.ac.entity.Assassin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AssassinRepository : JpaRepository<Assassin, Int> {
}