package src.Products.Listen;

import src.Products.Kategorien.BadezimmerProdukt;
import src.Products.Kategorien.ElektronikProdukt;
import src.Products.Produkt;
import src.Products.Verwaltungsliste;

public class BadezimmerListe extends Verwaltungsliste<BadezimmerProdukt> {

    public BadezimmerListe() {
        setIndex(3);
    }

    public BadezimmerProdukt produktErzeugen(String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot){
        String seriennummer = "0"+getIndex()+"00"+(liste.size()+1);
        BadezimmerProdukt produkt = new BadezimmerProdukt(seriennummer, name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
        addProdukt(produkt);
        return produkt;
    }

    public void deleteProdukt(BadezimmerProdukt produkt){removeProdukt(produkt);}
}
