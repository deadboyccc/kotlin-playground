package dev.dead

class TestTestDemoH {
    fun returnHelloString(): String ="hello"
    fun main(){
        println(returnHelloString())
        val hashMap = hashMapOf<String, Int>()
        hashMap.put("one", 1)
        hashMap.put("two", 2)
        hashMap.put("three", 3)
        println(hashMap)
        for ((key, value) in hashMap) {
            println("$key -> $value")
        }
        main()


    }

}