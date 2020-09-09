package com.ac.ac.repository

import com.ac.ac.entity.Country
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRepository : JpaRepository<Country, Int>{
}