package br.ccc.upf.QuadrasEsportivasAPI.dto

import br.ccc.upf.QuadrasEsportivasAPI.model.User
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

data class ReservationDTO(
    @field:NotNull(message = "Toda reserva deve ter uma data")
    val time: LocalDateTime,
    @field:NotNull(message = "Toda reserva deve ter um usuario")
    val user: User,
    @field:NotNull(message = "Toda reserva deve ter uma descricao")
    val description: String


)
