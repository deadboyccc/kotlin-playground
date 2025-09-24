package dev.dead.extras


import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class JoshOreillySpring

fun main() {
    val test = JoshOreillySpring()
    val functionRef = { value: Int -> value * value }

    val letters = mutableListOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j')
    letters += 'k'

    letters.map { it.uppercaseChar() }
        .filter { it in 'H'..'Z' }
        .forEach { println(it) }

    println(test.hashCode())
    println(functionRef(5))
    "JoshOreilly".let { println(it) }
    "JoshOreilly".apply { println(this.uppercase()) }
    val time = measureTimeMillis {

        runBlocking {

            val r: List<Int> = (1..1_000_000).map {
                async(Dispatchers.Default) {
                    delay(1000)
                }
                it * it

            }.filter { it in 1..2_000_000 }

            launch {
                println(r.sum())
            }


        }
    }
    println("Total time: ${time / 1000.0} seconds")

}
