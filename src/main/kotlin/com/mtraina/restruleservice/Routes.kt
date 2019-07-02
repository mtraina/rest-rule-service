package com.mtraina.restruleservice

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

@Configuration
open class Routes(private val ruleHandler: RuleHandler) {

    @Bean
    open fun router() = router {
        "/api".nest {
            accept(APPLICATION_JSON).nest {
                GET("/rules", ruleHandler::findAll)
            }
        }
    }
    .filter { request, next ->
        try {
            next.handle(request)
        } catch (ex: Exception) {
            internalServerError(ex)
        }
    }
}