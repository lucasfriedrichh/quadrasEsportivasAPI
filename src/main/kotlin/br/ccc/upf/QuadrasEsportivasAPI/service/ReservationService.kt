package br.ccc.upf.QuadrasEsportivasAPI.service

import br.ccc.upf.QuadrasEsportivasAPI.converter.ReservationConverter
import br.ccc.upf.QuadrasEsportivasAPI.dto.ReservationDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.ReservationResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.exception.NotFoundException
import br.ccc.upf.QuadrasEsportivasAPI.repository.ReservationRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val RESERVATION_NOT_FOUND_MESSAGE = "Reserva Nao encontrada!"

@Service
class ReservationService(
    private val repository: ReservationRepository,
    private val converter: ReservationConverter
){

    fun list(
        nameReservation: String?,
        pagination: Pageable): Page<ReservationResponseDTO> {
        val reservations = repository.findAll(pagination)
        return reservations
            .map(converter::toReservationResponseDTO)

    }

    fun searchById(id : Long): ReservationResponseDTO{
        val reservation =  repository.findById(id)
            .orElseThrow{ NotFoundException(RESERVATION_NOT_FOUND_MESSAGE) }

        return converter.toReservationResponseDTO(reservation)
    }

    fun create(dto: ReservationDTO) : ReservationResponseDTO{
        return converter.toReservationResponseDTO(
            repository.save(converter.toReservation(dto))
        )
    }

    fun update(id: Long, dto: ReservationDTO): ReservationResponseDTO{
        val reservation = repository.findById(id)
            .orElseThrow{NotFoundException(RESERVATION_NOT_FOUND_MESSAGE)}
            .copy(
                time = dto.time,
                user = dto.user,
                description = dto.description
            )
        return converter.toReservationResponseDTO(repository.save(reservation))
    }


    fun delete(id:Long){
        repository.deleteById(id)
    }
}