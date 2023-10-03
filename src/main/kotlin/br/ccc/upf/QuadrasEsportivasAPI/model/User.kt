package br.ccc.upf.QuadrasEsportivasAPI.model

import jakarta.persistence.*

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val city: String,
    val phone: String,
    val email: String,
    @Enumerated(value = EnumType.STRING)
    val role: UserRole = UserRole.USER,
    @OneToMany(mappedBy = "user")
    val reservations: List<Reservation> = listOf()
){
    constructor() : this(null, "", "", "", "")

}
