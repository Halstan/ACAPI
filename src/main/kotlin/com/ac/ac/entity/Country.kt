package com.ac.ac.entity

import lombok.Data
import org.hibernate.annotations.Type
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Data
@Table(name = "Countries")
data class Country(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private val idCountry: Int,

        @Size(min = 5, max = 25)
        @NotBlank
        private val nameCountry: String,

        @OneToMany(mappedBy = "country")
        private val assassin: List<Assassin>

)