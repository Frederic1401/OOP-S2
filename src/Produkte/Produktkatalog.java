package src.Produkte;

import javax.swing.*;
import java.util.HashMap;

/**
 * Package 'code.Products'
 *
 * Zweck: Produktkatalog, der vorhanden Objekte der Fachklasse Produkt verwaltet
 * @author: Till Eulich
 * @version: 21.05.2023
 * Historie: 21.05.2023, Erstellung der Klasse
 */
public class Produktkatalog extends Verwaltungsliste<Produkt>{

    public HashMap<Produkt, ImageIcon> produktBilderHashMap;

    public Produktkatalog() {this.produktBilderHashMap = new HashMap<>();}

    @Override
    protected Produkt createProdukt(String seriennummer, String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) {
        return null;
    }

    public HashMap<Produkt, ImageIcon> getProduktBilderHashMap(){return produktBilderHashMap;}
}
