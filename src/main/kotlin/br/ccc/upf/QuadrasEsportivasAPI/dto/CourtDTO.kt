package br.ccc.upf.QuadrasEsportivasAPI.dto

import br.ccc.upf.QuadrasEsportivasAPI.model.StatusCourt
import jakarta.validation.constraints.NotEmpty

data class CourtDTO(
    @field:NotEmpty(message = "Toda quadra deve ter uma descricao")
    val description : String,
    @field:NotEmpty(message = "Toda quadra deve ter um status")
    val status : StatusCourt

)
