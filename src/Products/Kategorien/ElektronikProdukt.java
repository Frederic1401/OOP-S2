package src.Products.Kategorien;

import src.Products.Produkt;

public class ElektronikProdukt extends Produkt {

    public ElektronikProdukt(String seriennummer, String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) {
        super(seriennummer, "Elektronik", name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
    }
}
