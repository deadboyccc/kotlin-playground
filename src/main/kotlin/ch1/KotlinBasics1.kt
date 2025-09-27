package dev.dead.ch1ToCh5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

suspend fun main() {

    val p1 = MyPerson("Joe")
    p1.isStudent = true
    println(p1.isStudent)
    val r1 = MyRectangle(10.5, 10.5)
    println("is Square = ${r1.isSquare}")
    withContext(Dispatchers.Default) {
        println("Starting...")

        // Launch two async coroutines (like async/await in JS/Python)
        val a = async { delay(1500) }.await()
        println(a)

        val first = async { waitFive("First") }
        val second = async { waitFive("Second") }

        // Await results (like Promise.await())
        val result1 = first.await()
        val result2 = second.await()

        println("Results: $result1 and $result2")
        println("Done.")
    }
    println("Main Thread = ${Thread.currentThread().name} is Done")



}

suspend fun waitFive(name: String): String {
    delay(2000) // suspends coroutine without blocking a thread
    return "Hello from $name"
}


class MyPerson {
    val name: String
    var isStudent: Boolean

    constructor(name: String = "anon", isStudent: Boolean = false) {
        this.name = name
        this.isStudent = isStudent
    }

}

class MyRectangle(val height: Double = 0.0, val width: Double = 0.0) {
    val isSquare: Boolean
        get() = height == width


}