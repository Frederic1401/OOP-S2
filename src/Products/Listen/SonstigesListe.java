package src.Products.Listen;

import src.Exceptions.InvalidProductAttributeException;
import src.Products.Kategorien.BadezimmerProdukt;
import src.Products.Kategorien.SonstigesProdukt;
import src.Products.Produkt;
import src.Products.Verwaltungsliste;

public class SonstigesListe extends Verwaltungsliste<SonstigesProdukt> {

    public SonstigesListe() {
        setIndex(9);
    }

    public SonstigesProdukt produktErzeugen(String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) throws InvalidProductAttributeException {
        if(name.isEmpty()) throw new InvalidProductAttributeException("Name ungültig!");
        if(beschreibung.isEmpty()) throw new InvalidProductAttributeException("Beschreibung ungültig!");
        if(jahrgang < 0) throw new InvalidProductAttributeException("Jahrgang ungültig!");
        if(lieferzeit < 0) throw new InvalidProductAttributeException("Lieferzeit ungültig!");
        if(mengenbestand < 0) throw new InvalidProductAttributeException("Mengenbestand ungültig!");
        if(preis < 0) throw new InvalidProductAttributeException("Preis ungültig!");

        String seriennummer = getIndex()+"00"+(liste.size()+1);
        SonstigesProdukt produkt = new SonstigesProdukt(seriennummer, name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
        addProdukt(produkt);
        return produkt;
    }

    public void deleteProdukt(SonstigesProdukt produkt){removeProdukt(produkt);}
}
