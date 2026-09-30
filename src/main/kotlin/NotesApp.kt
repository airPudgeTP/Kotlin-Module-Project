class NotesApp {
    private val input = ConsoleInput()
    private val archives = mutableListOf<Archive>()

    fun run() {
        showArchives()
    }

    private fun showArchives() {
        while (true) {
            val menu = Menu("Список архивов:", input)
            menu.addItem("Создать архив") { createArchive() }
            for (archive in archives) {
                menu.addItem(archive.name) { showNotes(archive) }
            }
            menu.addBackItem("Выход")

            if (!menu.show()) return
        }
    }

    private fun createArchive() {
        println("Создание архива")
        val name = input.readRequiredText("Введите название архива") ?: return
        archives.add(Archive(name))
        println("Архив создан.")
    }

    private fun showNotes(archive: Archive) {
        while (true) {
            val menu = Menu("Заметки в архиве \"${archive.name}\":", input)
            menu.addItem("Создать заметку") { createNote(archive) }
            for (note in archive.notes) {
                menu.addItem(note.name) { showNote(note) }
            }
            menu.addBackItem("Назад к архивам")

            if (!menu.show()) return
        }
    }

    private fun createNote(archive: Archive) {
        println("Создание заметки")
        val name = input.readRequiredText("Введите название заметки") ?: return
        val text = input.readRequiredText("Введите текст заметки") ?: return
        archive.notes.add(Note(name, text))
        println("Заметка создана.")
    }

    private fun showNote(note: Note) {
        val menu = Menu("${note.name}\n${note.text}", input)
        menu.addBackItem("Назад к списку заметок")
        menu.show()
    }
}
