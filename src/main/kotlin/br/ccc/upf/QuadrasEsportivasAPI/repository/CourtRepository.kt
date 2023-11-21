package br.ccc.upf.QuadrasEsportivasAPI.repository

import br.ccc.upf.QuadrasEsportivasAPI.model.Court
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourtRepository : JpaRepository<Court, Long>{

    fun findByDescription(name:String, pagination: Pageable) : Page<Court>

}