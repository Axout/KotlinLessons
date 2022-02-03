package topics

fun main() {
    println(returnOneValue()) // 10
    println(returnOneValueWithArgs(3, 10)) // 13
    println(10) // 10
    println(testNamedArgs(y = 4, z = 2, x = 5)) // [5, 4, 2]

    testDefaultArgs() // 3
    testDefaultArgs(y = 1) // 2
    testDefaultArgs(x = -4, y = 5) // 1

    printEven(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) // 2 4 6 8 10
    printEven(*intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), 9, 10) // 2 4 6 8 10
}

/*
fun returnOneValue(): Int {
    return 5 + 5
}
данную функцию можно заменить на:
 */
fun returnOneValue() = 5 + 5

fun returnOneValueWithArgs(x: Int, y: Int) = x + y

// для лучшей читабельности лучше всегда указывать тип возвращаемого значения
fun testString(x: Int): String {
    return "Stirng is $x"
}

// именованные аргументы
fun testNamedArgs(x: Int, y: Int, z: Int): List<Int> {
    return listOf(x, y, z)
}

// аргументы по умолчанию - хорошая альтернатива перегрузки методов
fun testDefaultArgs(x: Int = 1, y: Int = 2) {
    println(x + y)
}

// vararg - для передачи списка аргументов через запятую
// вместо fun printEven(list: List<Int>)
fun printEven(vararg numbers: Int) {
    numbers.forEach { e -> if (e % 2 == 0) println(e) }
}