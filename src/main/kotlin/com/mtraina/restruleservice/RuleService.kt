package com.mtraina.restruleservice

class RuleService {
    private val rules = listOf(Rule("area", "emea"), Rule("country", "GB"))

    fun findAll() = rules
}