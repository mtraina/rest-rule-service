package com.mtraina.restruleservice

import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.status
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

data class Error(val code: Int, val messages: List<String>)

fun internalServerError(t: Throwable) = error(HttpStatus.INTERNAL_SERVER_ERROR, t)

private fun error(status: HttpStatus, t: Throwable): Mono<ServerResponse> {
    val error = Error(status.value(), listOf(t.message ?: status.name))
    return status(status).body(Mono.just(error))
}