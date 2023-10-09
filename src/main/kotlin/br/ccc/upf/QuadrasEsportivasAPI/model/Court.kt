package br.ccc.upf.QuadrasEsportivasAPI.model

import jakarta.persistence.*

@Entity
data class Court(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val description: String,
    @Enumerated(value = EnumType.STRING)
    val status: StatusCourt
){
    constructor() : this(null, "", StatusCourt.AVAILABLE)
}
