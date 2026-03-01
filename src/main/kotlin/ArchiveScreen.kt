import java.util.Scanner

fun runArchiveMenu(appState: AppState) {
    while (true) {
        val items = mutableListOf<MenuItem>()
        items.add(MenuItem("Создать архив") {
            createArchive(appState)
            MenuActions.STAY
        })
        appState.archives.forEach { archive ->
            items.add(MenuItem(archive.name) {
                notesMenu(archive)
                MenuActions.STAY
            })
        }
        items.add(MenuItem("Выход") { MenuActions.EXIT })
        val menu = Menu("Список архивов:", items)
        val result = menu.run()
        if (result == MenuActions.EXIT) return
    }
}

private fun createArchive(appState: AppState) {
    val scanner = Scanner(System.`in`)
    while (true) {
        println("Введите имя архива:")
        val name = scanner.nextLine().trim()
        if (name.isEmpty()) {
            println("Имя архива не может быть пустым")
            continue
        }
        appState.archives.add(Archive(name, mutableListOf()))
        println("Архив \"$name\" создан.")
        return
    }
}
