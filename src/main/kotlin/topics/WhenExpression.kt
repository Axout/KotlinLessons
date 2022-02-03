package topics

fun main() {
    testWhen(1)
    testWhen("hello")
    testWhen(15)
}

// Any - базовый класс, похож на Object из Java
// when - условный оператор, похож на switch

fun testWhen(input: Any) {
    when (input) {
        1 -> println("Единица")
        2 -> println("Двойка")
        in 10..20 -> println("от 10 до 20")
        is String -> println("Была введена строка ${input.length}") // авто downcast
        else -> println("Что-то ещё")
    }
}
