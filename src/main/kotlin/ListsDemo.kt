package dev.dead

fun main(){

    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
    val mutableList2: MutableList<String> = mutableListOf("Hello", "World")
    mutableList2.add("Hello")
    println(mutableList2)


    val typicalList = listOf(1, 2, 3)
    println("_".repeat(30))
    typicalList.forEach { println(it) }
    println("_".repeat(30))
    typicalList.map { it * it }.forEach { println(it) }

}
