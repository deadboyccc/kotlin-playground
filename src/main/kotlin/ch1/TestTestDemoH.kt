package dev.dead.ch1ToCh5

class TestTestDemoH {
    fun returnHelloString(): String ="hello"
    fun main(){
        println(returnHelloString())
        val hashMap = hashMapOf<String, Int>()
        hashMap["one"] = 1
        hashMap["two"] = 2
        hashMap["three"] = 3
        println(hashMap)
        for ((key, value) in hashMap) {
            println("$key -> $value")
        }
        main()


    }

}