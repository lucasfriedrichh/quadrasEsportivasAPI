package br.ccc.upf.QuadrasEsportivasAPI.converter

import br.ccc.upf.QuadrasEsportivasAPI.dto.CourtDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.ReservationDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.ReservationResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.model.Court
import br.ccc.upf.QuadrasEsportivasAPI.model.Reservation
import org.springframework.stereotype.Component
import java.time.LocalDateTime
@Component
class ReservationConverter{

    fun toReservation(dto : ReservationDTO) : Reservation {
        return Reservation(
            time = dto.time,
            user = dto.user
        )
    }

    fun toReservationDTO(reservation: Reservation):ReservationDTO{
        return ReservationDTO(
            time = reservation.time,
            user = reservation.user
        )
    }

    fun toReservationResponseDTO(reservation: Reservation): ReservationResponseDTO{
        return ReservationResponseDTO(
            id = reservation.id,
            time = reservation.time,
            user = reservation.user
        )
    }
}