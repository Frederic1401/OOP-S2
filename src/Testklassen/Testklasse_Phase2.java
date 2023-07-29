package src.Testklassen;

import src.InvalidProductAttributeException;
import src.Produkte.Kategorien.BadezimmerProdukt;
import src.Produkte.Kategorien.ElektronikProdukt;
import src.Produkte.Kategorien.SonstigesProdukt;
import src.Produkte.Listen.BadezimmerListe;
import src.Produkte.Listen.ElektronikListe;
import src.Produkte.Listen.SonstigesListe;
import src.Produkte.Produktkatalog;

public class Testklasse_Phase2 {

    static Produktkatalog produktkatalog;

    static BadezimmerListe badezimmerListe;
    static ElektronikListe elektronikListe;
    static SonstigesListe sonstigesListe;

    public static void main(String[] args) {
        produktkatalog = new Produktkatalog();

        badezimmerListe = new BadezimmerListe();
        elektronikListe = new ElektronikListe();
        sonstigesListe = new SonstigesListe();

        //Es werden Produkte, wenn möglich erstellt und den entsprechenden Listen hinzugefügt
        BadezimmerProdukt badewanne;
        BadezimmerProdukt toilette;
        ElektronikProdukt handy;
        ElektronikProdukt aufladekabel;
        SonstigesProdukt auto;
        try {
            badewanne = badezimmerListe.produktErzeugen("Badewanne", "Aus Porzellan", null, 2018,7,100, 249.99, false);
            handy = elektronikListe.produktErzeugen("Handy", "Enthält keine Sim-Karte", null, 2014, 3, 250, 149.99, true);
            aufladekabel = elektronikListe.produktErzeugen("Aufladekabel", "Aufladekabel für das Mobiltelefon", handy, 2012, 2, 50, 14.99, false);
            auto = sonstigesListe.produktErzeugen("Auto", "Es hat vier Räder", null, 2008, 14, 100, 1999.99, false);

            produktkatalog.addProdukt(badewanne);
            produktkatalog.addProdukt(handy);
            produktkatalog.addProdukt(aufladekabel);
            produktkatalog.addProdukt(auto);

            //Fehlerhaftes Produkt wird erstellt, siehe Mengenbestand
            toilette = badezimmerListe.produktErzeugen("Toilette", "Aus Porzellan", null, 2018,7,-50, 249.99, false);
            produktkatalog.addProdukt(toilette);
        } catch (InvalidProductAttributeException e) {
            System.out.println("Fehler: "+e.getMessage());
        }

        System.out.println();

        System.out.println("Es werden alles vorhandene Produkte aufgelistet...");
        System.out.println(produktkatalog);

        System.out.println();

        System.out.println("Nun wird der vorhandene Produktkatalog danach sortiert, ob sich Produkte im Angebot befinden");
        produktkatalog.sortierenNachAngebot();
        System.out.println(produktkatalog);

        System.out.println();

        System.out.println("Nun werden alle Elektronikprodukte aufsteigend nach ihrem Preis sortiert, um das günstigste zu finden..");
        elektronikListe.sortierenNachPreis();
        System.out.println(elektronikListe);
    }
}
