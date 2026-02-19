// Задание 1
/*
fun greetUser(name: String) {
    println("Привет, $name!")
}

fun main() {
    greetUser("Анна")
    greetUser("Максим")
    greetUser("Елена")
}
 */

// Задание 2
/*
fun calculateCircleArea(radius: Double): Double {
    return Math.PI * radius * radius
}

fun main() {
    println("Радиус 5.0: ${calculateCircleArea(5.0)}")
    println("Радиус 10.0: ${calculateCircleArea(10.0)}")
    println("Радиус 2.5: ${calculateCircleArea(2.5)}")
}

 */

// Задание 3
/*
fun printPersonInfo(name: String, age: Int = 18, city: String = "Неизвестно") {
    println("Имя: $name, Возраст: $age, Город: $city")
}

fun main() {
    // 1. Со всеми параметрами
    printPersonInfo("Анна", 25, "Москва")

    // 2. Только с именем и возрастом
    printPersonInfo("Максим", 30)

    // 3. Только с именем
    printPersonInfo("Елена")
}

 */

// Задание 4
/*
fun main() {
    // Вызов с именованными аргументами в разном порядке
    printPersonInfo(city = "Санкт-Петербург", name = "Дмитрий", age = 28)
}

 */

// Задание 5
/*
fun calculateAverage(vararg numbers: Int): Double {
    if (numbers.isEmpty()) return 0.0
    return numbers.average()
}

fun main() {
    println("Среднее (1,2,3): ${calculateAverage(1, 2, 3)}")
    println("Среднее (10,20,30,40,50): ${calculateAverage(10, 20, 30, 40, 50)}")
    println("Среднее (5,5,5,5): ${calculateAverage(5, 5, 5, 5)}")
}
 */

// Задание 6
/*
// 1. Квадрат числа
fun square(x: Int): Int = x * x

// 2. Проверка на чётность
fun isEven(x: Int): Boolean = x % 2 == 0

// 3. Максимальное из двух чисел
fun maxOfTwo(a: Int, b: Int): Int = if (a > b) a else b

fun main() {
    println("Квадрат 5: ${square(5)}")
    println("4 чётное? ${isEven(4)}")
    println("Максимум из 3 и 7: ${maxOfTwo(3, 7)}")
}
 */

// Задание 7
/*
fun validatePassword(password: String): Boolean {
    fun isValidLength(): Boolean = password.length >= 8

    fun hasDigit(): Boolean = password.any { it.isDigit() }

    fun hasUpperCase(): Boolean = password.any { it.isUpperCase() }

    return isValidLength() && hasDigit() && hasUpperCase()
}

fun main() {
    println("Password123: ${validatePassword("Password123")}") // true
    println("pass: ${validatePassword("pass")}") // false
    println("PASSWORD123: ${validatePassword("PASSWORD123")}") // true
}
 */

// Задание 8
/*
// Для круга
fun calculateArea(radius: Double): Double {
    println("Круг: π * $radius²")
    return Math.PI * radius * radius
}

// Для прямоугольника
fun calculateArea(width: Double, height: Double): Double {
    println("Прямоугольник: $width * $height")
    return width * height
}

// Для треугольника
fun calculateArea(base: Double, height: Double): Double {
    println("Треугольник: ($base * $height) / 2")
    return (base * height) / 2
}

fun main() {
    println("Площадь круга: ${calculateArea(5.0)}")
    println("Площадь прямоугольника: ${calculateArea(4.0, 6.0)}")
    println("Площадь треугольника: ${calculateArea(3.0, 4.0)}")
}
 */

// Задание 9
/*
fun filterList(list: List<Int>, predicate: (Int) -> Boolean): List<Int> {
    return list.filter(predicate)
}

fun main() {
    val numbers = listOf(1, 5, 8, 12, 15, 20, 3, 7, 10)

    // 1. Только чётные числа
    val evenNumbers = filterList(numbers) { it % 2 == 0 }
    println("Чётные: $evenNumbers")

    // 2. Числа больше 10
    val greaterThan10 = filterList(numbers) { it > 10 }
    println("Больше 10: $greaterThan10")

    // 3. Числа в диапазоне от 5 до 15
    val inRange = filterList(numbers) { it in 5..15 }
    println("От 5 до 15: $inRange")
}
 */

// Задание 10
fun createCounter(start: Int): () -> Int {
    var count = start
    return {
        count++
    }
}

fun main() {
    val counter = createCounter(10)

    println(counter()) // 10
    println(counter()) // 11
    println(counter()) // 12
    println(counter()) // 13

    val anotherCounter = createCounter(100)
    println(anotherCounter()) // 100
    println(anotherCounter()) // 101
}