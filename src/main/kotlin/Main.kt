import kotlin.random.Random

fun main() {
    var again: Boolean
    var game = 0
    do {
        game++
        println("Выберите сложность:")
        println("1 - очень просто: загаданное число от 1 до 10")
        println("2 - просто: загаданное число от 1 до 50")
        println("3 - стандартная сложность: загаданное число от 1 до 100")
        println("4 - сложно: загаданное число от 1 до 500")
        println("5 - очень сложно: загаданное число от 1 до 1000")
        println("6 - ваш выбор - вы сами указываете до какого числа загадывать")
        val choice = when (readLine()?.toIntOrNull() ?: 100) {
            1 -> 10
            2 -> 50
            3 -> 100
            4 -> 500
            5 -> 1000
            6 -> {
                println("Введите до какого числа загадываем")
                readLine()?.toIntOrNull() ?: 100
            }
            else -> {
                println("Что то не то ввели")
                100
            }
        }
        val number = Random.nextInt(1, choice + 1)
        println("Загадываем число от 1 до $choice")
        var n = 0
        var count = 0
        while (n != number) {
            println("Введите число")
            n = readLine()?.toIntOrNull() ?: continue
            count++
            if (n > number) println("Загаданное число меньше")
            if (n < number) println("Загаданное число больше")
        }
        if (count == 1) println("Вот это везение!!! Угаданно с первой попытки!")
        else println("Вы угадали! Загаданное число $number. Отгадано за $count ходов!")
        println("Играем еще раз?")
        println("1 - Да")
        println("2 - Нет")
        again = when (readLine()?.toIntOrNull() ?: false) {
            1 -> true
            else -> false
        }
    } while (again)
    println("Вы сыграли $game игр")
}
