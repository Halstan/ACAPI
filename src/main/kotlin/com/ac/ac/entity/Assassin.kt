package com.ac.ac.entity

import lombok.Data
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Data
@Table(name = "Assasins")
data class Assassin (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val idAssassin: Int,

    @NotBlank
    @Size(min = 3, max = 25)
    private val name: String,

    @NotBlank
    @Size(min = 5, max = 30)
    private val lastName: String,

    private val height: Float,

    @CreationTimestamp
    private val createdAt: Date,

    @ManyToOne
    @JoinColumn(name = "idCountry")
    private val country: Country,

    @ManyToMany
    @JoinTable(name = "AssassinWeapon", joinColumns = [JoinColumn(name = "idAssassin")], inverseJoinColumns = [JoinColumn(name = "idWeapon")],
            uniqueConstraints = [UniqueConstraint(columnNames = ["idAssassin", "idWeapon"])])
    private val weapons: List<Weapon>
)
{

}