package br.ccc.upf.QuadrasEsportivasAPI.repository

import br.ccc.upf.QuadrasEsportivasAPI.model.Reservation
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservationRepository: JpaRepository<Reservation, Long> {
}