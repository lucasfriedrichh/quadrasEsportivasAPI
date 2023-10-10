package br.ccc.upf.QuadrasEsportivasAPI.controller

import br.ccc.upf.QuadrasEsportivasAPI.dto.LoginDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.LoginResponseDTO
import br.ccc.upf.QuadrasEsportivasAPI.dto.UserDTO
import br.ccc.upf.QuadrasEsportivasAPI.model.User
import br.ccc.upf.QuadrasEsportivasAPI.service.TokenService
import br.ccc.upf.QuadrasEsportivasAPI.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@RestController
@RequestMapping("auth")
class AuthenticationCon(
    val authenticationManager: AuthenticationManager,
    val service: UserService,
    val tokenService: TokenService) {

    @PostMapping("/login")
    fun login(@RequestBody data: LoginDTO): ResponseEntity<LoginResponseDTO> {
        val userPassword = UsernamePasswordAuthenticationToken(
            data.login, data.password)
        val auth = authenticationManager.authenticate(userPassword)
            val token = tokenService.generateToken(auth.principal as User)
        return ResponseEntity.ok(LoginResponseDTO(token))
    }


    @PostMapping("/register")
    fun login(@RequestBody data: UserDTO): ResponseEntity<String> {
        service.create(data)
        return ResponseEntity.ok().build()
    }
}