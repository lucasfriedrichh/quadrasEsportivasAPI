package br.ccc.upf.QuadrasEsportivasAPI.dto

import br.ccc.upf.QuadrasEsportivasAPI.model.StatusCourt

data class CourtResponseDTO (
    val id : Long?,
    val description : String,
    val status : StatusCourt
)