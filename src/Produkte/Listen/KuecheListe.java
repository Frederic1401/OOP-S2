package src.Produkte.Listen;

import src.Produkte.Kategorien.KuecheProdukt;
import src.Produkte.Produkt;
import src.Produkte.Verwaltungsliste;

public class KuecheListe extends Verwaltungsliste<KuecheProdukt> {

    public KuecheListe() {
        setIndex(2);
    }

    @Override
    protected KuecheProdukt createProdukt(String seriennummer, String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) {
        return new KuecheProdukt(seriennummer, name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
    }

    public void deleteProdukt(KuecheProdukt produkt){removeProdukt(produkt);}

}
