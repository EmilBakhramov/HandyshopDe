import java.time.LocalDate


data class Kunde(
    var name: String,
    var geburtsDatum: LocalDate,
    var strassehNr: String,
    var plz: String,
    var ort: String,
    var passwort: String) {

    fun kundRezission(produkt: Produkt, rezission: Rezission): Produkt {
        var kundRezission: MutableMap<Produkt, String> = mutableMapOf()
        for (items in angebote ){
            var bewertung = mutableMapOf<Produkt, String>()
            println(bewertung.values)
        }
        return produkt
    }

}

