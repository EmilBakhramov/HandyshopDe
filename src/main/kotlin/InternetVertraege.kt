class InternetVertraege(vertragName: String,
                        mntlAbschlag: Int,
                        var uebertragungsrate: Int) : Vertrage(vertragName, mntlAbschlag) {

    override fun produkteAnzeige() {
        for (produkte in produktListe) {
            println("$vertragName, Bandbreite: $uebertragungsrate Preis: $mntlAbschlag")
        }
    }
}