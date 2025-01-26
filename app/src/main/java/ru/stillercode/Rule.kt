package ru.stillercode

data class Rule(
    val birth: Set<Int>,
    val survival: Set<Int>,
    val name: String = "Custom rule"
)
