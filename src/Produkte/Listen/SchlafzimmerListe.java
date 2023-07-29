package src.Produkte.Listen;

import src.Produkte.Kategorien.SchlafzimmerProdukt;
import src.Produkte.Produkt;
import src.Produkte.Verwaltungsliste;

public class SchlafzimmerListe extends Verwaltungsliste<SchlafzimmerProdukt> {

    public SchlafzimmerListe() {
        setIndex(4);
    }

    @Override
    protected SchlafzimmerProdukt createProdukt(String seriennummer, String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) {
        return new SchlafzimmerProdukt(seriennummer, name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
    }

    public void deleteProdukt(SchlafzimmerProdukt produkt){removeProdukt(produkt);}
}
