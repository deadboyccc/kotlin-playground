package dev.dead.extras

import kotlinx.coroutines.*

fun partThree() {
    runBlocking {
        val windows: Deferred<Product> = async { order(Product.WINDOWS) }
        val doors: Deferred<Product> = async { order(Product.DOORS) }
        launch {
            perform("Laying bricks")
            perform("Installing ${windows.await().description}")
            perform("Installing ${doors.await().description}")
        }
    }
}

fun main() {

    // simple yield()
//    partOne()
    // sync
//    partTwo()
    // coroutine per task
}

fun partTwo() {
    val windows = orderSync(Product.WINDOWS)
    val doors = orderSync(Product.DOORS)
    performSync("laying bricks")
    performSync("installing ${windows.description}")
    performSync("installing ${doors.description}")
}

suspend fun order(item: Product): Product {
    println("ORDER EN ROUTE >>> The ${item.description} are on the way!")
    delay(item.deliveryTime)
    println("ORDER DELIVERED >>> Your ${item.description} have arrived.")
    return item
}

suspend fun perform(taskName: String) {
    println("STARTING TASK >>> $taskName")
    delay(1000)
    println("FINISHED TASK >>> $taskName")
}

fun orderSync(item: Product): Product {
    println("ORDER EN ROUTE >>> The ${item.description} are on the way!")
    Thread.sleep(item.deliveryTime)
    println("ORDER DELIVERED >>> Your ${item.description} have arrived.")
    return item
}

fun performSync(taskName: String) {
    println("STARTING TASK >>> $taskName")
    Thread.sleep(1_000)
    println("FINISHED TASK >>> $taskName")
}

fun partOne() {
    runBlocking {
        launch {

            println("Sledge: Suplex!")
            tagOut()
            println("Sledge: Figure-four Leglock!")
            tagOut()
            println("Sledge: Pinning 1-2-3!")
        }
        launch {

            println("Hammer: Clothesline!")
            tagOut()
            println("Hammer: Piledriver!")
            tagOut()
        }
    }
}

suspend fun tagOut() {
    println("Tagging out!")
    yield()
}

enum class Product(val description: String, val deliveryTime: Long) {
    DOORS("doors", 750),
    WINDOWS("windows", 1_250)
}
