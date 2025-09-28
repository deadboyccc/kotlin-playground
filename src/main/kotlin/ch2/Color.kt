package dev.dead.ch2

enum class Color(
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
    fun getRed() = r * 256 + g    // Changed from getR to getRed
    fun getGreen() = g * 256 + b  // Changed from getG to getGreen for consistency
    fun getBlue() = b * 256 + r   // Changed from getB to getBlue for consistency
}

fun main() {
    println(Color.BLUE.rgb())
    println("_".repeat(20))
    val s = setOfNotNull(Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE)
    println(s)
}