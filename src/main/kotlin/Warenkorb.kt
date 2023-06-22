import java.util.*

// Klasse für den Warenkorb
open class Warenkorb {
    var artikel = mutableListOf<Produkt>()

    fun artikelHinzufuegen(produkt: Produkt) {
      //  var produkt: Produkt = Produkt("Test", 0)

        artikel.add(produkt)
        /*var nutzerKorbListe: MutableList<Produkt> = mutableListOf()
        println("Bitte geben Sie die Nummer des gewünschten Produkts ein:")
        for ((index, produkt) in nutzerKorbListe.withIndex()) {
            println("$index - ${produkt.produktName}")
        }

        var eingabe = readln()
        var index = eingabe.toIntOrNull()

        if (index != null && index in 0 until nutzerKorbListe.size) {
            for (artikel in nutzerKorbListe){
                //warenkorb.artikelHinzufuegen()
            }
            return warenkorb.artikelHinzufuegen()

        }

        var itemWahl = readln().toInt()*/
        //warenKorbAnzeigen()
        //return warenkorb.artikelHinzufuegen()
    }



    fun artikelLoeschen(item: Produkt) {
        artikel.remove(item)
    }

    fun zwischenSumme(): Double {
        var summe = 0.0
        for (item in artikel) {
            summe += item.produktPreis
        }
        return summe
    }

    open fun warenKorbAnzeigen() {
        println("Warenkorb:")
        for (item in artikel) {
            println("${item.produktName} - ${item.produktPreis} €")
        }
        println("Gesamt: ${zwischenSumme()} € zur Bestellung -> j")
        var input = readln()

        if (input == "j") {
            kaufAbschliessen()
        }
    }


    open fun kaufAbschliessen() {
        println("Warenkorb:")
        for (item in artikel) {
            println("${item.produktName} - ${item.produktPreis} €")
        }
        println("Gesamt: ${zwischenSumme()} €")
        println("Zur Bestellung: 'j'")
        var bestaetigung = readLine()
        if (bestaetigung == "j") {
            println("Preisübersicht: ${zwischenSumme()} €")
            println("Kauf abschließen:")
            for (item in artikel) {
                println("${item.produktName} - ${item.produktPreis} €")
            }
            println("[ ] AGB Bestätigung -> 'j'")
            bestaetigung = readLine()
            if (bestaetigung == "j") {
                println("[X] AGB Bestätigung")
                println("[ kaufen ] -> 'j'")
                bestaetigung = readLine()
                if (bestaetigung == "j") {
                    val rechnung = erstelleRechnung()
                    println("Vielen Dank für den Kauf!")
                    println("Sie bekommen eine Bestellbestätigung sowie die Rechnung per E-Mail zugesandt!")
                    println(rechnung)
                    artikel.clear() // Warenkorb leeren nach erfolgreichem Kauf
                }
            } else {
                warenKorbAnzeigen()
            }
        } else {
            warenKorbAnzeigen()
        }
    }

    private fun erstelleRechnung(): String {
        //val rechnungsnummer = UUID.randomUUID().toString()
        val rechnungsnummer = (Math.random() * 1000000000).toInt()
        val gesamtsumme = zwischenSumme()

        val rechnungBuilder = StringBuilder()
        rechnungBuilder.appendln("Rechnung")
        rechnungBuilder.appendln("Rechnungsnummer: $rechnungsnummer")
        rechnungBuilder.appendln("Datum: ${Date()}")
        rechnungBuilder.appendln("")

        for (item in artikel) {
            rechnungBuilder.appendln("${item.produktName} - ${item.produktPreis} €")
        }

        rechnungBuilder.appendln("Gesamt: $gesamtsumme €")

        return rechnungBuilder.toString()
    }


}





