//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class InvalidMenuChoiceException(message: String) : Exception(message)

fun main() {

    val names: List<String?> = listOf("Піца", "Бургер", "Суші", "Салат", "Картопля фрі")
    val prices: List<Int> = listOf(150, 120, 200, 100, 80)

    var total = 0
    var choice: Int

    println("=== МЕНЮ ===")
    for (i in names.indices) {
        println("${i + 1}. ${names[i]} — ${prices[i]} грн")
    }
    println("Введіть номер страви (1-5), або 0 щоб завершити:")

    do {
        try {
            print("Ваш вибір: ")
            choice = readln().toInt()

            if (choice == 0) break

            if (choice in 1..5) {
                val index = choice - 1
                val name = names[index]
                val price = prices[index]
                total += price
                println("Додано: $name за $price грн. Загальна сума: $total грн")
            } else {
                throw InvalidMenuChoiceException("Невірний вибір меню: $choice")
            }

        } catch (e: InvalidMenuChoiceException) {
            println("Помилка: ${e.message}")
        } catch (e: NumberFormatException) {
            println("Введіть, будь ласка, число.")
            choice = -1
        }
    } while (true)


    var discount = 0.0
    if (total >= 500) {
        discount = 0.15
    } else if (total >= 200) {
        discount = 0.10
    }

    val finalTotal = total - (total * discount)

    println("=== ПІДСУМОК ===")
    println("Сума до знижки: $total грн")
    println("Знижка: ${discount * 100}%")
    println("Сума до оплати: ${"%.2f".format(finalTotal)} грн")
}