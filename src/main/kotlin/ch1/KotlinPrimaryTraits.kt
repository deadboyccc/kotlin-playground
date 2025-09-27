package dev.dead.ch1ToCh5


fun main() {
    val i = 10;
    val ii: Int = i;
    val messages = listOf(
        Message(
            body = "Hey, what's up?",
            isRead = true,
            sender = Sender(
                id = 1,
                name = "Alice"
            )
        ),
        Message(
            body = "Are you coming to the party?",
            isRead = false,
            sender = Sender(
                id = 2,
                name = "Bob"
            )
        ),
        Message(
            body = "",
            isRead = false,
            sender = Sender(
                id = 1,
                name = "Alice"
            )
        ),
        Message(
            body = "Let's grab coffee tomorrow.",
            isRead = false,
            sender = Sender(
                id = 3,
                name = "Charlie"
            )
        ),
        Message(
            body = "Don't forget the deadline!",
            isRead = false,
            sender = Sender(
                id = 2,
                name = "Bob"
            )
        ),
        Message(
            body = "See you later.",
            isRead = true,
            sender = Sender(
                id = 4,
                name = "David"
            )
        )
    )

    val unreadSenders = messages
        .filter { it.body.isNotBlank() && !it.isRead }
        .map(Message::sender)
        .distinct()
        .sortedBy(Sender::name)

    println("Senders with unread messages:")
    unreadSenders.forEach { println(it.name) }
}

data class Message(
    val body: String,
    val isRead: Boolean,
    val sender: Sender
)

data class Sender(
    val id: Int,
    val name: String
)
