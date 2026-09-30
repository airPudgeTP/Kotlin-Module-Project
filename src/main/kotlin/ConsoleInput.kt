import java.util.Scanner

class ConsoleInput {
    private val scanner = Scanner(System.`in`)

    fun readLine(): String? {
        return if (scanner.hasNextLine()) scanner.nextLine() else null
    }

    fun readRequiredText(message: String): String? {
        while (true) {
            println("$message (0 — назад):")
            val answer = readLine() ?: return null

            if (answer == "0") return null
            if (answer.isBlank()) {
                println("Поле не может быть пустым. Попробуйте ещё раз.")
            } else {
                return answer.trim()
            }
        }
    }
}
