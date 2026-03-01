class Menu(val title: String, val items: MutableList<MenuItem>) {

    private fun printMenu(){
        println(title)
        for (index in items.indices){
            println("$index. ${items[index].title}")
        }
    }

    fun run(): MenuActions {
        while (true){
            printMenu()
            val input = readln().toIntOrNull()
            if (input == null){
                println("Следует вводить цифру")
                continue
            }
            if (input !in items.indices){
                println("Такой цифры нет")
                continue
            }
            val action = items[input].onSelect()
            return action
        }
    }
}

enum class MenuActions{
    STAY,
    BACK,
    EXIT
}
data class MenuItem(
    val title: String,
    val onSelect: () -> MenuActions
)