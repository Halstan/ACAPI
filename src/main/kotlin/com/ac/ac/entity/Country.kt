package com.ac.ac.entity

import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "Countries")
data class Country constructor(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idCountry: Int? = null,

        @Size(min = 5, max = 25)
        @NotBlank
        @Column(length = 40, unique = true)
        val nameCountry: String? = "",

        @OneToMany(mappedBy = "country")
        @Column(nullable = false)
        @JsonIgnore
        val assassins: List<Assassin>? = null

){
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is Country) return false

                if (idCountry != other.idCountry) return false
                if (nameCountry != other.nameCountry) return false
                if (assassins != other.assassins) return false

                return true
        }

        override fun hashCode(): Int {
                var result = idCountry
                result = 31 * result!! + nameCountry.hashCode()
                result = 31 * result + (assassins?.hashCode() ?: 0)
                return result
        }

        override fun toString(): String {
                return "Country(idCountry=$idCountry, nameCountry='$nameCountry')"
        }
}