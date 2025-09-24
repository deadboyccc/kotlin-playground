package dev.dead

import java.math.BigDecimal

data class Product(
    val name: String,
    val price: BigDecimal,
    val upc: String,
    val quantity: Int

)
