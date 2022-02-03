package topics

fun main() {

    // *** Изменяемые и неизменяемые переменные ***

    val test1: String = "Hello"
    // test1 = "Goodbye" - ошибка

    var test2: String = "Hello"
    test2 = "Goodbye"

    var test3 = "Hello"
    // test3 = 123 - ошибка

    // *** Конкатенация строк ***

    val a = 3
    val b = 5

    println("a + b = ${a + b}")
    println("2 + 2 = ${2 + 2}")

}