import java.io.DataInput
import java.io.DataInputStream
import java.text.DateFormat
import java.time.LocalDate



data class Kunde(
    var name: String,
    var geburtsDatum: LocalDate,
    var strassehNr: String,
    var plz: String,
    var ort: String,
    var tel: String,
    var eMail: String,
    var passwort: String) {

}

