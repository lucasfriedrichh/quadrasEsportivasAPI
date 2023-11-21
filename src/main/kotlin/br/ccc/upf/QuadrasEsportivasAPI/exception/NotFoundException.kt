package br.ccc.upf.QuadrasEsportivasAPI.exception

import java.lang.RuntimeException

class NotFoundException(override val message: String)
    : RuntimeException()