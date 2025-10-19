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
}
