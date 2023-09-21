package br.ccc.upf.QuadrasEsportivasAPI.model

data class User(
    val id: Long? = null,
    val name: String,
    val city: String,
    val email: String,
    val phone: String
)
