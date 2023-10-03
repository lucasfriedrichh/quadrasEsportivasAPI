package br.ccc.upf.QuadrasEsportivasAPI.converter

import br.ccc.upf.QuadrasEsportivasAPI.dto.UserDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.UserResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.model.User
import org.springframework.stereotype.Component

@Component
class UserConverter {

    fun toUser(dto : UserDTO) : User {
        return User(
            name = dto.name,
            email = dto.name,
            phone = dto.phone,
            city = dto.phone
        )
    }

    fun toUserDTO(user: User) : UserDTO {
        return UserDTO(
            name = user.name,
            email = user.name,
            phone = user.phone,
            city = user.phone
        )
    }

    fun toUserResponseDTO(user: User): UserResponseDTO {
        return UserResponseDTO(
            id = user.id,
            name = user.name,
            email = user.name,
            phone = user.phone,
            city = user.phone
        )
    }
}