package br.ccc.upf.QuadrasEsportivasAPI.converter

import br.ccc.upf.QuadrasEsportivasAPI.dto.CourtDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.CourtResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.model.Court
import org.springframework.stereotype.Component

@Component
class CourtConverter {

    fun toCourt(dto : CourtDTO) : Court{
        return Court(
            status = dto.status,
            description = dto.description
        )
    }

    fun toCourtDTO(court: Court) : CourtDTO{
        return CourtDTO(
            description = court.description,
            status = court.status
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