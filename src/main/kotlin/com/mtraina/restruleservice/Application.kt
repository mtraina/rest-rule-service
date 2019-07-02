package com.mtraina.restruleservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans

// TODO to be removed once teh kotlin dsl is fully ready
// https://docs.spring.io/spring/docs/5.2.0.BUILD-SNAPSHOT/spring-framework-reference/languages.html#kotlin-bean-definition-dsl
@SpringBootApplication
class Application {
    @Autowired
    fun register(ctx: GenericApplicationContext) = beans().initialize(ctx)
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

fun beans() = beans {
    bean<RuleHandler>()
    bean<RuleService>()
    //bean<Routes>()
    //bean(WebHttpHandlerBuilder.WEB_HANDLER_BEAN_NAME) {
    //    RouterFunctions.toWebHandler(ref<Routes>().router())
    //}
}