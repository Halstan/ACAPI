package com.ac.ac.service

import com.ac.ac.entity.Assassin
import com.ac.ac.repository.AssassinRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class AssassinService constructor(
        @Autowired
        private val assassinRepository: AssassinRepository) {

    fun findAll(): List<Assassin> =
            this.assassinRepository.findAll()

    fun findAll(pageable: Pageable): Page<Assassin> =
            this.assassinRepository.findAll(pageable)

    fun addAssassin(assassin: Assassin): Assassin =
            this.assassinRepository.save(assassin)

    fun updateAssassin(assassin: Assassin): Assassin =
            this.assassinRepository.save(assassin)

    fun findById(idAssassin: Int): Optional<Assassin> =
            this.assassinRepository.findById(idAssassin)

    fun deleteAssassin(idAssassin: Int): Unit =
            this.assassinRepository.deleteById(idAssassin)

    fun findAssassinByCountry(name: String): List<Assassin> =
            this.assassinRepository.findAssassinByCountry(name)
}