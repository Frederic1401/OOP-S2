package src.Produkte.Listen;

import src.Produkte.Kategorien.WohnzimmerProdukt;
import src.Produkte.Produkt;
import src.Produkte.Verwaltungsliste;

import java.util.Collections;

public class WohnzimmerListe extends Verwaltungsliste<WohnzimmerProdukt> {

    public WohnzimmerListe() {
        setIndex(5);
    }

    @Override
    protected WohnzimmerProdukt createProdukt(String seriennummer, String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) {
        return new WohnzimmerProdukt(seriennummer, name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
    }

    public void sortiereNachNamen(){
        Collections.sort(liste);
    }
}
