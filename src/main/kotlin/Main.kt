package dev.dead

import kotlin.random.Random

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
fun nullableStringReturn(): String? {
    val bool = Random.nextBoolean()
    return when (bool) {
        true -> {
            "Hello World"
        }
        false->{
//            null
            ""
        }

    }
}

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")
    println()

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }
    val hehe = TestTestDemoH()
    println(hehe.returnHelloString())
    println("_".repeat(10))
    println(nullableStringReturn())
    println(nullableStringReturn()?.ifEmpty { "It was empty" })
}