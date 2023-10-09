package br.ccc.upf.QuadrasEsportivasAPI.controller

import br.ccc.upf.QuadrasEsportivasAPI.dto.UserDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.UserResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.service.UserService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/user")
class UserCon (val service: UserService){

    @GetMapping
    fun list(): List<UserResponseDTO>{
        return service.list()
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Long):UserResponseDTO{
        return service.searchById(id)
    }

    @PostMapping
    @Transactional
    fun create(@RequestBody @Valid dto : UserDTO,
               uriBuilder: UriComponentsBuilder
    ) : ResponseEntity<UserResponseDTO>{
        val userResponse = service.create(dto)
        val uri = uriBuilder.path("/user/${userResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(userResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun update(@PathVariable id: Long,
               @RequestBody @Valid dto: UserDTO):UserResponseDTO{
        return service.update(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id:Long){
        service.delete(id)
    }

}