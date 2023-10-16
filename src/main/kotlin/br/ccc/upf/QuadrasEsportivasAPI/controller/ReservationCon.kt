package br.ccc.upf.QuadrasEsportivasAPI.controller

import br.ccc.upf.QuadrasEsportivasAPI.dto.ReservationDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.ReservationResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.service.ReservationService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/reservation")
class ReservationCon(val service: ReservationService) {

    @GetMapping
    fun list(
        @RequestParam(required = false) reservationDescription: String?,
        @PageableDefault(size = 10) pagination : Pageable
    ): Page<ReservationResponseDTO>{
        return service.list(reservationDescription, pagination)
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable id : Long) : ReservationResponseDTO{
        return service.searchById(id)
    }

    @PostMapping
    @Transactional
    fun create(@RequestBody @Valid dto: ReservationDTO,
                uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ReservationResponseDTO>{
        val reservationResponse = service.create(dto)
        val uri = uriBuilder.path("/reservation/${reservationResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(reservationResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun update(@PathVariable id : Long,
               @RequestBody @Valid dto: ReservationDTO) : ReservationResponseDTO{
        return service.update(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long){
        service.delete(id)
    }


}