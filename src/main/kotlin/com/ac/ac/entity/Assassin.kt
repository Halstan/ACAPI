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
@Table(name = "Assasins")
data class Assassin (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idAssassin: Int,

    @NotBlank
    @Size(min = 3, max = 25)
    @Column(length = 40)
    val name: String,

    @NotBlank
    @Size(min = 5, max = 30)
    val lastName: String,

    val height: Float,

    @CreationTimestamp
    val createdAt: Date,

    @ManyToOne
    @JoinColumn(name = "idCountry")
    val country: Country,

    @ManyToMany
    @JoinTable(name = "AssassinWeapon", joinColumns = [JoinColumn(name = "idAssassin")], inverseJoinColumns = [JoinColumn(name = "idWeapon")],
            uniqueConstraints = [UniqueConstraint(columnNames = ["idAssassin", "idWeapon"])])
    private val weapons: List<Weapon>
)
{

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