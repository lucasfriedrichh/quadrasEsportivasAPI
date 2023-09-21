package br.ccc.upf.QuadrasEsportivasAPI.model

data class Court(
    val id: Long? = null,
    val description : String,
    val status : StatusCourt
)
