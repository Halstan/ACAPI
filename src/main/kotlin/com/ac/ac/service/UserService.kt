package com.ac.ac.service

import com.ac.ac.entity.User
import com.ac.ac.repository.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
/*import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException*/
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
@Transactional
class UserService constructor(
        @Autowired
        val userRepository: UserRepository
    ) /*: UserDetailsService*/{

        private val logger: Logger = LoggerFactory.getLogger(UserService::class.java)

    /*override fun loadUserByUsername(username: String?): UserDetails{
        val user: User? = this.userRepository.findUserByUsername(username)

        if (user == null){
            logger.error("Error el usuario ${user!!.username} no existe en el sistema")
            throw UsernameNotFoundException("Error el usuario ${user!!.username} no existe en el sistema")
        }

        val authorities: List<GrantedAuthority> = user.roles!!.stream().map{
                rol -> SimpleGrantedAuthority(rol.authority)}
                .peek{authority -> logger.info("Role: ${authority.authority}")}
                .collect(Collectors.toList())

        return org.springframework.security.core.userdetails.User(user.username, user.password, user.enabled!!, true, true, true, authorities)
    }*/

    fun findByUsername(username: String): User{
        return this.userRepository.findUserByUsername(username)!!
    }
}