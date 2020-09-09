package com.ac.ac.service

import com.ac.ac.entity.Assassin
import com.ac.ac.repository.AssassinRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class AssassinService(
        @Autowired
        private val assassinRepository: AssassinRepository) {

    fun findAll(): List<Assassin> =
            this.assassinRepository.findAll()

    fun addAssassin(assassin: Assassin): Assassin =
            this.assassinRepository.save(assassin)

    fun updateAssassin(assassin: Assassin): Assassin =
            this.assassinRepository.save(assassin)

    fun findById(idAssassin: Int): Optional<Assassin> =
            this.assassinRepository.findById(idAssassin)

    fun deleteAssassin(idAssassin: Int) =
            this.assassinRepository.deleteById(idAssassin)
}