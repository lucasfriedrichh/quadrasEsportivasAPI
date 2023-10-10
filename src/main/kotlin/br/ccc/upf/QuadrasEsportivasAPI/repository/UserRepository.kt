package br.ccc.upf.QuadrasEsportivasAPI.repository

import br.ccc.upf.QuadrasEsportivasAPI.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.security.core.userdetails.UserDetails

@Repository
interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email: String): UserDetails?

}
