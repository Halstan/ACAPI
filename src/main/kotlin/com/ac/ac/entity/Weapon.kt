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
        private val idWeapon: Int,

        @Size(min = 4, max = 30)
        private val nameWeapon: String

) {
}