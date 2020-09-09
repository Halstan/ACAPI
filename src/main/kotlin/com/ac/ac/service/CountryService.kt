package com.ac.ac.service

import com.ac.ac.entity.Country
import com.ac.ac.repository.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class CountryService{

    @Autowired
    lateinit var countryRepository: CountryRepository

    fun findAll(): List<Country> {
        return this.countryRepository.findAll()
    }

    fun addCountry(country: Country): Country =
            this.countryRepository.save(country)

    fun findById(idCountry: Int): Optional<Country> =
            this.countryRepository.findById(idCountry)

    fun updateCountry(country: Country): Country =
            this.countryRepository.save(country)

    fun deleteCountry(idCountry: Int) =
            this.countryRepository.deleteById(idCountry)

}