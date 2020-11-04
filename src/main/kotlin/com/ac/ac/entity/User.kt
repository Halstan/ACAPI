package com.ac.ac.entity

import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
@Table(name = "users")
data class User constructor(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idUser: Long?,

        @Column(length = 50)
        val name: String?,

        @NotEmpty
        @Size(min = 4, max = 50)
        @Column(length = 50)
        val lastName: String?,

        @Column(length = 30, unique = true)
        val username: String?,

        @Email
        @NotEmpty
        @Column(length = 50, unique = true, nullable = false)
        val email: String? = null,

        @Column(length = 90)
        val password: String?,

        val enabled: Boolean? = true,

        @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
        @JoinTable(name="user_rol", joinColumns = [JoinColumn(name="idUser")], inverseJoinColumns = [JoinColumn(name="idRol")],
                uniqueConstraints = [UniqueConstraint(columnNames = ["idUser", "idRol"])])
        val roles: List<Rol>? = null

        ) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (name != other.name) return false
        if (lastName != other.lastName) return false
        if (username != other.username) return false
        if (password != other.password) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (lastName?.hashCode() ?: 0)
        result = 31 * result + (email?.hashCode() ?: 0)
        result = 31 * result + (username?.hashCode() ?: 0)
        result = 31 * result + (password?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "User(idUser=$idUser, name=$name, lastName=$lastName, username=$username, password=$password, email=$email)"
    }


}