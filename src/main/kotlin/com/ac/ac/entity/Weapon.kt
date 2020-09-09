package com.ac.ac.entity

import lombok.Data
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Size

@Data
@Entity
@Table(name = "Weapons")
data class Weapon(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idWeapon: Int,

        @Size(min = 4, max = 30)
        @Column(length = 30)
        val nameWeapon: String

) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is Weapon) return false

                if (idWeapon != other.idWeapon) return false
                if (nameWeapon != other.nameWeapon) return false

                return true
        }

        override fun hashCode(): Int {
                var result = idWeapon
                result = 31 * result + nameWeapon.hashCode()
                return result
        }

        override fun toString(): String {
                return "Weapon(idWeapon=$idWeapon, nameWeapon='$nameWeapon')"
        }


}