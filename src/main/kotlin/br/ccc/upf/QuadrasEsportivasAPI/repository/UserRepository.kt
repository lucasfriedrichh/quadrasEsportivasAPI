package br.ccc.upf.QuadrasEsportivasAPI.repository

import br.ccc.upf.QuadrasEsportivasAPI.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {
}
