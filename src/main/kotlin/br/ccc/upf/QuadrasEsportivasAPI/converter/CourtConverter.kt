package br.ccc.upf.QuadrasEsportivasAPI.converter

import br.ccc.upf.QuadrasEsportivasAPI.dto.CourtDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.CourtResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.model.Court
import org.springframework.stereotype.Component

@Component
class CourtConverter {

    fun toCourt(dto : CourtDTO) : Court{
        return Court(
            description = dto.description,
            status = dto.status,
            )
    }

    fun toCourtResponseDTO(court: Court): CourtResponseDTO {
        return CourtResponseDTO(
            id = court.id,
            description = court.description,
            status = court.status
        )
    }


}