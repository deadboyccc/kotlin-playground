package dev.dead

import kotlin.math.sqrt

suspend fun main() {
    println("Main thread Start: ${Thread.currentThread().name}")
    wait()
    println("Main thread End: ${Thread.currentThread().name}")
    println("_".repeat(20))
    val s1: String? = null
    val s2 = ""
    println(s1 ?: "it was null")
    println(s2.count())
    val s3: String = "testCast"
    modify(s3)
    modify(5)
    val result = max(10, 20);
    println(result)
    val myBoolean = true;
    val x = if (myBoolean) "u" else "d";

    val direction = when (x) {
        "u" -> "up"
        "d" -> "down"
        "l" -> "left"
        "r" -> "right"

        else ->
            "default"

    }
    println("Enter number: ")
    val inputString = readlnOrNull()
    val number = try {
        inputString ?: "".toInt()
    } catch (e: NumberFormatException) {
        println(e.message)
    }
    val input = readln();
    val name = input.ifEmpty { "kotlin" }
    val p1 = TestPerson("Joe")
    val p2 = TestPerson("Joe")
    println(p1.name)
    println(p1.toString())



}

class TestPerson(val name: String)

fun modify(unit: Any) {
    if (unit is String) {
        println(unit.uppercase())
    }
    if (unit is Int) {
        println("square root  of $unit is ${sqrt(unit.toDouble())}")
    }


}

fun max(a: Int, b: Int): Int = if (a > b) a else b


suspend fun wait() {
    println("waiting at Thread : ${Thread.currentThread().name}")
//    delay(3000)
    println("Done at Thread : ${Thread.currentThread().name}")
}