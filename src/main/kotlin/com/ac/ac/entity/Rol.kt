package com.ac.ac.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "roles")
class Rol constructor(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idRol: Int,

        @Column(length = 40)
        val authority: String

    ) : Serializable{

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Rol) return false

        if (authority != other.authority) return false

        return true
    }

    override fun hashCode(): Int {
        return authority.hashCode()
    }

    override fun toString(): String {
        return "Rol(idRol=$idRol, authority='$authority')"
    }

}