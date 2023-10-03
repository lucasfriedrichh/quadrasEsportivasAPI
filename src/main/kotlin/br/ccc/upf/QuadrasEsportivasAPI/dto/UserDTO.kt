package br.ccc.upf.QuadrasEsportivasAPI.dto

import jakarta.validation.constraints.NotEmpty

data class UserDTO (
    @field:NotEmpty(message = "Todo usuario deve ter um nome")
    val name: String,
    val city: String,
    @field:NotEmpty(message = "Todo usuario deve ter um email")
    val email: String,
    val phone: String
)