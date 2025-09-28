package dev.dead.ch2

fun fizzBuzz(i: Int): String =
    when {
        i % 15 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> i.toString()
    }

fun main() {
    val i = 1..2
    i.forEach { println(it) }
    println("*".repeat(20))
    val j = 1 until 4
    val k = 1 downTo 4
    val l = 4 downTo 1
    for (i in l) {
        println(i)
    }
    fun isLetter(c: Char): Boolean = c in 'a'..'z' || c in 'A'..'Z'
    fun isDigit(c: Char): Boolean = c in '0'..'9'

    fun recognize(c: Char): String = when (c) {
        in '0'..'9' -> "digit"
        in 'a'..'z', in 'A'..'Z' -> "letter"
        else -> "default"

    }

    println("*".repeat(20))
    for (i in 1..3)
        println(fizzBuzz(i) + "\t" + "->$i")
    println("*".repeat(20))
    val listWtihIndex = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for ((index, value) in listWtihIndex.withIndex()) {
        println("$index: $value")
    }
    val num1 = divieBy(10, 3)
    println(num1)
    val num2 = divieBy(10, 0)
    println(num2 ?: 999999999999)
    
}

fun divieBy(i: Int, j: Int): Int? {
    val a = try {
        i / j
    } catch (e: Exception) {
        null
    }
    return a
}