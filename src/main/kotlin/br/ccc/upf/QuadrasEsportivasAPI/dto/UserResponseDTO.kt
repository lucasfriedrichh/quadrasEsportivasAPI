package br.ccc.upf.QuadrasEsportivasAPI.dto

import br.ccc.upf.QuadrasEsportivasAPI.model.StatusCourt
import jakarta.validation.constraints.NotEmpty

data class UserResponseDTO(
    val id:Long?,
    @field:NotEmpty(message = "Todo usuario deve ter um nome")
    val name: String,
    val city: String,
    @field:NotEmpty(message = "Todo usuario deve ter um email")
    val email: String,
    val phone: String,
    val password: String
)
