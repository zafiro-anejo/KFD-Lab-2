fun main() {
    data class FirstTemplate(
        val firstField: String,
        val secondField: Int,
        val thirdField: Double,
        val fourthField: Boolean,
    )


    val firstX = FirstTemplate("String", 10, 10.5, true)
    val firstY = TomlSerialization.encodeToString(firstX)
    println("TOML serialized:")
    println(firstY)

    val firstZ = TomlSerialization.decodeFromString<FirstTemplate>(firstY)
    println("TOML deserialized: $firstZ")

    data class SecondTemplate(
        val firstField: String,
        val secondField: List<String>,
        val thirdField: List<Int>
    )

    val secondX = SecondTemplate("title", listOf("one", "two", "three"), listOf(3, 5))
    val secondY = TomlSerialization.encodeToString(secondX)
    println("TOML serialized:")
    println(secondY)

    try {
        val secondZ = TomlSerialization.decodeFromString<SecondTemplate>(secondY)
        println("TOML deserialized: $secondZ")
    } catch (e: Exception) {
        println("Ошибка: ${e.message}")
    }

    data class Person(val name: String, val age: Int, val contacts: List<String>)
    data class Database(val host: String, val port: Int)
    data class Config(val database: Database, val users: List<Person>)


    val thirdX = Config(
        database = Database("host", 8080),
        users = listOf(
            Person("firstPerson", 20, listOf("firstPerson@email.ru")),
            Person("secondPerson", 70, listOf("secondPerson@email.ru", "secondPerson@gmail.com"))
        )
    )

    val thirdY = TomlSerialization.encodeToString(thirdX)
    println(thirdY)
}
