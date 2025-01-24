package ru.stillercode

data class Rule(
    val survival: List<Int>,
    val birth: List<Int>,
    val name: String = "Custom rule"
)
