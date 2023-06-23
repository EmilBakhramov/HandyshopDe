import java.io.Console
import java.time.LocalDate
import java.time.format.DateTimeParseException

// Liste "Angebote"
var angebote = mutableListOf(
    Smartphone("Xiaomi Poco X4  ", 289, 256),
    Smartphone("Galaxy Note 7   ", 500, 500),
    Smartwatch("appleWhatch 20 pro  ", 1300, 256),
    Smartwatch("Samsung 20 pro  ", 1300, 256),
    InternetVertraege("Giga Zuhause200    ", 25,  200),
    Smartphone("iPhone 12 pro      ", 1200, 256),
    InternetVertraege("Internet DSL100     ", 25,  100),
    Versicherungen("Geräte - KOMPLETT-SCHUTZ     ", 10, 2)
)
//Kunde Initialisieren
var kundeDef: Kunde = Kunde("Emil", LocalDate.of(1994,12,15), "Fürstenstr.11 ","09130", "Chemnitz", "017656968030", "bahramov.e@googlemail.com","****")

var kundenListe: MutableList<Kunde> = mutableListOf(kundeDef)

var warenkorb: Warenkorb = Warenkorb()

var eigeloggt: Boolean = false

/**
 * Methode fuer Neues Konto hinzufügen
 */
fun neuenKundeErstellen(): MutableList<Kunde> {
    //While-Loop für das Einpflegen der Kundendaten
    var q = true
    while (q) {
        println("Neues Kundenaccount anlegen...")
        Thread.sleep(800)
        println("Bitte geben Sie Ihre vollständigen Daten ein ('q' -> Beenden):")
        println("Name: ")
        try {
            var eingabeName = readln()

            if (eingabeName == "q") {
                break
            }
            //Datum muss Format entsprechen
            println("Geburtsgatum tt.mm.jjjj:")
            var geburtsDatumEingabe: LocalDate? = null
            //noch nicht initialisiert
            while (geburtsDatumEingabe == null) {
                try {
                    //liest ein Datum ein
                    val eingabe = readln()
                    //prüft auf korrekte Formatierung
                    geburtsDatumEingabe =
                        LocalDate.parse(eingabe, java.time.format.DateTimeFormatter.ofPattern("dd.mm.yyyy"))
                } catch (e: DateTimeParseException) {
                    println("Ungültiges Format! Bitte geben Sie das Geburtsdatum im Format 'tt.mm.jjjj' ein:")
                }
            }
            // Überprüfen, ob Kunde bereits existiert
            var kundeExistiert = false

            //für alle Vorhandenen kunden
            for (kunde in kundenListe) {
                //mache folgenden Vergleich
                if (kunde.name == eingabeName && kunde.geburtsDatum == geburtsDatumEingabe) {
                    try {
                        kundeExistiert = true   //wenn kunde in Basis bereits besteht
                        //warnung geben
                    } catch (e: IllegalAccessError) {
                        println("Konto existiert bereits! -> LogIn -> Eingabe '2'")
                    }
                    println("Kunde mit diesem Namen bereits vorhanden!")

                    break
                }
            }

            if (kundeExistiert) {
                continue
            }
            println("* - Pflichtfelder")
            //eingabe der Werte
            println(" Straße + HausNr.*")
            var strassehNr = readln()

            println("Postleitzahl:* ")
            var plz = readln()

            println("Ort:* ")
            var ort = readln()

            println("Tel:*")
            var tel = readln()

            println("E-Mail:*")
            var eMail = readln()

            println("Passwort:* ")
            var passwort = readln()
            //bestätigung
            println("Passwort Wiederholen:* ")
            try {
                var passwortCheck = readln()
                if (passwort != passwortCheck) {
                    throw Exception("Keine Übereinstimmung!")
                    }
            } catch (ex: java.lang.Exception) {
                println("Passwörter stimmen nicht überein")
                continue
            }
            //darf keine leeren felder besitzen
            var neuerKunde = Kunde(eingabeName!!, geburtsDatumEingabe!!, strassehNr!!, plz!!, ort!!, tel!!, eMail!!, passwort!!)
            //zu Kundenliste hinzufügen
            kundenListe.add(neuerKunde)

        } catch (e: Exception) {
            println("Fehlerhafte Eingabe: ${e.message}")
        }

        println("Kunde wurde erfolgreich erstellt.")
        q = false

        hauptmenu()

    }
    return kundenListe

}

/**
 * Methode fuer den LogIn
 */
fun logIn() {

    print("Benutzername: ")
    try {
        val username = readln()
        val console: Console? = System.console()
        if (console != null) {
            val password = console.readPassword("Enter your password: ")
            val passwordString = password.joinToString("") // Passwort als Zeichenkette

            // Maskieren Sie das Passwort, indem Sie es durch Sternchen ersetzen
            val maskedPassword = "*".repeat(passwordString.length)
            /*val reader = console.reader()
            while (true) {
                val currentCharacter = reader.read()
                if (currentCharacter.toChar() == '\n')
            }*/

            //println("Your password is: $maskedPassword")
        //} else {
            //println("No console available")
        }
        print("Passwort: ")
        console?.let {
        }

        var password = readln()

        for (kunden in kundenListe) {
            if (kunden.name == username && kunden.passwort == password) {
                println("Login erfolgreich.")
                println()
                Thread.sleep(1000)
                println("                        Willkommen ${kunden.name}")
                Thread.sleep(1500)
                logInBereich()
            } else {
                println("Benutzername oder Passwort falsch.")
            }
        }

    } catch (e: Exception) {
        println("${e.message}")
    }
}

fun logInBereich() {
    eigeloggt = true
    //var meineKaufe: MutableList<Produkt> = mutableListOf()
    println(
        """
            0 -> Meine Daten                                    ${kundeDef.name} Eingeloggt:  'q'->Logout
                                    1 -> Mein Warenkorb
                                    2 -> Meine Käufe
                                    3 -> Meine Verträge
                                    4 -> Angebote
                                    5 -> Sortiment & Tariefe
                                    
    """.trimIndent()
    )
    var eingabe = readln()

    if (eingabe == "0") {
        println("Ihre persönlichen Daten:")
        println("${kundeDef.name}")
        println("${kundeDef.geburtsDatum}")
        println("${kundeDef.strassehNr}")
        println("${kundeDef.ort}")
        println("${kundeDef.tel}")
        println("${kundeDef.eMail}")
        println()
        // TODO:
        println("Persönliche Daten ändern?")

    } else if (eingabe == "1") {
        //Funktionsaufruf
        warenkorb.warenKorbAnzeigen()

    } else if (eingabe == "2") {
        if (warenkorb.anzahlKaufe == 0){
            println("Sie haben Keine Käufe")
        }else {
            println("Ihre Rechnungen:")
            println(warenkorb.rechnung)
        }

    } else if (eingabe == "3") {
        println("Hallo ${kundeDef.name}")
        Thread.sleep(1500)
        println("Ihre Verträge können Sie hier einsehen:")
        if (warenkorb.anzahlKaufe == 0) {
            println("Sie haben noch keine Verträge")
        }else {
            println(warenkorb.rechnung)
        }

    } else if (eingabe == "4") {
        angeboteAufruf()
        artikelAuswaehlen(angebote)

    }else if (eingabe == "5"){
        println(AlleProdukte().alleProdukteEinfuegen())
        artikelAuswaehlen(AlleProdukte().alleProdukte)

    } else {
        println("Möchten Sie sich wirklich ausloggen? Zum bestätigen -Enter- | für Abbruch -n-")
        var bestaetigung = readln()
        if (bestaetigung == "") {
            logOut()
            hauptmenu()
            return
        }
    }
    logInBereich()
}

/**
 * Funktion zum Ausloggen
 */
fun logOut() {
    println("Sie wurden ausgeloggt.")
    hauptmenu()
}

/**
 * Funktion zur sortierten Augabe der Produkte
 */
fun produkteSortiert() {

    angebote.sortBy { it.produktName }

    val kategorien = angebote.groupBy { it.javaClass.simpleName }
    var i = 0
    for (kategorie in kategorien) {
        println(kategorie.key)
        for (element in kategorie.value) {
            i++
            println("[" + "${i}" + "]->" + " ${element.produktName}")
        }
    }
}

/**
 * Funktion zum Afruf der Angebote
 */
fun angeboteAufruf(){
    var preisNeu: Int = 0
    println("""
             TOP-ANGEBOTE DIESER WOCHE
            """)

    var rabatt = 10
    var faktor = (100 - rabatt)
    var i = 0
    for (produkte in angebote) {
        i++
        var sonderpreis = produkte.produktPreis * faktor / 100

        println("[" + "$i" + "]->" + "   ${produkte.produktName}        statt      ${produkte.produktPreis}       für nur $sonderpreis €!")
        //Sonderpreis Speichern
        produkte.produktPreis = sonderpreis

    }
}

/**
 * Funktion zum Aufruf der Menu-Optionen
 */
fun hauptmenu() {
            //Kurze-Zeit-Angebote Anzeige
            var addListe: MutableList<String> = mutableListOf(
                "NEU!!! EXKLUSIVANGEBOT! iPhone14 für nur 1299.00€ nur heute",
                "NEU!!! EXKLUSIVANGEBOT! LTE 140 GB für nur 19.99€ Mntl. nur heute"
            )
            //Ausgabe 1 zuffälig gewähltes Angebot
            var add = addListe.random()
            println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
            println("$add")
            println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")

            println(
                """ Hauptmenü:                                          0 -> Warenkorb
                                    1 -> Login
                                    2 -> Neuen Kundenaccount anlegen
                                    3 -> Kategorien
                                    4 -> Angebote
                                    5 -> Produkt gleich Wählen
            """.trimIndent()
            )
            var eingabe = readln()
            if (eingabe == "0"){
                warenkorb.warenKorbAnzeigen()
                hauptmenu()
            }else if (eingabe == "1") {
                //Funktionsaufruf
                logIn()
                hauptmenu()
            } else if (eingabe == "2") {
                neuenKundeErstellen()
                hauptmenu()
            } else if (eingabe == "3") {
                produkteSortiert()
                artikelAuswaehlen(angebote)
            } else if (eingabe == "4") {
                angeboteAufruf()
                artikelAuswaehlen(angebote)
                hauptmenu()
            } else if (eingabe == "5") {
                angeboteAufruf()
                println("Geben Sie Ihre auswahl ein:")
                artikelAuswaehlen(angebote)
                hauptmenu()
            }else if (eingabe == "q"){
                return
            } else {
                angebote
                hauptmenu()
            }
        }

fun artikelAuswaehlen(list: MutableList<Produkt>): MutableList<Produkt>? {

    println("Wählen Sie ein Produkt:")
    try {
        var produktEingabe = readln()

        var index = produktEingabe.toIntOrNull()

        if (index != null) {
            if ((index > 0) && (index <= angebote.size)) {
                warenkorb.artikelHinzufuegen(angebote[index.minus(1)])
            } else {
                println("Index nicht gefunden, bitte Zahl eingeben!")
            }
        }
    } catch (ex: Exception) {
        println(ex.printStackTrace())
    }

    return warenkorb.artikel
}

   /* println("Bitte geben Sie die Nummer des Artikels ein, (oder 'q' zum Beenden):")
    val eingabe = readln()

    if (eingabe == "q") {
        return null
    } else if (eingabe == "1" ) {

    println("""
        
        "Xiaomi Poco X4        Angebot! aktuell statt      289       für nur:    260 €!"
        |   Speicher:   erweiterbar       |   RAM:   |   
        |   254 GB          ja            |   16 GB  |
        [K]-> zum Korb hinzufügen
         
            )
    """.trimIndent())
            hauptmenu()

    }else if (eingabe == "6"){
        println("""
        "iPhone        Angebot! aktuell statt      289       für nur:    260* €!"
        |   Speicher:   erweiterbar       |   RAM:   |   
        |   254 GB          ja            |   16 GB  |
                
        *einmalig, danach 24,00€ monatlich
            )
    """.trimIndent())
    }

    val index = eingabe?.toIntOrNull()

    if (index != null && index in 0 until angebote.size) {
        println("${angebote[index].produktListe}")
        return angebote[index].produktListe
    }


    println("Ungültige Eingabe. Bitte versuchen Sie es erneut.")
    return artikelAuswaehlen()
    }
    */






