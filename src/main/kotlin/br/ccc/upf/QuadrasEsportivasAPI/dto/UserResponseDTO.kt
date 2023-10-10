package br.ccc.upf.QuadrasEsportivasAPI.dto

import br.ccc.upf.QuadrasEsportivasAPI.model.StatusCourt
import jakarta.validation.constraints.NotEmpty

data class UserResponseDTO(
    val id:Long?,
    val name: String,
    val city: String,
    val phone: String,
    val email: String

)
