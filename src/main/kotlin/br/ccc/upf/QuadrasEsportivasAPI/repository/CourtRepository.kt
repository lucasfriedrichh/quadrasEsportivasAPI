package br.ccc.upf.QuadrasEsportivasAPI.repository

import br.ccc.upf.QuadrasEsportivasAPI.model.Court
import br.ccc.upf.QuadrasEsportivasAPI.model.StatusCourt
import org.springframework.stereotype.Repository

@Repository
class CourtRepository (private var listCourt: MutableList<Court>){

    private var idCont = 4L

    init {
        listCourt = mutableListOf()
    }

    fun findAll() = listCourt

    fun create(court: Court) : Court{
        val courtWithId = court.copy(id = idCont++)
        listCourt.add(courtWithId)
        return courtWithId
    }

    fun update(court: Court, newCourt: Court) : Court {
        listCourt.remove(court)
        val courtWithId = Court(
            id = court.id,
            description = newCourt.description,
            status = newCourt.status
        )
        listCourt.add(courtWithId)

        return courtWithId
    }

    fun delete(id: Long){
        val court = listCourt.first{it.id == id}

        listCourt.remove(court)
    }

}