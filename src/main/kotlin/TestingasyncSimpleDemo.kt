package dev.dead

import kotlinx.coroutines.delay

suspend fun main() {
    println("Main thread Start: ${Thread.currentThread().name}")
    wait()
    println("Main thread End: ${Thread.currentThread().name}")

}

suspend fun wait() {
    println("waiting at Thread : ${Thread.currentThread().name}")
    delay(3000)
    println("Done at Thread : ${Thread.currentThread().name}")
}