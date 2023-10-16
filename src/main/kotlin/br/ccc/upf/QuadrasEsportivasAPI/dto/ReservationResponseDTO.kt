package br.ccc.upf.QuadrasEsportivasAPI.dto

import br.ccc.upf.QuadrasEsportivasAPI.model.User
import java.time.LocalDateTime

data class ReservationResponseDTO(
    val id: Long?,
    val time: LocalDateTime,
    val user: User,
    val description: String

)
