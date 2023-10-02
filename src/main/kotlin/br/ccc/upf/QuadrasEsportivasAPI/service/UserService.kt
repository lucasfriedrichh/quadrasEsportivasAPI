package br.ccc.upf.QuadrasEsportivasAPI.service

import br.ccc.upf.QuadrasEsportivasAPI.converter.UserConverter
import br.ccc.upf.QuadrasEsportivasAPI.dto.CourtDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.CourtResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.UserDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.UserResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.exception.NotFoundException
import br.ccc.upf.QuadrasEsportivasAPI.repository.UserRepository
import org.apache.catalina.User
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

private const val COURT_NOT_FOUND_MESSAGE = "Usuario nao encontrado"

@Service
class UserService(
    private val repository: UserRepository,
    private val converter: UserConverter
) {
    fun list():List<UserResponseDTO>{
        return repository.findAll()
            .map(converter::toUserResponseDTO)
    }

    fun searchById(id:Long): UserResponseDTO{
        val user = repository.findAll().firstOrNull{it.id == id}
            ?: throw NotFoundException(COURT_NOT_FOUND_MESSAGE)

        return converter.toUserResponseDTO(user)
    }

    fun create(userDTO: UserDTO):UserResponseDTO{
        val user =  repository.create(converter.toUser(userDTO))
        return converter.toUserResponseDTO(user)
    }

    fun update(id: Long, userDTO: UserDTO) : UserResponseDTO {
        val user = repository.findAll().firstOrNull() { it.id == id }
            ?: throw NotFoundException(COURT_NOT_FOUND_MESSAGE)

        val userWithId = repository.update(user, converter.toUser(userDTO))

        return converter.toUserResponseDTO(userWithId)
    }
    fun delete(id: Long){
        repository.delete(id)
    }

}