private class MenuItem(val name: String, val action: (() -> Unit)?)

class Menu(private val title: String, private val input: ConsoleInput) {
    private val items = mutableListOf<MenuItem>()

    fun addItem(name: String, action: () -> Unit) {
        items.add(MenuItem(name, action))
    }

    fun addBackItem(name: String) {
        items.add(MenuItem(name, null))
    }

    // Возвращает false, когда пользователь выбрал выход из этого меню.
    fun show(): Boolean {
        while (true) {
            println()
            println(title)
            for (index in items.indices) {
                println("$index. ${items[index].name}")
            }

            val answer = input.readLine() ?: return false
            val index = answer.toIntOrNull()

            if (index == null) {
                println("Введите цифру.")
            } else if (index !in items.indices) {
                println("Такой цифры нет в меню.")
            } else {
                val action = items[index].action ?: return false
                action()
                return true
            }
        }
    }
}
