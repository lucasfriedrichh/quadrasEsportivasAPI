package br.ccc.upf.QuadrasEsportivasAPI.dto

import jakarta.validation.constraints.NotEmpty

data class UserDTO (
    val name: String,
    val city: String,
    val phone: String,
    val password: String,
    val email: String
)