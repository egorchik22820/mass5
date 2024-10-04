fun main() {
    //заполняем массив
    val words: MutableList<String> = mutableListOf()
    var word = ""
    while (word != "stop") {
        println("введите слово, введите \"stop\", когда закончите ввод")
        word = readln()
        words.add(word)
    }
    words.removeLast()

    //создаем массив ключей
    val  keys: MutableSet<String> = mutableSetOf()
    for (i in 0 until words.size) {
        keys.add(words[i].toCharArray().sorted().joinToString(""))
    }

    //создаем мап
    val map: MutableMap<String, MutableSet<String>> = mutableMapOf()

    //сравниваем ключи и слова и кладем их в мап
    for (key in keys) {
        for (word in words) {
            if (key == word.toCharArray().sorted().joinToString("")) {
                map.getOrPut(key) { mutableSetOf() }.add(word)
            }
        }
    }

    //распечатываем
    for ((key, word) in map) {
        print("$key:\t\t$word\n")
    }

}