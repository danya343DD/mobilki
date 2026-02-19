// Задание 1
/*
class Book(val title: String, val author: String, var year: Int, var price: Int)

fun main() {
    // 1. Создаем три объекта
    val book1 = Book("Война и мир", "Лев Толстой", 1869, 1200)
    val book2 = Book("Преступление и наказание", "Ф.М. Достоевский", 1866, 900)
    val book3 = Book("Мастер и Маргарита", "Михаил Булгаков", 1967, 1500)

    // 2. Изменяем цену у одной из книг
    book2.price = 1100

    // 3. Выводим информацию
    println("Книга: ${book1.title}, Автор: ${book1.author}, Год: ${book1.year}, Цена: ${book1.price}₽")
    println("Книга: ${book2.title}, Автор: ${book2.author}, Год: ${book2.year}, Цена: ${book2.price}₽")
    println("Книга: ${book3.title}, Автор: ${book3.author}, Год: ${book3.year}, Цена: ${book3.price}₽")
}
 */

// Задание 2
/*
class Student(val name: String, val surname: String, var group: String) {
    // Свойство, вычисляемое в init
    val fullName: String

    init {
        fullName = "$name $surname"
        println("Создан студент: $fullName, группа: $group")
    }
}

fun main() {
    val student1 = Student("Иван", "Петров", "ИС-21")
    val student2 = Student("Анна", "Смирнова", "БИ-32")

    println(student1.fullName)
    println(student2.fullName)
}
 */

// Задание 3
/*
class BankAccount(initialBalance: Int) {
    var balance: Int = initialBalance
        set(value) {
            if (value < 0) {
                println("Ошибка: баланс не может быть отрицательным!")
                // Поле не обновляется
            } else {
                field = value
            }
        }

    // Метод, выполняющий роль "геттера, возвращающего строку"
    fun getBalanceInfo(): String {
        return "Баланс: $balance ₽"
    }
}

fun main() {
    val account = BankAccount(1000)

    // 4. Выводим текущий баланс
    println(account.getBalanceInfo())

    // 2. Пробуем установить -500
    account.balance = -500

    // 3. Пробуем установить 2000
    account.balance = 2000

    // 4. Выводим итоговый баланс
    println(account.getBalanceInfo())
}
 */

// Задание 4
/*
enum class OrderStatus(val description: String) {
    NEW("Новый заказ"),
    PROCESSING("Заказ в обработке"),
    SHIPPED("Отправлен"),
    DELIVERED("Доставлен"),
    CANCELLED("Отменён");

    fun isFinished(): Boolean {
        return this == DELIVERED || this == CANCELLED
    }
}

fun main() {
    // 1. Выводим все статусы
    for (status in OrderStatus.values()) {
        println("${status.name} - ${status.description}")
    }

    println("\nЗавершённые статусы:")
    // 2. Проверяем завершённые
    val finishedStatuses = OrderStatus.values().filter { it.isFinished() }
    // Выводим через запятую
    println(finishedStatuses.joinToString(", ") { it.name })
}
 */

// Задание 5
// Часть А: Data class
data class Product(val id: Int, val name: String, var price: Double, var inStock: Boolean)

// Часть Б: Object declaration (Синглтон)
object ProductCatalog {
    private val _products = mutableListOf<Product>()

    // Публичный геттер возвращает неизменяемый список
    val products: List<Product>
        get() = _products.toList()

    fun addProduct(product: Product) {
        _products.add(product)
    }

    fun findById(id: Int): Product? {
        return _products.find { it.id == id }
    }
}

fun main() {
    // --- Часть А ---
    println("--- Часть А: Data Class ---")
    val product1 = Product(1, "Ноутбук", 50000.0, true)
    val product2 = Product(1, "Ноутбук", 50000.0, true) // Такие же данные

    println("Сравнение product1 == product2: ${product1 == product2}") // true (data class сравнивает содержимое)

    val productCopy = product1.copy(price = 45000.0)
    println("Оригинал: $product1")
    println("Копия: $productCopy")

    // --- Часть Б ---
    println("\n--- Часть Б: Object Catalog ---")
    val p1 = Product(101, "Телефон", 30000.0, true)
    val p2 = Product(102, "Планшет", 20000.0, false)

    ProductCatalog.addProduct(p1)
    ProductCatalog.addProduct(p2)

    println("Все товары в каталоге:")
    ProductCatalog.products.forEach { println(it) }

    println("\nПоиск товара по ID 102:")
    val found = ProductCatalog.findById(102)
    if (found != null) {
        println("Найден: $found")
    } else {
        println("Товар не найден")
    }
}
