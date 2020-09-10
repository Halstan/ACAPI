package com.ac.ac.repository

import com.ac.ac.entity.Assassin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface AssassinRepository : JpaRepository<Assassin, Int> {

    @Query("select * from assassins inner join countries on assassins.id_country = countries.id_country where name_country = :name" ,nativeQuery = true)
    fun findAssassinByCountry(@Param ("name") name: String): List<Assassin>

}