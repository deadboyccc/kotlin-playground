package dev.dead.ch4

interface clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

abstract class Focusable {
    abstract fun setFocus(b: Boolean)
    open fun showOff() = println("I'm focusable!")
}

class button : clickable, Focusable() {
    override fun click() = println("I was clicked")
    override fun setFocus(b: Boolean) {
        println("I ${if (b) "got" else "lost"} focus.")
    }

    override fun showOff() {
        super<clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main() {
    val btn = button()
    btn.click()
    btn.setFocus(true)
    btn.showOff()

}