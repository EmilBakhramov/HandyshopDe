
class Einkaufswagen : Warenkorb() {
    var kunde: String = ""
    var bestellungsNummer: Int = 0

    fun checkout() {
        val summe = zwischenSumme()
        println("Kunde: $kunde")
        println("Bestellungsnummer: $bestellungsNummer")
        println("Zwischensumme: $summe")
        println("Gesamtpreis: ${summe * 1.19}")
        println("Vielen Dank für Ihren Einkauf!")
    }
}