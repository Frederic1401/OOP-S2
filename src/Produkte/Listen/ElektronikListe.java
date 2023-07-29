package src.Produkte.Listen;

import src.Produkte.Kategorien.ElektronikProdukt;
import src.Produkte.Produkt;
import src.Produkte.Verwaltungsliste;

public class ElektronikListe extends Verwaltungsliste<ElektronikProdukt> {

    public ElektronikListe() {
        setIndex(1);
    }

    @Override
    protected ElektronikProdukt createProdukt(String seriennummer, String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) {
        return new ElektronikProdukt(seriennummer, name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
    }

    public void deleteProdukt(ElektronikProdukt produkt){removeProdukt(produkt);}

}
