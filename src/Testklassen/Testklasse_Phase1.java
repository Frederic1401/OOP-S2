package src.Testklassen;

import src.Produkte.Produkt;
import src.Produkte.Produktkatalog;

/**
 * Package 'code.Products'
 *
 * Zweck: Testklasse der ersten Phase; Hier werden sämtliche Funktionalitäten der Klassen Produkt und Produktkatalog getestet.
 * @author: Frederic Oetgen
 * @version: 21.05.2023
 * Historie: 21.05.2023, Erstellung der Klasse
 */
public class Testklasse_Phase1 {

    static Produktkatalog produktkatalog;

    public static void main(String[] args) {
        System.out.println("Der Testlauf der 1. Phase wird gestartet...");

        produktkatalog = new Produktkatalog();

        //Erstelle 3 neue Test-Produkte und füge sie zum Katalog hinzu
        Produkt herd = new Produkt( "11", "Küche", "Herd", "Herd mit vier Induktionsplatten", null,
                2008, 7, 50, 99.99,  true) ;
        Produkt tisch = new Produkt("12", "Küche", "Tisch", "Besteht aus Holz", herd,
                2012, 3, 100,49.99,  false) ;
        Produkt stuhl = new Produkt("13", "Küche", "Stuhl", "Aus Holz per Handarbeit geschaffen", tisch,
                2014, 1, 200, 24.99,  true) ;
        Produkt holz = new Produkt("21", "Material", "Holz", "Ein Kilo je Menge", null,
                2010, 2, 500,2.99,  false) ;

        produktkatalog.addProdukt(herd);
        produktkatalog.addProdukt(tisch);
        produktkatalog.addProdukt(stuhl);
        produktkatalog.addProdukt(holz);

        System.out.println(); //Leerzeile Zwecks Übersichtlichkeit generieren

        //Gebe den Produktkatalog aus
        System.out.println("Der gesamte Produktkatalog wird ausgegeben...");
        System.out.println(produktkatalog.toString());

        System.out.println(); //Leerzeile Zwecks Übersichtlichkeit generieren

        //Suche nach 'Holz' und gebe die Suchergebnisse aus
        System.out.println("Hier sind alle Produkte die auf die Beschreibung 'Holz' zutreffen...");
        for(Produkt produkte : produktkatalog.sucheProduktNachEingabe("Holz")){
            System.out.println(produkte.toString());
        }

        System.out.println(); //Leerzeile Zwecks Übersichtlichkeit generieren

        //Preisvergleich zwischen Tisch und Stuhl
        System.out.println("Nun wird überprüft, ob der Tisch teurer als der Stuhl ist...");
        System.out.println(tisch.compareTo(stuhl) > 0 ? "Der Tisch ist teurer als der Stuhl" : "Der Tisch ist günstiger als der Stuhl \n");

        System.out.println(); //Leerzeile Zwecks Übersichtlichkeit generieren

        //Entfernen eines Produktes und Ausgabe des aktuellen Produktkataloges
        System.out.println("Nun wird der Stuhl aus dem Katalog entfernt und der Katalog wird wieder ausgegeben...");
        produktkatalog.removeProdukt(stuhl);
        System.out.println(produktkatalog.toString());

        System.out.println(); //Leerzeile Zwecks Übersichtlichkeit generieren

        System.out.println("Der Testlauf der 1. Phase wird beendet...");
    }
}
