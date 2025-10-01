package ch05

fun main() {
    val fruits = listOf("apple", "banana", "orange")
    var uppercasedFruits = mutableListOf<String>()
    fruits.map { it.uppercase() }
        .also { uppercasedFruits.addAll(it) }
        .also { println("The list elements after uppercasing: $it") }
        .filter { it.startsWith("A") }
        .also { println("The list elements after filtering(starts with a): $it") }

    var string = StringBuilder().apply {
        append("Hello, ")
        append("World!")

    }.toString()

    var string2 = buildString {
        append("Hello, ")
        append("World!")

    }
    var string3 = with(StringBuilder()) {
        append("Hello, ")
        append("World!")
        toString()

    }
    var actions = (1..5).map { it * it }.filter { it > 10 }
    var builders = (1..100).map {
        StringBuilder().apply {
            append(it)
        }.toString()
    }
    builders.forEach { println(it) }
}
