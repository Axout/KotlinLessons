package topics

/*
Nullable типы и Non-Null типы
Система типов в Kotlin нацелена на то, чтобы искоренить опасность обращения к null значениям,
более известную как "Ошибка на миллиард".

Самым распространённым подводным камнем многих языков программирования, в том числе Java,
является попытка произвести доступ к null значению. Это приводит к ошибке.
В Java такая ошибка называется NullPointerException (сокр. NPE).

В Kotlin NPE могут возникать только в случае:
 1. Явного указания throw NullPointerException();
 2. Использования оператора !! (описано ниже);
 3. Несоответствие данных в отношении инициализации, например, когда:
    - Неинициализированное this, доступное в конструкторе, передается и где-то используется ("утечка this");
    - Конструктор суперкласса вызывает open элемент,
      реализация которого в производном классе использует неинициализированное состояние.
 4. Эту ошибку вызвал внешний Java-код:
    - Попытка получить доступ к элементу null значения платформенного типа;
    - Проблемы с обнуляемостью при использовании обобщённых типов для взаимодействия с Java.
      Например, фрагмент кода Java может добавить null в Kotlin MutableList<String>,
      поэтому для работы с ним требуется MutableList<String?>;
    - Другие проблемы, вызванные внешним Java-кодом.

Система типов Kotlin различает ссылки на те, которые могут иметь значение null (nullable ссылки) и те,
которые таковыми быть не могут (non-null ссылки).
К примеру, переменная часто используемого типа String не может быть null.
 */

fun main() {
    var a: String = "Hello" // a - non-null переменная (NPE исключено)
    a.length // к переменной можно обратиться напрямую

    var b: String? = "Good morning" // b - nullable переменная (NPE возможно)
    b = null
    // b.length // к переменной уже нельзя обращаться напрямую
    // можно либо safe call (?.) или non-null asserted (!!.)

    // *** safe call ***
    // Если b == null, то вернёт null. Если b == "какое-то значение", то вернёт "какое-то значение".
    // Т.е. никакого NPE.
    println(b?.length) // null

    // Таким образом в цепочке вызовов, цепочка "обрывается" при первом null и возвращает null.
    // bob?.department?.head?.name -> null (если, например, department == null)

    // *** Elvis оператор ?: ***
    /*
    if (b == null)
        b = "Empty string"
    else
        b = b
     */
    val l = b?.length ?: -1

    // *** !! ***
    // !! - выбрасывает NPE, если в переменной null
    b = if ((0..10).random() > 5) "some string" else null
    println("Length of the string is ${b!!.length}")
}