package com.ac.ac.entity

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
@Table(name = "Weapons")
data class Weapon constructor(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idWeapon: Int?,

        @Size(min = 5, max = 30)
        @NotEmpty
        @Column(length = 30, unique = true, nullable = false)
        val nameWeapon: String?

        ) {

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is Weapon) return false

                if (idWeapon != other.idWeapon) return false
                if (nameWeapon != other.nameWeapon) return false

                return true
        }

        override fun hashCode(): Int {
                var result = idWeapon ?: 0
                result = 31 * result + (nameWeapon?.hashCode() ?: 0)
                return result
        }

        override fun toString(): String {
                return "Weapon(idWeapon=$idWeapon, nameWeapon=$nameWeapon)"
        }

}