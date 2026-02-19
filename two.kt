import kotlin.random.Random
import kotlin.math.sqrt

// Задание 1
/*
fun main() {
    print("Введите начальное число: ")
    val start = readLine()!!.toInt()

    print("Введите конечное число: ")
    val end = readLine()!!.toInt()

    println("Числа, делящиеся на 3:")
    for (i in start..end step 2) {
        if (i % 3 == 0) {
            println(i)
        }
    }
}

 */

// Задание 2
/*
fun main() {
    val array = IntArray(10) { Random.nextInt(1, 101) }

    println("Массив: ${array.joinToString()}")

    val max = array.max()
    val min = array.min()
    val average = array.average()
    val evenCount = array.count { it % 2 == 0 }

    println("Максимальный элемент: $max")
    println("Минимальный элемент: $min")
    println("Среднее арифметическое: $average")
    println("Количество чётных чисел: $evenCount")
}

 */

// Задание 3
/*
fun main() {
    print("Введите целое число: ")
    val number = readLine()!!.toInt()

    print("Введите систему счисления (2, 8, 16): ")
    val base = readLine()!!.toInt()

    var num = kotlin.math.abs(number)
    var result = ""

    if (num == 0) {
        result = "0"
    } else {
        while (num > 0) {
            val remainder = num % base
            val digit = when {
                remainder < 10 -> remainder.toString()
                else -> (65 + remainder - 10).toChar().toString()
            }
            result = digit + result
            num /= base
        }
    }

    if (number < 0) {
        result = "-" + result
    }

    println("Результат: $result")
}

 */

// Задание 4
/*
fun main() {
    println("Простые числа от 2 до 100:")

    for (num in 2..100) {
        var isPrime = true
        val limit = sqrt(num.toDouble()).toInt()

        for (divisor in 2..limit) {
            if (num % divisor == 0) {
                isPrime = false
                break
            }
        }

        if (isPrime) {
            print("$num ")
        }
    }
}
 */

// Задание 5
/*
fun main() {
    print("Введите строку: ")
    val input = readLine()!!
    val shift = 3
    var encrypted = ""

    for (char in input) {
        encrypted += when {
            char in 'a'..'z' -> {
                val shifted = ((char - 'a' + shift) % 26) + 'a'
                shifted
            }
            char in 'A'..'Z' -> {
                val shifted = ((char - 'A' + shift) % 26) + 'A'
                shifted
            }
            char in 'а'..'я' -> {
                val shifted = ((char - 'а' + shift) % 32) + 'а'
                shifted
            }
            char in 'А'..'Я' -> {
                val shifted = ((char - 'А' + shift) % 32) + 'А'
                shifted
            }
            else -> char
        }
    }

    println("Зашифрованная строка: $encrypted")
}

 */

// Задание 6
/*
fun main() {
    println("Введите текст (пустая строка для завершения):")
    val lines = mutableListOf<String>()

    while (true) {
        val line = readLine()!!
        if (line.isEmpty()) break
        lines.add(line)
    }

    val text = lines.joinToString(" ")

    val charCount = text.length
    val wordCount = text.split("\\s+".toRegex()).filter { it.isNotEmpty() }.size
    val sentenceCount = text.count { it in ".!?" }

    val words = text.split("\\s+".toRegex()).filter { it.isNotEmpty() }
    val longestWord = words.maxByOrNull { it.length } ?: ""

    println("\nСтатистика:")
    println("Количество символов: $charCount")
    println("Количество слов: $wordCount")
    println("Количество предложений: $sentenceCount")
    println("Самое длинное слово: $longestWord (длина: ${longestWord.length})")
}

 */

// Задание 7
/*
fun main() {
    val numberToGuess = Random.nextInt(1, 101)
    var attempts = 0
    var userGuess: Int

    println("Я загадал число от 1 до 100. Попробуйте угадать!")

    do {
        print("Ваша попытка: ")
        userGuess = readLine()!!.toInt()
        attempts++

        when {
            userGuess < numberToGuess -> println("Больше!")
            userGuess > numberToGuess -> println("Меньше!")
            else -> println("Поздравляю! Вы угадали число $numberToGuess за $attempts попыток!")
        }
    } while (userGuess != numberToGuess)
}
 */

// Задание 8
/*
fun main() {
    val matrix = Array(3) { IntArray(3) { Random.nextInt(1, 10) } }

    println("Матрица:")
    for (row in matrix) {
        println(row.joinToString(" "))
    }

    // Сумма элементов каждой строки
    for (i in matrix.indices) {
        val rowSum = matrix[i].sum()
        println("Сумма строки ${i + 1}: $rowSum")
    }

    // Сумма элементов каждого столбца
    for (j in 0 until 3) {
        var colSum = 0
        for (i in 0 until 3) {
            colSum += matrix[i][j]
        }
        println("Сумма столбца ${j + 1}: $colSum")
    }

    // Сумма главной диагонали
    var diagonalSum = 0
    for (i in 0 until 3) {
        diagonalSum += matrix[i][i]
    }
    println("Сумма главной диагонали: $diagonalSum")
}

 */

// Задание 9
/*
fun main() {
    print("Введите количество чисел Фибоначчи N: ")
    val n = readLine()!!.toInt()

    var a = 0
    var b = 1

    println("Числа Фибоначчи, соответствующие условиям:")

    for (i in 0 until n) {
        val fib = a

        if (fib % 2 == 0 || (fib > 50 && fib < 200)) {
            println(fib)
        } else {
            // continue для пропуска
            a = b
            b = fib + b
            continue
        }

        a = b
        b = fib + b
    }
}
 */

// Задание 10
/*
fun main() {
    print("Введите пароль: ")
    val password = readLine()!!

    val errors = mutableListOf<String>()

    if (password.length < 8) {
        errors.add("Пароль должен содержать минимум 8 символов")
    }

    if (!password.any { it.isDigit() }) {
        errors.add("Пароль должен содержать хотя бы одну цифру")
    }

    if (!password.any { it.isUpperCase() }) {
        errors.add("Пароль должен содержать хотя бы одну заглавную букву")
    }

    val specialChars = "!@#\$%^&*"
    if (!password.any { it in specialChars }) {
        errors.add("Пароль должен содержать хотя бы один специальный символ (!@#\$%^&*)")
    }

    if (errors.isEmpty()) {
        println("Пароль надёжный!")
    } else {
        println("Ошибки:")
        errors.forEach { println("- $it") }
    }
}

 */

// Задание 11
/*
fun main() {
    var running = true

    while (running) {
        println("\n=== Конвертер времени ===")
        println("1. Секунды в часы:минуты:секунды")
        println("2. Часы и минуты в секунды")
        println("3. Выход")
        print("Выберите опцию: ")

        val choice = readLine()!!.toInt()

        when (choice) {
            1 -> {
                print("Введите секунды: ")
                val totalSeconds = readLine()!!.toInt()

                val hours = totalSeconds / 3600
                val minutes = (totalSeconds % 3600) / 60
                val seconds = totalSeconds % 60

                println("Результат: ${hours}ч ${minutes}м ${seconds}с")
            }
            2 -> {
                print("Введите часы: ")
                val hours = readLine()!!.toInt()
                print("Введите минуты: ")
                val minutes = readLine()!!.toInt()

                val totalSeconds = hours * 3600 + minutes * 60
                println("Результат: $totalSeconds секунд")
            }
            3 -> {
                println("Выход из программы")
                running = false
            }
            else -> println("Неверный выбор")
        }
    }
}

 */

// Задание 12
fun main() {
    print("Введите выражение (например: 12 + 34 - 5 * 2 / 4): ")
    val expression = readLine()!!

    try {
        val result = evaluateExpression(expression)
        println("Результат: $result")
    } catch (e: Exception) {
        println("Ошибка: ${e.message}")
    }
}

fun evaluateExpression(expression: String): Double {
    val tokens = tokenize(expression)
    println("Токены: $tokens")

    val values = mutableListOf<Double>()
    val operators = mutableListOf<Char>()

    var i = 0
    while (i < tokens.size) {
        val token = tokens[i]

        when {
            token.all { it.isDigit() || it == '.' } -> {
                values.add(token.toDouble())
            }
            token in "+-*/" -> {
                while (operators.isNotEmpty() &&
                    hasHigherOrEqualPrecedence(operators.last(), token[0])) {
                    applyOperation(values, operators.removeAt(operators.size - 1))
                }
                operators.add(token[0])
            }
        }
        i++
    }

    while (operators.isNotEmpty()) {
        applyOperation(values, operators.removeAt(operators.size - 1))
    }

    return values[0]
}

fun tokenize(expression: String): List<String> {
    val tokens = mutableListOf<String>()
    var currentNumber = ""

    for (char in expression.replace(" ", "")) {
        when {
            char.isDigit() || char == '.' -> {
                currentNumber += char
            }
            char in "+-*/" -> {
                if (currentNumber.isNotEmpty()) {
                    tokens.add(currentNumber)
                    currentNumber = ""
                }
                tokens.add(char.toString())
            }
        }
    }

    if (currentNumber.isNotEmpty()) {
        tokens.add(currentNumber)
    }

    return tokens
}

fun hasHigherOrEqualPrecedence(op1: Char, op2: Char): Boolean {
    val precedence = mapOf('+' to 1, '-' to 1, '*' to 2, '/' to 2)
    return (precedence[op1] ?: 0) >= (precedence[op2] ?: 0)
}

fun applyOperation(values: MutableList<Double>, operator: Char) {
    if (values.size < 2) throw Exception("Недостаточно операндов")

    val b = values.removeAt(values.size - 1)
    val a = values.removeAt(values.size - 1)

    val result = when (operator) {
        '+' -> {
            println("Промежуточный результат: $a + $b = ${a + b}")
            a + b
        }
        '-' -> {
            println("Промежуточный результат: $a - $b = ${a - b}")
            a - b
        }
        '*' -> {
            println("Промежуточный результат: $a * $b = ${a * b}")
            a * b
        }
        '/' -> {
            if (b == 0.0) throw Exception("Деление на ноль")
            println("Промежуточный результат: $a / $b = ${a / b}")
            a / b
        }
        else -> throw Exception("Неизвестный оператор: $operator")
    }

    values.add(result)
}
