package src.Produkte.Listen;

import src.Produkte.Kategorien.SonstigesProdukt;
import src.Produkte.Produkt;
import src.Produkte.Verwaltungsliste;

public class SonstigesListe extends Verwaltungsliste<SonstigesProdukt> {

    public SonstigesListe() {
        setIndex(9);
    }

    @Override
    protected SonstigesProdukt createProdukt(String seriennummer, String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) {
        return new SonstigesProdukt(seriennummer, name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
    }

    public void deleteProdukt(SonstigesProdukt produkt){removeProdukt(produkt);}
}
