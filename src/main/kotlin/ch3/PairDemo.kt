package dev.dead.ch3

import org.intellij.lang.annotations.Language

fun main() {
    val a = Pair(1, "ONE")
    val (first, second) = a
    println(first.takeUnless { it != 1 })
    println(second.takeIf { it[0].isUpperCase() })
    val map = mapOf(
        1 to "ONE",
        2 to "TWO",
        3 to "THREE"
    )
    for ((k, v) in map)
        println("$k   ->   $v")
    val newMap = map.takeIf { it.size > 2 }
    newMap?.forEach { println(it) }
    @Language("JSON")
    val json = """
        {
          "age": 99,
          "friends": [
            " Joe",
            " joe"
          ],
          "isAlive": "Maybe",
          "name": "Joe"
        }
    """.trimIndent()
    json.reader()
        .readLines()
        .forEach { println(it) }
    // omg : |
    @Language("PostgreSQL")
    val sql = """
        select * from (select * from pg_catalog.pg_am) "pa*";
    """.trimIndent()

    @Language("TypeScript")
    val ts = """
        console.log("hello")
        const a = 111111111
        console.log(a)
    """.trimIndent()
}