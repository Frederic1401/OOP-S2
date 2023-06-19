package src.Products.Listen;

import src.Products.Kategorien.ElektronikProdukt;
import src.Products.Produkt;
import src.Products.Verwaltungsliste;

public class ElektronikListe extends Verwaltungsliste<ElektronikProdukt>{

    public ElektronikListe() {
        setIndex(1);
    }

    public ElektronikProdukt produktErzeugen(String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot){
        String seriennummer = "0"+getIndex()+"00"+(liste.size()+1);
        ElektronikProdukt produkt = new ElektronikProdukt(seriennummer, name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
        addProdukt(produkt);
        return produkt;
    }

    public void deleteProdukt(ElektronikProdukt produkt){removeProdukt(produkt);}

}
