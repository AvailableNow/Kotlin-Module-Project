class Note(val title: String, val text: String) {
}

class Archive(val name: String, val notes: MutableList<Note> = mutableListOf()) {
}

class AppState {
    val archives = mutableListOf<Archive>()
}