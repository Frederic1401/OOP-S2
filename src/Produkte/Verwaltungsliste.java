package src.Produkte;

import src.InvalidProductAttributeException;
import src.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Package 'src.Produkte'
 *
 * Zweck: Fachklasse einer Verwaltungsliste zum Verwalten der vorhanden Objekte, Zwecks Vererbung.
 * @author: Till Eulich
 * @version: 01.06.2023
 * Historie: 01.06.2023, Erstellung der Klasse
 */
public abstract class Verwaltungsliste<ProduktTyp extends Produkt>{

    protected int index; //Der Index der jeweiligen Produkt-Kategorie.
    public List<ProduktTyp> liste; //Die Liste des jeweiligen Produkt-Typus.

    public Verwaltungsliste() {
        liste = new ArrayList<>();
    }

    /**
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
    protected abstract ProduktTyp createProdukt(String seriennummer, String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot);

    /**
     * @return Den Inhalt des Produktkataloges. Dabei wird jedes Produkt in einer neuen Zeile ausgegeben.
     */
    public String toString() {
        String output = "";
        output = "Produktkatalog: \n";
        for(int i=0; i<liste.size(); i++){
            output = output + liste.get(i).toString() + (i==liste.size()-1 ? null : "\n");
        }
        return output;
    }

    /**
     * @param produkt Das Produkt, das der Liste hinzugefügt werden soll.
     */
    public void addProdukt(ProduktTyp produkt){liste.add(produkt);}

    /**
     * @param name             Der Name des Produkts.
     * @param beschreibung     Die Beschreibung Daten des Produkts.
     * @param kaufempfehlung   Die Kaufempfehlung für das Produkt.
     * @param jahrgang         Das Jahr, in dem das Produkt hergestellt wurde.
     * @param lieferzeit       Die Lieferzeit für das Produkt in Tagen.
     * @param mengenbestand    Der aktuelle Bestand des Produkts.
     * @param preis            Der Preis des Produkts.
     * @param imAngebot        Gibt an, ob das Produkt im Angebot ist.
     * @return Gibt ein Objekt der Klasse Produkt zurück.
     * @throws InvalidProductAttributeException, wenn eine der angegebenen Attribute fehlerhaft ist.
     */
    public ProduktTyp produktErzeugen(String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) throws InvalidProductAttributeException {
        //Die 'InvalidProductAttributeException' wird implementiert
        if(name.isEmpty()){throw new InvalidProductAttributeException("Ungültiger Namen");}
        if(beschreibung.isEmpty()){throw new InvalidProductAttributeException("Unvollständige Beschreibung");}
        if(jahrgang < 0) {throw new InvalidProductAttributeException("Ungültiger Jahrgang");}
        if(preis < 0){throw new InvalidProductAttributeException("Ungültiger Preis");}
        if(lieferzeit < 0){throw new InvalidProductAttributeException("Ungültige Lieferzeit");}
        if(mengenbestand < 0){throw new InvalidProductAttributeException("Ungültiger Mengenbestand");}
        //Abschließend wird das Produkt erstellt und der Liste hinzugefügt
        String seriennummer = String.format("%02d", index)+String.format("%03d", liste.size()+1);
        ProduktTyp produkt = createProdukt(seriennummer, name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
        addProdukt(produkt);
        Main.getProduktkatalog().addProdukt(produkt);
        return produkt;
    }

    /**
     * @param suche Der Suchbegriff, auf dem basierend der Namen und Beschreibung des Produktes untersucht werden.
     * @return Eine Liste, aller Produkt dessen Name und Beschreibung zutreffen.
     */
    public List<ProduktTyp> sucheProduktNachEingabe(String suche){
        List<ProduktTyp> fund = new ArrayList<>();
        for(ProduktTyp objekte : liste){
            if (objekte.getName().contains(suche) || objekte.getBeschreibung().contains(suche)) {
                fund.add(objekte);
            }
        }
        return fund;
    }

    /**
     * @param seriennummer Die Seriennummer, auf der basierend ein Produkt gesucht werden soll.
     * @return Ein Produkt, dessen Seriennummer mit der angegebenen übereinstimmt.
     */
    public ProduktTyp sucheProduktNachSeriennummer(String seriennummer){
        for(ProduktTyp produkte : liste){
            if(produkte.getSeriennummer().equals(seriennummer)){
                return produkte;
            }
        }
        return null;
    }

    /**
     * Sortiert die Liste nach Name.
     */
    public void sortierenNachNamen() {liste.sort(Comparator.comparing(Produkt::getMengenbestand));}

    /**
     * Sortiert die Liste nach Preis.
     */
    public void sortierenNachPreis() {liste.sort(Comparator.comparing(Produkt::getMengenbestand));}

    /**
     * Sortiert die Liste nach Menge.
     */
    public void sortierenNachMenge() {liste.sort(Comparator.comparing(Produkt::getMengenbestand));}

    /**
     * Sortiert die Liste nach Seriennummer.
     */
    public void sortierenNachSeriennummer() {liste.sort(Comparator.comparing(Produkt::getMengenbestand));}

    /**
     * Sortiert die Liste nach Lieferzeit.
     */
    public void sortierenNachLieferzeit() {liste.sort(Comparator.comparing(Produkt::getMengenbestand));}

    /**
     * Sortiert die Liste nach Angebot.
     */
    public void sortierenNachAngebot() {
        liste.sort(Comparator.comparing(Produkt::getMengenbestand));
        Collections.reverse(liste);
    }

    /**
     * Sortiert die Liste nach Jahrgang.
     */
    public void sortierenNachJahrgang() {liste.sort(Comparator.comparing(Produkt::getMengenbestand));}

    /**
     * @return Gibt die Produkt-Liste zurück.
     */
    public List<ProduktTyp> getListe() {return liste;}

    /**
     * @param liste Eine Liste der Klasse Produkt, die die bestehende Liste ersetzen soll.
     */
    public void setListe(List<ProduktTyp> liste) {this.liste = liste;}

    protected void setIndex(int index){this.index = index;}
    public int getIndex(){return index;}
}
