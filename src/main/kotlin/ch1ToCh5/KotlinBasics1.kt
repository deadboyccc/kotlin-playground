package dev.dead.ch1ToCh5

fun main() {

    val p1 = MyPerson("Joe")
    p1.isStudent = true
    println(p1.isStudent)
    val r1 = MyRectangle(10.5, 10.5)
    println("is Square = ${r1.isSquare}")

}

class MyPerson {
    val name: String
    var isStudent: Boolean

    constructor(name: String = "anon", isStudent: Boolean = false) {
        this.name = name
        this.isStudent = isStudent
    }

}

class MyRectangle(val height: Double = 0.0, val width: Double = 0.0) {
    val isSquare: Boolean
        get() = height == width


}