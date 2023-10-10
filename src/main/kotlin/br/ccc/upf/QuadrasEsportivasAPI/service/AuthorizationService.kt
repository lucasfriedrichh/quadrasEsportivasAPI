package br.ccc.upf.QuadrasEsportivasAPI.service

import br.ccc.upf.QuadrasEsportivasAPI.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthorizationService(
    val repository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(email: String) =
        repository.findByEmail(email)
}