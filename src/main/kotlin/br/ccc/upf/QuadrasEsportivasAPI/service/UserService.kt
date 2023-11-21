package br.ccc.upf.QuadrasEsportivasAPI.service

import br.ccc.upf.QuadrasEsportivasAPI.converter.UserConverter
import br.ccc.upf.QuadrasEsportivasAPI.dto.UserDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.UserResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.exception.NotFoundException
import br.ccc.upf.QuadrasEsportivasAPI.repository.UserRepository
import org.springframework.stereotype.Service

private const val USER_NOT_FOUND_MESSAGE = "Usuario nao encontrado"

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
        val user = repository.findById(id)
            .orElseThrow { NotFoundException(USER_NOT_FOUND_MESSAGE) }
        return converter.toUserResponseDTO(user)
    }

    fun create(dto: UserDTO):UserResponseDTO{
        return converter.toUserResponseDTO(
            repository.save(converter.toUser(dto))
        )
    }

    fun update(id: Long, dto: UserDTO) : UserResponseDTO {
        val user = repository.findById(id)
            .orElseThrow{NotFoundException(USER_NOT_FOUND_MESSAGE)}
            .copy(
                name = dto.name,
                city = dto.city,
                phone = dto.phone,
            )

        return converter.toUserResponseDTO( repository.save(user))
    }

    fun delete(id: Long){
        repository.deleteById(id)
    }

}