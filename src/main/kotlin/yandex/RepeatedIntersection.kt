package yandex

/*
Даны два массива: [0, 1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]
Надо вернуть: [1, 2, 2, 3] (порядок неважен)
 */

fun main() {
    println(
        getRepeatedIntersection(intArrayOf(0, 1, 2, 3, 2, 0),
        intArrayOf(5, 1, 2, 7, 3, 2))
    )
}

fun getRepeatedIntersection(a1: IntArray, a2: IntArray): List<Int> {
    val s1 = a1.toHashSet() // В коллекцию HashSet не добавляются элементы, которые уже в ней присутствуют.
    val s2 = a2.toHashSet()

    val result = mutableListOf<Int>()

    for (el in s1) {
        if (s2.contains(el)) {
            val numberOfRepeat = minOf(a1.count { it == el }, a2.count { it == el })
            println("Number $el is repeated $numberOfRepeat times")
            repeat(numberOfRepeat) { result.add(el) }
        }
    }

    return result
}