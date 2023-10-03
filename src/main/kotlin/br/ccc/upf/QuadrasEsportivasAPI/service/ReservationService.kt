package br.ccc.upf.QuadrasEsportivasAPI.service

import br.ccc.upf.QuadrasEsportivasAPI.converter.ReservationConverter
import br.ccc.upf.QuadrasEsportivasAPI.dto.ReservationDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.ReservationResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.exception.NotFoundException
import br.ccc.upf.QuadrasEsportivasAPI.repository.ReservationRepository
import org.springframework.stereotype.Service

private const val RESERVATION_NOT_FOUND_MESSAGE = "Reserva não encontrado!"

@Service
class ReservationService (
    private val repository: ReservationRepository,
    private val converter: ReservationConverter
) {

    fun list():List<ReservationResponseDTO> {
        return repository.findAll()
            .map(converter::toReservationResponseDTO)
    }


    fun searchById(id : Long) : ReservationResponseDTO{
        val reservation  = repository.findById(id)
            .orElseThrow{NotFoundException(RESERVATION_NOT_FOUND_MESSAGE)}
        return converter.toReservationResponseDTO(reservation)
    }

    fun create(dto: ReservationDTO) : ReservationResponseDTO{
        return converter.toReservationResponseDTO(
            repository.save(converter.toReservation(dto))
        )
    }

    fun update(id: Long, dto: ReservationDTO) : ReservationResponseDTO{
        val reservation = repository.findById(id)
            .orElseThrow{NotFoundException(RESERVATION_NOT_FOUND_MESSAGE)}
            .copy(
                user = dto.user,
                time = dto.time
            )
        return converter.toReservationResponseDTO(repository.save(reservation))
    }

    fun delete(id: Long){
        repository.deleteById(id)
    }


}