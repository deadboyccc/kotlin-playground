package dev.dead.ch2


fun main() {
    val colors = mutableListOf<Color>(
        Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.INDIGO, Color.VIOLET
    )
    for (color in colors) {
        val colorString =
            when (color) {
                Color.RED -> "Red"
                Color.ORANGE -> "Orange"
                Color.GREEN -> "Green"
                Color.BLUE -> "Blue"
                Color.INDIGO -> "Indigo"
                Color.VIOLET -> "Violet"
                Color.YELLOW -> "Yellow"
            }
        println(colorString)


    }

}