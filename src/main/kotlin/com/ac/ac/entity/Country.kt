package com.ac.ac.entity

import lombok.Data
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Data
@Table(name = "Countries")
data class Country(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idCountry: Int,

        @Size(min = 5, max = 25)
        @NotBlank
        @Column(length = 40)
        val nameCountry: String,

        @OneToMany(mappedBy = "country")
        @Column(nullable = false)
        val assassin: List<Assassin>? = null

){
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is Country) return false

                if (idCountry != other.idCountry) return false
                if (nameCountry != other.nameCountry) return false
                if (assassin != other.assassin) return false

                return true
        }

        override fun hashCode(): Int {
                var result = idCountry
                result = 31 * result + nameCountry.hashCode()
                result = 31 * result + (assassin?.hashCode() ?: 0)
                return result
        }

        override fun toString(): String {
                return "Country(idCountry=$idCountry, nameCountry='$nameCountry', assassin=$assassin)"
        }
}