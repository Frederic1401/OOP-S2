package src.Products.Listen;

import src.Products.Kategorien.BadezimmerProdukt;
import src.Products.Kategorien.SchlafzimmerProdukt;
import src.Products.Produkt;
import src.Products.Verwaltungsliste;

public class SchlafzimmerListe extends Verwaltungsliste<SchlafzimmerProdukt> {

    public SchlafzimmerListe() {
        setIndex(4);
    }

    public SchlafzimmerProdukt produktErzeugen(String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot){
        String seriennummer = "0"+getIndex()+"00"+(liste.size()+1);
        SchlafzimmerProdukt produkt = new SchlafzimmerProdukt(seriennummer, name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
        addProdukt(produkt);
        return produkt;
    }

    public void deleteProdukt(SchlafzimmerProdukt produkt){removeProdukt(produkt);}
}
