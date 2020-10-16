package com.ac.ac.repository

import com.ac.ac.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>{

    fun findUserByUsername(username: String?): User?

}