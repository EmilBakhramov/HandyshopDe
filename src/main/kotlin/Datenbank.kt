object Datenbank {
    var alleSmartPhoneList: MutableList<Smartphone> = mutableListOf(
        Smartphone("iPhoneX             ", 1299, 559),
        Smartphone("Xiaomi Poco X4      ", 289,  256),
        Smartphone("Galaxy Note 7       ", 500,  500),
        Smartphone("iPhone 14 pro       ", 1200, 256),
        Smartphone("Galaxy A7           ", 500,  500),
        Smartphone("iPhone 15x          ", 1200, 256,),)

    var alleVertraege: MutableList<Vertrage> = mutableListOf(
        InternetVertraege("Giga Speed Zuhause300      ", 35, 47834725, 200),
        InternetVertraege("Internet DSL50       ", 20, 3483948, 50),
        InternetVertraege("Internet DSL100      ", 25, 3483948, 100),
        InternetVertraege("Internet DSL150      ", 25, 3483948, 150),
        InternetVertraege("Internet DSL200      ", 25, 3483948, 200),
        InternetVertraege("Internet DSL250      ", 25, 3483948, 250),
        Versicherungen("Geräte-KOMPLETT-SCHUTZ  ", 10, 2, 29839))




    var sWatchesList: MutableList<Smartwatch> = mutableListOf(
        Smartwatch("appleWhatch 20 pro    ", 1300, 256,),
        Smartwatch("Samsung 21 pro        ", 1300, 150,),
        Smartwatch("appleWhatch 22 pro    ", 1300, 856,),
        Smartwatch("Samsung 20 pro        ", 1300, 256,),
        Smartwatch( "GT3 Pro (43mm) Huawe ", 499,  300 ))

}