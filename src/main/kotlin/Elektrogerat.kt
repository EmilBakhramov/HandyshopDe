open class Elektrogerat(
    geraeteName: String,
    geraetePreis: Int,
    var speicher: Int) : Produkt(geraeteName, geraetePreis) {

    override fun produkteAnzeige(){
        println("$produktName, Preis: $produktPreis, Speicher: $speicher ")
    }

}