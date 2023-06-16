open class Vertrage(var vertragName: String,
                    var mntlAbschlag: Int,
                    var vertragsNummer: Int): Produkt(vertragName, mntlAbschlag) {

    override fun produkteAnzeige(){
        println("$vertragName, Vertragsnummer: $vertragsNummer      Monatlich: $mntlAbschlag"   )
    }

    var vertragsliste: MutableList<Vertrage> = mutableListOf()
    fun vertragZuordnen(vertrag: Vertrage) {
        vertragsliste.add(vertrag)
        println("${vertrag.vertragName} Erfolgreich hinzufügt!")
    }
}