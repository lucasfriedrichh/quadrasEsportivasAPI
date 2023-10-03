package br.ccc.upf.QuadrasEsportivasAPI.service

import br.ccc.upf.QuadrasEsportivasAPI.converter.CourtConverter
import br.ccc.upf.QuadrasEsportivasAPI.dto.CourtDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.CourtResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.exception.NotFoundException
import br.ccc.upf.QuadrasEsportivasAPI.repository.CourtRepository
import org.springframework.stereotype.Service

private const val COURT_NOT_FOUND_MESSAGE = "Quadra não encontrado!"

@Service
class CourtService(
    private val repository: CourtRepository,
    private val converter: CourtConverter
) {

    fun list():List<CourtResponseDTO> {
        return repository.findAll()
            .map(converter::toCourtResponseDTO)
    }

    fun searchById(id : Long) : CourtResponseDTO{
        val court = repository.findById(id)
            .orElseThrow { NotFoundException(COURT_NOT_FOUND_MESSAGE) }
        return converter.toCourtResponseDTO(court)
    }

    fun create(dto: CourtDTO) : CourtResponseDTO{
        return converter.toCourtResponseDTO(
            repository.save(converter.toCourt(dto))
        )
    }

    fun update(id: Long, dto: CourtDTO) : CourtResponseDTO{
        val court = repository.findById(id)
            .orElseThrow { NotFoundException(COURT_NOT_FOUND_MESSAGE) }
            .copy(
                description = dto.description,
                status = dto.status
            )
        return converter.toCourtResponseDTO(repository.save(court))

    }

    fun delete(id: Long){
        repository.deleteById(id)
    }

}