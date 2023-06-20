open class Vertrage(var vertragName: String,
                    var mntlAbschlag: Int,
                    ): Produkt(vertragName, mntlAbschlag) {

    var vertragsNummer: Int = 0

    override fun produkteAnzeige(){
        println("$vertragName   Monatlich: $mntlAbschlag"   )
    }

    var vertragsliste: MutableList<Vertrage> = mutableListOf()
    fun vertragZuordnen(vertrag: Vertrage) {
        vertragsliste.add(vertrag)
        println("${vertrag.vertragName} Erfolgreich hinzufügt!")
    }
}