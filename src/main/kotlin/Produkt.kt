open class Produkt()  {
    var produktName: String = ""
    var produktPreis: Int = 0
    fun printTest() {
        println(produktName + " für " + produktPreis)
    }
    constructor(produktName: String, produktPreis: Int): super (produktName, produktPreis)  {
        this.produktName = produktName
        this.produktPreis = produktPreis
    }

    open var produktListe: MutableList<Produkt> = mutableListOf()

    open fun produkteAnzeige() {
        hauptmenu()
        for (produkte in produktListe) {
            //produktListe.add(produkte)
            println("$produktName, Preis: $produktPreis")
        }

    }

}




