package br.ccc.upf.QuadrasEsportivasAPI.service

import br.ccc.upf.QuadrasEsportivasAPI.converter.CourtConverter
import br.ccc.upf.QuadrasEsportivasAPI.dto.CourtDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.CourtResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.exception.NotFoundException
import br.ccc.upf.QuadrasEsportivasAPI.model.Court
import br.ccc.upf.QuadrasEsportivasAPI.repository.CourtRepository
import org.springframework.stereotype.Service

private const val COURT_NOT_FOUND_MESSAGE = "Quadra não encontrado!"

@Service
class CourtService(private val repository: CourtRepository,
    private val converter: CourtConverter) {

    fun list():List<CourtResponseDTO> {
        return repository.findAll()
            .map(converter::toCourtResponseDTO)
    }

    fun searchById(id : Long) : CourtResponseDTO{
        val court = repository.findAll().firstOrNull {it.id == id }
            ?: throw NotFoundException(COURT_NOT_FOUND_MESSAGE)
        return converter.toCourtResponseDTO(court)
    }

    fun create(courtDTO: CourtDTO) : CourtResponseDTO{
        val court =  repository.create(converter.toCourt(courtDTO))
        return converter.toCourtResponseDTO(court)
    }

    fun update(id: Long, courtDTO: CourtDTO) : CourtResponseDTO{
        val court = repository.findAll().firstOrNull() { it.id == id }
            ?: throw NotFoundException(COURT_NOT_FOUND_MESSAGE)

        val courtWithId = repository.update(court, converter.toCourt(courtDTO))

        return converter.toCourtResponseDTO(courtWithId)
    }

    fun delete(id: Long){
        repository.delete(id)
    }

}