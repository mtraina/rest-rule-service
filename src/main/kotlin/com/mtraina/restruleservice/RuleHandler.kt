package com.mtraina.restruleservice

import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.BodyInserters.fromObject

class RuleHandler(private val ruleService: RuleService) {

    fun findAll(req: ServerRequest) = ServerResponse
            .ok()
            .contentType(APPLICATION_JSON)
            .body(fromObject(ruleService.findAll()))
}