package src.Produkte;

import src.Main;
import src.Produkte.Kategorien.SchlafzimmerProdukt;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Package 'src.Produkte'
 *
 * Zweck: Produktkatalog, der vorhanden Objekte der Fachklasse Produkt verwaltet.
 * @author: Till Eulich, Hanno Schulz
 * @version: 07.07.2023
 * Historie: 21.05.2023, Erstellung der Klasse
 *           07.07.2023, Universelle Methode zum Löschen und Erstellung der HashMap
 */
public class Produktkatalog extends Verwaltungsliste<Produkt>{

    public HashMap<Produkt, ImageIcon> produktBilderHashMap = new HashMap<>(); //HashMap, in der die jeweiligen Bilder der Produkte für das GUI gespeichert werden.

    /**
     * Diese Methode soll in der Form nicht verwendet werden. Anstelle sollen die anderen Klassen, die aus Verwaltungsliste erben, Produkte generieren.
     *
     * @param seriennummer     Die Seriennummer des Produkts.
     * @param name             Der Name des Produkts.
     * @param beschreibung     Die Beschreibung Daten des Produkts.
     * @param kaufempfehlung   Die Kaufempfehlung für das Produkt.
     * @param jahrgang         Das Jahr, in dem das Produkt hergestellt wurde.
     * @param lieferzeit       Die Lieferzeit für das Produkt in Tagen.
     * @param mengenbestand    Der aktuelle Bestand des Produkts.
     * @param preis            Der Preis des Produkts.
     * @param imAngebot        Gibt an, ob das Produkt im Angebot ist.
     * @return Gibt ein Objekt der Klasse Produkt zurück.
     */
    protected Produkt createProdukt(String seriennummer, String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) {
        return null;
    }
    /**
     * @param produkt Das Produkt, das aus sämtlichen Listen entfernt werden soll.
     */
    public void produktEntfernen(Produkt produkt){
        liste.remove(produkt);
        if(Main.getElektronikListe().getListe().contains(produkt)){Main.getElektronikListe().getListe().remove(produkt);}
        if(Main.getKuecheListe().getListe().contains(produkt)){Main.getKuecheListe().getListe().remove(produkt);}
        if(Main.getBadezimmerListe().getListe().contains(produkt)){Main.getBadezimmerListe().getListe().remove(produkt);}
        if(Main.getSchlafzimmerListe().getListe().contains(produkt)){Main.getSchlafzimmerListe().getListe().remove(produkt);}
        if(Main.getWohnzimmerListe().getListe().contains(produkt)){Main.getWohnzimmerListe().getListe().remove(produkt);}
        if(Main.getSonstigesListe().getListe().contains(produkt)){Main.getSonstigesListe().getListe().remove(produkt);}
    }

    /**
     * @return HashMap, in der die jeweiligen Bilder der Produkte für das GUI gespeichert wurden.
     */
    public HashMap<Produkt, ImageIcon> getProduktBilderHashMap(){return produktBilderHashMap;}
}
