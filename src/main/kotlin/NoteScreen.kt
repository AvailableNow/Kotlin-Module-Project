import java.util.Scanner

fun notesMenu(archive: Archive) {
    while (true) {
        val items = mutableListOf<MenuItem>()
        items.add(MenuItem("Создать заметку") {
            createNote(archive)
            MenuActions.STAY
        })
        archive.notes.forEach { note ->
            items.add(MenuItem(note.title) {
                viewNote(note)
                MenuActions.STAY
            })
        }
        items.add(MenuItem("Выход") { MenuActions.BACK })
        val menu = Menu("Список заметок:", items)
        val result = menu.run()
        if (result == MenuActions.BACK) return
    }
}

private fun createNote(archive: Archive) {
    val scanner = Scanner(System.`in`)
    var name: String
    while (true) {
        println("Введите имя заметки:")
        name = scanner.nextLine().trim()
        if (name.isEmpty()) {
            println("Имя заметки не может быть пустым")
            continue
        }
        break
    }
    var text: String
    while (true) {
        println("Введите текст заметки:")
        text = scanner.nextLine().trim()
        if (text.isEmpty()) {
            println("Текст заметки не может быть пустым")
            continue
        }
        break
    }
    archive.notes.add(Note(name, text))
    println("Заметка \"$name\" создана.")
}

private fun viewNote(note: Note) {
    println("\n${note.text}\n")
    val menu = Menu("", mutableListOf(MenuItem("Выход") { MenuActions.BACK }))
    menu.run()
}
