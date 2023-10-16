package br.ccc.upf.QuadrasEsportivasAPI.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfigurations(val securityFilter: SecurityFilter) {
    @Bean
    fun securityFilterChain (
        httpSecurity: HttpSecurity
    ): SecurityFilterChain {
        return httpSecurity
            .csrf { it.disable() }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy. STATELESS)
            }
            .authorizeHttpRequests {
                it.requestMatchers(HttpMethod. POST, "/court").hasRole("ADMIN") //New Court
                    .requestMatchers(HttpMethod. GET, "/court").permitAll() //Get Court
                    .requestMatchers(HttpMethod. DELETE, "/court").permitAll()
                    .requestMatchers(HttpMethod. PUT, "/court").permitAll()
                    .requestMatchers(HttpMethod.GET, "/user").hasRole("ADMIN") // Get User
                    .requestMatchers(HttpMethod.DELETE, "/user").hasRole("ADMIN") // Delete User
                    .requestMatchers(HttpMethod.PUT, "/user").hasRole("ADMIN") // Get User
                    .requestMatchers(HttpMethod.POST, "/user").hasRole("ADMIN") // Get User
                    .requestMatchers(HttpMethod.GET, "/reservation").permitAll()
                    .requestMatchers(HttpMethod.POST, "/reservation").permitAll()
                    .requestMatchers(HttpMethod.DELETE, "/reservation").permitAll()
                    .requestMatchers(HttpMethod.PUT, "/reservation").permitAll()
                    .requestMatchers("/auth/*").permitAll()
                    .anyRequest().authenticated()
            }
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()
    }


    @Bean
    fun authenticationManager(
        authenticationConfiguration: AuthenticationConfiguration
    ): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }


}