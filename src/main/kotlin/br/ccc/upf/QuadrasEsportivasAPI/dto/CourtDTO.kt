package br.ccc.upf.QuadrasEsportivasAPI.dto

import br.ccc.upf.QuadrasEsportivasAPI.model.StatusCourt
import jakarta.validation.constraints.NotNull

data class CourtDTO(
    @field:NotNull(message = "Toda quadra deve ter uma descricao")
    val description : String,
    @field:NotNull(message = "Toda quadra deve ter um status")
    val status : StatusCourt
)