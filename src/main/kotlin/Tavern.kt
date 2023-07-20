import java.io.File

private const val TAVERN_MASTER = "Taernyl"
private const val TAVERN_NAME = "$TAVERN_MASTER's Folly"

private val menuDate = File("data/tavern-menu-data.txt")
    .readText()
    .split("\n")

fun visitTavern() {
    narrate("$heroName enters $TAVERN_NAME")
    val patrons = mutableListOf("Eli", "Mordoc", "Sophie")

    val eliMessage = if (patrons.contains("Eli")) {
        "$TAVERN_MASTER says: Eli's in the back playing cards"
    } else {
        "$TAVERN_MASTER says: Eli isn't here"
    }
    println(eliMessage)

    val othersMessage = if (patrons.containsAll(listOf("Sophie", "Mordoc"))) {
        "$TAVERN_MASTER says: Sophie and Mordoc are seated by the stew kettle"
    } else {
        "$TAVERN_MASTER says: Sophie and Mordoc aren't with each other right now"
    }
    println(othersMessage)

//    patrons.forEach{patron ->
//        println("Good evening, $patron")
//    }

    patrons.forEachIndexed() { i, patron ->
        println("Good evening, $patron - you're #${i + 1} in line")
        placeOrder(patron, "Dragon's Breath")
    }

    menuDate.forEachIndexed { index, data ->
        println("$index : $data")
    }
}

private fun placeOrder(patronName: String, menuItemName: String) {
    narrate("$patronName speaks with $TAVERN_MASTER to place an order")
    narrate("$TAVERN_MASTER hands $patronName a $menuItemName")
}