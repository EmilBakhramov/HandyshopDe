import java.util.*

/**
 * Klasse für den Warenkorb
 */
open class Warenkorb {
    var artikel = mutableListOf<Produkt>()
    var anzahlKaufe: Int = 0

    fun artikelHinzufuegen(produkt: Produkt) {
        artikel.add(produkt)
    }

    fun artikelLoeschen(produkt: Produkt) {
        artikel.remove(produkt)
    }

    fun zwischenSumme(): Double {
        var summe = 0.0
        for (item in artikel) {
            summe += item.produktPreis
        }
        return summe
    }

    /**
     * Anzeige des Warenkorbs
     */
    open fun warenKorbAnzeigen() {
        if (warenkorb.artikel.isEmpty()) {
            println("Ihr warenkorb ist leer")
        } else {
                println("Warenkorb:")
                for (item in artikel) {
                    println("${item.produktName} - ${item.produktPreis} €")
                }
                println("Gesamt: ${zwischenSumme()} € zur Bestellung -> j Löschen -> L")
                if (eigeloggt == false) {
                    println("Für Kaufvorgang einloggen oder registrieren!")
                    println(" 1 -> LogIn    2 -> Registrierung")
                    var input = readln()
                    if (input == "1"){
                        logIn()
                    }else if (input == "2") {
                        neuenKundeErstellen()
                    }
                }else{
                    var input = readln()
                    if (input == "j") {
                        kaufAbschliessen()
                    }
                    if (input == "L") {
                        println("Welches Produkt möchten Sie entfernen?")
                    try {
                        var produktLoeschen = readln()
                        var index = produktLoeschen.toIntOrNull()

                        if (index != null) {
                            if ((index > 0) && (index <= warenkorb.artikel.size)) {
                                warenkorb.artikelLoeschen(warenkorb.artikel[index.minus(1)])
                            } else {
                                println("Index nicht gefunden, bitte Zahl eingeben!")
                            }
                        }
                    } catch (ex: Exception) {
                        println(ex.printStackTrace())
                    }
                    println()
                }
            }
        }
    }

    /**
     * Funktion zum Abschließen des Kaufs
     */
    fun kaufAbschliessen() {

        println("Warenkorb:")
        for (item in artikel) {
            println("${item.produktName} - ${item.produktPreis} €")

        }
        println("Gesamt: ${zwischenSumme()} €")
        println("Zur Bestellung: 'j'")
        var bestaetigung = readln()
        if (bestaetigung == "j") {
            println("Preisübersicht: ${zwischenSumme()} €")
            println("Kauf abschließen:")
            for (item in artikel){
                println("${item.produktName} - ${item.produktPreis} €")
            }
            println("[ ] AGB Bestätigung -> 'j'")
            bestaetigung = readln()
            if (bestaetigung == "j") {
                println("[X] AGB Bestätigung")
                println("[ kaufen ] -> 'j'")
                bestaetigung = readln()
                if (bestaetigung == "j") {
                    val rechnung = erstelleRechnung()

                    println("Vielen Dank für den Kauf!")
                    println("Sie bekommen eine Bestellbestätigung sowie die Rechnung per E-Mail zugesandt!")
                    println(rechnung)
                    println()
                    artikel.clear() // Warenkorb leeren nach erfolgreichem Kauf
                }

            } else {
                warenKorbAnzeigen()
            }
        } else {
            warenKorbAnzeigen()
        }
}

    val rechnungBuilder = StringBuilder()
    var rechnung: String = ""

    /**
     * Funktion zum Erstellen einer Rechnung
     */
    private fun erstelleRechnung(): String {
        anzahlKaufe++
        rechnung = ""
        val rechnungsnummer = (Math.random() * 1000000000).toInt()
        val gesamtsumme = zwischenSumme()

        rechnungBuilder.appendLine(
            """
                    *************************************************
                    Rechnung    Nr. $rechnungsnummer
                    Datum: ${Date()}   
                    """.trimIndent()
        )
            for (item in artikel) {
                rechnungBuilder.appendLine("${item.produktName} ........    ${item.produktPreis} €")
            }
                rechnungBuilder.appendLine(
                    """        
                    *************************************************                        
                                            Gesamt: $gesamtsumme €                        
                    *************************************************
                    """.trimIndent()
                )
        rechnung = rechnungBuilder.toString()
        return rechnung
    }

}





