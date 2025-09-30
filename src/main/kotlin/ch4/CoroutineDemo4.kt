package dev.dead.ch4

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import kotlin.random.Random
import kotlin.system.measureTimeMillis

suspend fun main() {
    runBlocking {
        val time = measureTimeMillis {
            val maxConcurrency = 1000 // Limit concurrent coroutines
            val semaphore = Semaphore(maxConcurrency)

            val deferred = (1..100000).map {
                async {
                    semaphore.withPermit {
                        doSomethingUsefulOne()
                    }
                }
            }
            // wait for all tasks to complete and sum the results
            val sum = deferred.awaitAll().sum()
            println("Sum is $sum")
        }
        println("Completed 100000 tasks in ${(time / 1000.toDouble())} s")
    }
}

suspend fun doSomethingUsefulOne(): Int {
    delay(3000)
    return Random.nextInt(500) + 1
}