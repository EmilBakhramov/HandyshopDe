import kotlin.system.exitProcess

fun main() {

    fun checkMindestalter(alter: Short): Boolean {
        val mindestalter = 12
        return alter >= mindestalter
    }
    println("Bitte Alter eingeben:")
    var alter: Short = readln().toShort()
    if (!checkMindestalter(alter)) {
        // Der Benutzer hat kein Zugang zu den Funktionen des Stores
        println("Zugang berechtigt für personen ab 12 jahren")
        exitProcess(-1)

    } else {
        println()
        Thread.sleep(1000)
        println("Defalt-Benutzername:    admin")
        println("Defalt-Passwort:        admin")
        println()
        Thread.sleep(1000)
        hauptmenu()
    }
}
