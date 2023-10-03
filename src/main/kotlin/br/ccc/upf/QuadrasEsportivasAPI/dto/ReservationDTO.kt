package br.ccc.upf.QuadrasEsportivasAPI.dto

import br.ccc.upf.QuadrasEsportivasAPI.model.User
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotEmpty
import java.time.LocalDateTime

data class ReservationDTO (
    @field:NotEmpty(message = "Toda reserva deve ter um horario")
    val time: LocalDateTime,
    @field:NotEmpty(message = "Toda reseva deve ser feita por um Usuario")
    val user: User
)