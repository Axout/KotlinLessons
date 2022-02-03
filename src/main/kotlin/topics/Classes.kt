package topics

fun main() {
    val child = Person("Ivan", "Pakrovskiy", 5) // вызов первичного конструктора
    val dad = Person("Maks", "Pakrovskiy", 35, child) // вызов вторичного конструктора
    println(dad.firstName)

    val rectangle1 = Rectangle(5.0, 2.0)
    println("The perimeter is ${rectangle1.perimeter}")

    val rectangle2 = Rectangle(5.0, 2.0)
    println("The perimeter is ${rectangle1.perimeter}")
    println(rectangle1 == rectangle2) // true. Если не data class, то было бы false.
}

// Первичный конструктор (Primary Constructor)
class Person(val firstName: String, val lastName: String, var age: Int) {
    var children: MutableList<Person> = mutableListOf() // это обычный ArrayList из Java

    // т.к. в первичном конструкторе нет места для кода, вызываемого при создании объекта,
    // то данный код можно разместить в блоке init { .. },
    // который выполняется уже после первичного конструктора (после назначения полей)
    init {
        println("Person is created $firstName")
    }

    // Вторичный конструктор - всегда должен в себе вызывать первичный конструктор.
    // Похоже на перегрузку конструкторов в Java.
    // Ключевое слово this вызывает первичный конструктор и передаёт в него аргументы, приходящие во вторичный конструктор.
    constructor(firstName: String, lastName: String, age: Int, child: Person):
            this(firstName, lastName, age) {
        children.add(child)
    }

    // Конструктор без аргументов
    constructor(): this("", "", -1)
}

// наличие слова data автомат.создаёт методы: equals(), hashCode(), toString() и д.р. (no boilerplate code)
data class Rectangle(var height: Double, var length: Double) {
    // поля класса
    var perimeter = (height + length) * 2

    // геттер и сеттер поля test класса Rectangle
    var test = 1
        get() = field + 1 // field - тоже самое, что и this.поле в Java
        set(value) {
            if (value < 0) println("Negative value")
            field = value
        }

    // метод класса
    fun area() = height * length
}