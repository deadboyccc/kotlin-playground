package dev.dead

data class Person(val name: String, val age: Int? = null)

fun main() {
    val persons = listOf(
        Person("Alice", 29),
        Person("Bob", 22),
        Person("Carol"),

        )
    val oldest = persons.maxBy { it.age ?: 0 }
    println("oldest is $oldest")
}