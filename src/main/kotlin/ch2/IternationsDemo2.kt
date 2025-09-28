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
    println("*".repeat(20))
    for (i in 1..3)
        println(fizzBuzz(i) + "\t" + "->$i")
}