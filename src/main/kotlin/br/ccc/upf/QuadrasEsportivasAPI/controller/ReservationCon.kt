package br.ccc.upf.QuadrasEsportivasAPI.controller

import br.ccc.upf.QuadrasEsportivasAPI.service.ReservationService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reservations")
class ReservationCon(val service: ReservationService) {

}