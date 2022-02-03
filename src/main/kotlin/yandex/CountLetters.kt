package yandex

/*
AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB -> A4B3C2XZYD4E3F3A6B28
 */

fun main() {
    println(countLetters("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB"))
}

fun countLetters(str: String): String {
    var result = ""
    var count = 1
    var currentLetter = str[0]

    for (nextLetter in str.substring(1)) {
        if (currentLetter == nextLetter) {
            count++
        } else {
            if (count == 1)
                result += currentLetter
            else
                result += "$currentLetter$count"

            count = 1
            currentLetter = nextLetter
        }
    }

    // считаем последнюю букву
    if (count == 1)
        result += currentLetter
    else
        result += "$currentLetter$count"

    return result
}