package dev.dead.ch1ToCh5

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val credentials = Credentials("username", "password")
    println("Processing user...")
    processUser(credentials)
}

suspend fun processUser(credentials: Credentials) {
    println("Authenticating user...")
    val user = authenticate(credentials)

    coroutineScope {
        println("Loading user data and profile picture concurrently...")
        val dataDeferred = async { loadUserData(user) }
        val profilePictureDeferred = async { loadProfilePicture(dataDeferred.await()) }

        val data = dataDeferred.await()
        val profilePicture = profilePictureDeferred.await()

        println("User data loaded: ${data.name}")
        println("Profile picture loaded.")
    }
}

suspend fun authenticate(c: Credentials): User {
    delay(1000) // Simulate network delay
    return User("123", "Alice")
}

suspend fun loadUserData(u: User): Data {
    delay(1500) // Simulate network delay
    return Data(u.name, "456")
}

suspend fun loadProfilePicture(data: Data): Image {
    delay(2000) // Simulate network delay
    return Image(data.imageID)
}

data class Credentials(val username: String, val password: String)
data class User(val id: String, val name: String)
data class Data(val name: String, val imageID: String)
data class Image(val id: String)
