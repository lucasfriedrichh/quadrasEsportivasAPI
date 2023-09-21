package br.ccc.upf.QuadrasEsportivasAPI.model

import java.time.LocalDateTime

data class Reservation(
    val id:Long ? = null,
    val time: LocalDateTime,

)
