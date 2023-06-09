package src.Testclasses;

import src.Products.Produkt;
import src.Products.Produktkatalog;

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
        Produkt herd = new Produkt("Küche", "Herd", "Herd mit vier Induktionsplatten", null,
                2008, 7, 50, 11, 99.99,  true) ;
        Produkt tisch = new Produkt("Küche", "Tisch", "Besteht aus Holz", herd,
                2012, 3, 100, 12, 49.99,  false) ;
        Produkt stuhl = new Produkt("Küche", "Stuhl", "Aus Holz per Handarbeit geschaffen", tisch,
                2014, 1, 200, 13, 24.99,  true) ;
        Produkt holz = new Produkt("Material", "Holz", "Ein Kilo je Menge", null,
                2010, 2, 500, 21, 2.99,  false) ;

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
        for(Produkt produkte : produktkatalog.suchProdukte("Holz")){
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
