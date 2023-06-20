import java.io.Console
import java.time.LocalDate
import java.time.format.DateTimeParseException

// Liste "Angebote"
// var auswahl: Produkt? = artikelAuswaehlen()
var angebote = mutableListOf(
    Smartphone("Xiaomi Poco X4      ", 289, 256),
    Smartphone("Galaxy Note 7       ", 500, 500),
    Smartwatch("appleWhatch 20 pro ", 1300, 256),
    Smartwatch("Samsung 20 pro     ", 1300, 256),
    InternetVertraege("Giga Zuhause200    ", 25,  200),
    Smartphone("iPhone 12 pro      ", 1200, 256),
    InternetVertraege("Internet DSL100     ", 25,  100),
    Versicherungen("Geräte - KOMPLETT-SCHUTZ     ", 10, 2)
)
var kundeDef: Kunde = Kunde("Emil", LocalDate.now(), "Fürstenstr.11 ","09130", "Chemnitz", "****")
var kundenListe: MutableList<Kunde> = mutableListOf(kundeDef)

var warenkorb: Warenkorb = Warenkorb()


        /**
         * Methode fuer Neues Konto hinzufügen
         */
        fun neuenKundeErstellen(): MutableList<Kunde> {
            //While-Loop für das einpflegen der Kundendaten
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
                            val eingabe = readLine()
                            //prüft auf korrekte Formatierung
                            geburtsDatumEingabe =
                                LocalDate.parse(eingabe, java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                        } catch (e: DateTimeParseException) {
                            println("Ungültiges Format! Bitte geben Sie das Geburtsdatum im Format 'tt.mm.jjjj' ein:")
                        }
                    }
                    // Überprüfen, ob Kunde bereits existiert
                    var kundeExistiert = false

                    for (kunde in kundenListe) {    //für alle eingetragenen kunden
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
                    //eingabe der Werte
                    println(" Straße + HausNr.")
                    var strassehNr = readLine()

                    println("Postleitzahl: ")
                    var plz = readLine()

                    println("Ort: ")
                    var ort = readLine()

                    println("Passwort: ")
                    var passwort = readLine()
                    //bestätigung
                    println("Passwort Wiederholen: ")
                    try {

                        var passwortCheck = readLine()
                        if (passwort != passwortCheck) {
                            throw Exception("Keine Übereinstimmung!")
                        }


                    } catch (ex: java.lang.Exception) {
                        println("Passwörter stimmen nicht überein")
                        continue
                    }

                    var neuerKunde =
                        Kunde(eingabeName!!, geburtsDatumEingabe!!, strassehNr!!, plz!!, ort!!, passwort!!)

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
            try {
                print("Benutzername: ")
                var username = readLine()!!

                val console: Console? = System.console()
                if (console != null) {
                    val password = console.readPassword("Enter your password: ")
                    val passwordString = password.joinToString("") // Passwort als Zeichenkette

                    // Maskieren Sie das Passwort, indem Sie es durch Sternchen ersetzen
                    val maskedPassword = "*".repeat(passwordString.length)

                    println("Your password is: $maskedPassword")
                } else {
                    println("No console available")
                }
                print("Passwort: ")
                console?.let {
                }

                    var password = readLine()!!

                    for (kunden in kundenListe) {
                        if (kunden.name == username && kunden.passwort == password) {
                            println("Login erfolgreich.")
                            println("Willkommen ${kunden.name}")
                            logInBereich()

                        } else {
                            println("Benutzername oder Passwort falsch.")
                        }
                    }

            } catch (e: Exception) {
                println("Fehlerhafte Eingabe: ${e.message}")
            }
        }


        fun logInBereich() {
            var meineKaufe: MutableList<Produkt> = mutableListOf()
            println(
                """
                    0 -> Meine Daten                                    ${kundeDef.name} Eingeloggt:  'q'->Logout
                                            1 -> Mein Warenkorb
                                            2 -> Meine Käufe
                                            3 -> Meine Verträge
                                            4 -> Angebote
                                            5 -> Sortiment & Tariefe
                                            K -> Shoppen
                                            S -> Suche
            """.trimIndent()
            )
            var eingabe = readln()
            if ((eingabe == "k")||(eingabe == "K")){
                println("Wählen Sie Artikel durch Eingabe einer Zahl")
                var auswahl = mutableListOf<Produkt>()
                do {
                    for (artikel in auswahl ){
                        warenkorb.artikelHinzufuegen()
                    }
                }while (eingabe !== "q")
            }
            if (eingabe == "0") {
                println("$kundenListe ")
            }
            if (eingabe == "1") {
                //Funktionsaufruf
                 warenkorb.warenKorbAnzeigen()


                logInBereich()
            } else if (eingabe == "2") {
                meineKaufe = mutableListOf()


                logInBereich()
            } else if (eingabe == "3") {
                println("Hallo ${kundeDef.name}")
                Thread.sleep(1500)
                println("Ihre Verträge können Sie hier einsehen:")
                Thread.sleep(1000)
                println("[1]-> Handyvertrag LTE Max \nStatus: Aktiv                    [ Rechnung einsehen ]\n")
                println("[2]-> Handyversicherung  \nStatus: Aktiv                      [ Rechnung einsehen ]\n")
                println("[3]-> Smart-M Tariv \nStatus: Inaktiv (gekündigt)             [ Rechnung einsehen ]\n")
                logInBereich()
            } else if (eingabe == "4") {
                angeboteAufruf()
                //logInBereich()
            }else if (eingabe == "5"){
                produkteSortiert()

            } else  {
                println("Möchten Sie sich wirklich ausloggen? Zum bestätigen -Enter- | für Abbruch -n-")
                var bestaetigung = readln()
                if (bestaetigung == "") {
                    logOut()
                    hauptmenu()
                }else if (bestaetigung == "n"){
                    logInBereich()
                }
            }
        }




        fun logOut() {
            println("Sie wurden ausgeloggt.")
            hauptmenu()
        }


        fun produkteSortiert() {
            // for (items in angebote){
            //  items.produktListe.subList(2, 4)
            //  items.produktListe.subList(4,6)
            angebote.sortBy { it.produktName }

            val kategorien = angebote.groupBy { it.javaClass.simpleName }
            var i = 0
            for (kategorie in kategorien) {
                println(kategorie.key)
                for (element in kategorie.value) {
                    i++
                    println("[" + "${i}}" + "]->" + " ${element.produktName}")
                }
            }
        }


        fun angeboteAufruf() {

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
            }
            warenkorb.artikelHinzufuegen()
            logInBereich()
        }


/**
 * Funktion zum Aufruf der Menu-Optionen
 */
fun hauptmenu() {
            //Kurze-Zeit-Angebote Anzeige
            var addListe: MutableList<String> = mutableListOf(
                "NEU!!! EXKLUSIVANGEBOT! iPhone14 für nur 1299.00€ nur heute",
                "NEU!!! EXKLUSIVANGEBOT! LTE 140 GB für nur 19.99€ Mntl. nur heute\"",
            )
            //Ausgabe 1 zuffälig gewähltes Angebot
            var add = addListe.random()
            println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
            println("$add")
            println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")

            println(
                """ Hauptmenü:
                                    1 -> Login
                                    2 -> Neuen Kundenaccount anlegen
                                    3 -> Kategorien
                                    4 -> Angebote
                                    5 -> Produkt gleich Wählen
            """.trimIndent()
            )
            var eingabe = readln()
            if (eingabe == "1") {
                //Funktionsaufruf
                logIn()
                hauptmenu()
            } else if (eingabe == "2") {
                neuenKundeErstellen()
                hauptmenu()
            } else if (eingabe == "3") {
                produkteSortiert()
                //var datenBankt
                artikelAuswaehlen()
            } else if (eingabe == "4") {
                angeboteAufruf()
                artikelAuswaehlen()
            } else if (eingabe == "5") {
                angeboteAufruf()
                println("Geben Sie Ihre auswahl ein:")
                artikelAuswaehlen()
            } else {
                angebote
                hauptmenu()
            }
        }

        fun artikelAuswaehlen(): MutableList<Produkt>? {
            println("Bitte geben Sie die Nummer des Artikels ein, (oder 'q' zum Beenden):")
            val eingabe = readLine()

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





