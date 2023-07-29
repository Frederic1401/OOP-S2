package src.Produkte.Listen;

import src.Produkte.Kategorien.BadezimmerProdukt;
import src.Produkte.Produkt;
import src.Produkte.Verwaltungsliste;

public class BadezimmerListe extends Verwaltungsliste<BadezimmerProdukt> {

    public BadezimmerListe() {
        setIndex(3);
    }

    @Override
    protected BadezimmerProdukt createProdukt(String seriennummer, String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) {
        return new BadezimmerProdukt(seriennummer, name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
    }

    public void deleteProdukt(BadezimmerProdukt produkt){removeProdukt(produkt);}
}
