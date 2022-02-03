package topics

fun main() {
    val a = listOf(1,2,3,4,5)

    a.forEach { e -> println(e) }
    a.map { e -> e * 2}
    a.filter { e -> e % 2 == 0 }
    a.reduce { sum, e -> sum + e } // sum()

    a.sortedByDescending { it } // если бы был список объектов, то мы могли бы у объекта вызвать геттер и сортировать по какому-либо полю, например, it.name

    a.any { it > 10 } // возвращает true, если в коллекции есть хотя бы один элемент, удовлетворяющих условию.
    a.all { it < 10 } // возвращает true, если в коллекции все элементы удовлетворяют условию.
    a.sum()

    // .partition { .. } - разделяет на два списка по условию
    val numbers = listOf(1, 3, 4, 2, -11)
    val (positive, negative) = numbers.partition { it > 0 }
    println(positive)
    println(negative)

    // .groupBy { .. } - группировка по условию
    val result = listOf("a", "b", "ba", "ccc", "ad").groupBy { it.length }
    println(result) // HashMap или LinkedHashMap
}