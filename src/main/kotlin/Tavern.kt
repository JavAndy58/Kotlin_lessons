import java.io.File

private const val TAVERN_MASTER = "Taernyl"
private const val TAVERN_NAME = "$TAVERN_MASTER's Folly"
private val firstNames = setOf("Alex", "Mordoc", "Sophie", "Tariq")
private val lastNames = setOf("Ironfoot", "Fernsworth", "Baggins", "Downstrider")
private val menuDate = File("data/tavern-menu-data.txt")
    .readText()
    .split("\n")
private val menuItems = List(menuDate.size) {index ->
    val ( _ , name , _ ) = menuDate[index].split(",")
    name
}

fun visitTavern() {
    narrate("$heroName enters $TAVERN_NAME")
    narrate("There are several items for sale:")
    narrate(menuItems.joinToString())
    val patrons: MutableSet<String> = mutableSetOf()
    repeat(10) {
        patrons += "${firstNames.random()} ${lastNames.random()}"
    }

    narrate("$heroName sees several patrons in the tavern:")
    narrate(patrons.joinToString())
    repeat(3) {
        placeOrder(patrons.random(), menuItems.random())
    }

//    patrons.forEach{patron ->
//        println("Good evening, $patron")
//    }
//    patrons.forEachIndexed() { i, patron ->
//        println("Good evening, $patron - you're #${i + 1} in line")
//        placeOrder(patron, menuItems.random())
//    }
//
//    menuDate.forEachIndexed { index, data ->
//        println("$index : $data")
//    }
}
private fun placeOrder(patronName: String, menuItemName: String) {
    narrate("$patronName speaks with $TAVERN_MASTER to place an order")
    narrate("$TAVERN_MASTER hands $patronName a $menuItemName")
}