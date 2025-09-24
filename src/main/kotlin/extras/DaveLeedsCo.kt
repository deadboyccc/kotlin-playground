package dev.dead.extras

import kotlinx.coroutines.*
import kotlin.system.measureNanoTime

var count = 0;
suspend fun waitTwoSeconds() {
    delay(2000L)
    count++
    println("[Waiting for five seconds...]  ---  [#$count]")
}

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

fun partFive() {
    runBlocking() {
        val windows: Deferred<Product> = async(Dispatchers.IO) { order(Product.WINDOWS) }
        val doors: Deferred<Product> = async(Dispatchers.IO)
        { order(Product.DOORS) }
            .also { cancel() }
        launch(Dispatchers.Default) {
            perform("Laying bricks")
            launch { perform("Installing ${windows.await().description}") }
            launch { perform("Installing ${doors.await().description}") }
        }

//        cancel()
    }

}

fun partFour() {
    runBlocking() {
        val windows: Deferred<Product> = async(Dispatchers.IO) { order(Product.WINDOWS) }
        val doors: Deferred<Product> = async(Dispatchers.IO) { order(Product.DOORS) }
        launch(Dispatchers.Default) {
            perform("Laying bricks")
            launch { perform("Installing ${windows.await().description}") }
            launch { perform("Installing ${doors.await().description}") }
        }

//        cancel()
    }

}

fun main() {
    runBlocking {
        val coresCount = Runtime.getRuntime().availableProcessors()
        println("Cores: $coresCount")

        val time = measureNanoTime {
            val jobs: List<Deferred<Unit>> = List(12) { async(Dispatchers.Default) { waitTwoSeconds() } }
//            jobs.parallelStream().forEach {
//                println("Job: ${it}")
//
//            }
            jobs.awaitAll() // Wait for all coroutines to finish
        }


        println("Total exec time: ${time / 1000000000.0} seconds")
        println("DONE WAITING")
    }
//    // print nums of cores
//    val coresCount: Int = Runtime.getRuntime().availableProcessors()
//    println("Cores: $coresCount")
//    runBlocking(Dispatchers.IO) {
//        val start: LocalDateTime = LocalDateTime.now()
//        val firstWait = async { waitTwoSeconds() }
//        val secondWait = async { waitTwoSeconds() }
//        val thirdWait = async { waitTwoSeconds() }
//        val fourthWait = async { waitTwoSeconds() }
//        val fifthWait = async { waitTwoSeconds() }
//        val sixthWait = async { waitTwoSeconds() }
//        for (i in 1..400){
//            async { waitTwoSeconds() }
//
//        }
//
////        awaitAll(firstWait, secondWait, thirdWait, fourthWait, fifthWait, sixthWait)
//        val end: LocalDateTime = LocalDateTime.now()
//        println("Total exec time : ${start.until(end, ChronoUnit.SECONDS)}")
//
//        println("DONE WAITING")

}
//    partFour()

    // simple yield()
//    partOne()
    // sync
//    partTwo()
    // coroutine per task
//}

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
