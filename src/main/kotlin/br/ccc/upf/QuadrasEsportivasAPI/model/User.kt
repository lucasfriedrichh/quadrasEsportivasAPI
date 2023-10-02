package br.ccc.upf.QuadrasEsportivasAPI.model

import jakarta.persistence.*

data class User(
    val id: Long? = null,
    val name: String,
    val city: String,
    val email: String,
    val phone: String,
    val password: String,
    @Enumerated(value = EnumType.STRING)
    val role: UserRole = UserRole.USER,
    @OneToMany(mappedBy = "user")
    val reservations: List<Reservation> = listOf()
)