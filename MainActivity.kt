//Задание 1
class Book(val title: String, val author: String, var year: Int, var price: Int)

//Задание 2
class Student(val name: String, val surname: String, var group: String) {

    var fullName = ""

    init {
        fullName = "$name $surname"
        println("Создан студент: $fullName, группа: $group")
    }
}

//Задание 3
class BankAccount(initialBalance: Int) {

    var balance: String = "$initialBalance"
        set(value) {
            val newVal = value.toIntOrNull()
            // Проверка: если число валидно и не отрицательное
            if (newVal != null && newVal >= 0) {
                field = value
            } else {
                println("Ошибка: баланс не может быть отрицательным!")
            }
        }
        get() = "Баланс: $field ₽"
}

//4
enum class OrderStatus(val description: String) {
    NEW("Новый заказ"),
    PROCESSING("Заказ в обработке"),
    SHIPPED("Отправлен"),
    DELIVERED("Доставлен"),
    CANCELLED("Отменён");


    fun isFinished(): Boolean = this == DELIVERED || this == CANCELLED
}

//Задание 5
// Часть А
data class Product(val id: Int, val name: String, var price: Int, var inStock: Boolean)

// Часть Б
object ProductCatalog {

    private val _products = mutableListOf<Product>()


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
    println("--- Задание 1: Книги ---")
    val book1 = Book("Война и мир", "Лев Толстой", 1869, 1200)
    val book2 = Book("Преступление и наказание", "Ф. Достоевский", 1866, 900)
    val book3 = Book("1984", "Джордж Оруэлл", 1949, 850)


    book1.price = 1500

    println("Книга: ${book1.title}, Автор: ${book1.author}, Год: ${book1.year}, Цена: ${book1.price}₽")
    println("Книга: ${book2.title}, Автор: ${book2.author}, Год: ${book2.year}, Цена: ${book2.price}₽")
    println("Книга: ${book3.title}, Автор: ${book3.author}, Год: ${book3.year}, Цена: ${book3.price}₽")
    println()

    println("--- Задание 2: Студенты ---")
    val student1 = Student("Иван", "Петров", "ИС-21")
    val student2 = Student("Анна", "Смирнова", "БИ-32")
    println(student1.fullName)
    println(student2.fullName)
    println()

    println("--- Задание 3: Банковский счет ---")
    val account = BankAccount(1000)
    println(account.balance)

    account.balance = "-500"


    account.balance = "2000"
    println(account.balance)
    println()

    println("--- Задание 4: Статусы заказа ---")

    for (status in OrderStatus.values()) {
        println("${status.name} - ${status.description}")
    }


    print("Завершённые статусы: ")
    val finishedStatuses = OrderStatus.values().filter { it.isFinished() }
    println(finishedStatuses.joinToString { it.name })
    println()

    println("--- Задание 5: Товары и Каталог ---")
    // Часть А
    val product1 = Product(1, "Ноутбук", 50000, true)
    val product2 = Product(1, "Ноутбук", 50000, true)

    println("Сравнение товаров (==): ${product1 == product2}") // true, так как data class сравнивает поля

    val productCopy = product1.copy(price = 45000)
    println("Оригинал: $product1")
    println("Копия: $productCopy")

    // Часть Б
    ProductCatalog.addProduct(product1)
    ProductCatalog.addProduct(Product(2, "Мышка", 1500, true))
    ProductCatalog.addProduct(Product(3, "Клавиатура", 3000, false))

    println("Все товары в каталоге:")
    ProductCatalog.products.forEach { println(it) }

    val foundProduct = ProductCatalog.findById(2)
    println("Найденный товар по ID 2: $foundProduct")
}