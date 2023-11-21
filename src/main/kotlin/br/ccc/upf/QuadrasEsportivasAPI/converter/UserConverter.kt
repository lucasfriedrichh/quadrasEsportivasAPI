package br.ccc.upf.QuadrasEsportivasAPI.converter

import br.ccc.upf.QuadrasEsportivasAPI.dto.UserDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.UserResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.model.User
import org.springframework.stereotype.Component

@Component
class UserConverter {

    fun toUser(dto: UserDTO): User {
        return User(
            name = dto.name,
            city = dto.city,
            phone = dto.phone,
        )
    }

    fun toUserResponseDTO(user: User): UserResponseDTO {
        return UserResponseDTO(
            id = user.id,
            nome = user.name,
            city = user.city,
            phone = user.phone

        )
    }
}