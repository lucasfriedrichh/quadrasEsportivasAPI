package br.ccc.upf.QuadrasEsportivasAPI.controller

import br.ccc.upf.QuadrasEsportivasAPI.dto.CourtDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.CourtResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.service.CourtService
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
@RequestMapping("/court")
class CourtCon(val service: CourtService) {

    @GetMapping
    fun list(
        @RequestParam(required = false) courtName: String?,
        @PageableDefault(size = 10) pagination: Pageable
    ): Page<CourtResponseDTO>{
        return service.list(courtName, pagination)
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Long): CourtResponseDTO{
        return service.searchById(id)
    }

    @PostMapping
    @Transactional
    fun create(@RequestBody @Valid dto : CourtDTO,
               uriBuilder: UriComponentsBuilder
    ) : ResponseEntity<CourtResponseDTO> {

        val courtResponse = service.create(dto)

        val uri = uriBuilder.path("/court/${courtResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(courtResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun update(@PathVariable id: Long,
               @RequestBody @Valid dto: CourtDTO
    ): CourtResponseDTO {
        return service.update(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long){
        service.delete(id)
    }

}