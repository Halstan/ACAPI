package com.ac.ac.entity

import org.hibernate.annotations.CreationTimestamp
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "Assassins")
data class Assassin constructor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idAssassin: Int,

    @ManyToMany
    @JoinTable(
            name = "AssassinWeapon",
            joinColumns = [JoinColumn(name = "idAssassin")],
            inverseJoinColumns = [JoinColumn(name = "idWeapon")])
    val weapons: Set<Weapon>?,

    @ManyToOne
    @JoinColumn(name = "idCountry")
    val country: Country?,

    @NotBlank
    @Size(min = 3, max = 25)
    @Column(length = 40)
    val name: String?,

    @NotBlank
    @Size(min = 5, max = 30)
    @Column(length = 25)
    val lastName: String?,

    val height: Float?,

    @CreationTimestamp
    val createdAt: LocalDateTime?
    ): Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Assassin) return false

        if (idAssassin != other.idAssassin) return false
        if (name != other.name) return false
        if (lastName != other.lastName) return false
        if (height != other.height) return false
        if (createdAt != other.createdAt) return false
        if (country != other.country) return false
        if (weapons != other.weapons) return false

        return true
    }

    override fun hashCode(): Int {
        var result = idAssassin
        result = 31 * result + name.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + height.hashCode()
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + country.hashCode()
        result = 31 * result + weapons.hashCode()
        return result
    }
}