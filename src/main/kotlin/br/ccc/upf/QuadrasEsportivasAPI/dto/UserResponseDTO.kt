package br.ccc.upf.QuadrasEsportivasAPI.dto

data class UserResponseDTO(
    val id: Long? = null,
    val nome: String,
    val city: String,
    val phone: String)
