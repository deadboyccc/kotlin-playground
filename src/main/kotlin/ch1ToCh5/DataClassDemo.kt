package dev.dead.ch1ToCh5

import java.math.BigDecimal
import java.util.*


fun main() {
    val product = Product("p1", BigDecimal(100), UUID.randomUUID().toString(), 12);
    println(product)
    val product2 = product.copy();
    println(product2)
    if (
        product2 == product
    )
        println("True")

    suspend {
        println("Suspend")
        Thread.sleep(1000);
    }
    println("test")
    Thread.sleep(1500);
}