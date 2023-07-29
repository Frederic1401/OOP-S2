package src.Produkte;

import src.InvalidProductAttributeException;
import src.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Verwaltungsliste<ProduktTyp extends Produkt> {

    protected int index; //Der Index der jeweiligen Produkt-Kategorie
    public List<ProduktTyp> liste; //Die Liste des jeweiligen Produkt-Typus

    public Verwaltungsliste() {
        liste = new ArrayList<>();
    }

    protected abstract ProduktTyp createProdukt(String seriennummer, String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot);

    /**
     * @return Den Inhalt des Produktkataloges. Dabei wird jedes Produkt in einer neuen Zeile ausgegeben.
     */
    public String toString() {
        String output = "";
        output = this.getClass().getSimpleName()+": \n";
        for(int i=0; i<liste.size(); i++){
            output = output + liste.get(i).toString() + (i==liste.size()-1 ? null : "\n");
        }
        return output;
    }

    /**
     * @param produkt Das Objekt, das der Liste hinzugefügt werden soll
     */
    public void addProdukt(ProduktTyp produkt){liste.add(produkt);}

    /**
     * @param produkt Das Objekt, das aus der Liste entfernt werden soll
     */
    public void removeProdukt(ProduktTyp produkt){liste.remove(produkt);}

    public ProduktTyp produktErzeugen(String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) throws InvalidProductAttributeException {
        if(name.isEmpty() || name.equals("")){throw new InvalidProductAttributeException("Ungültiger Namen");}
        if(beschreibung.isEmpty() || beschreibung.equals("")){throw new InvalidProductAttributeException("Unvollständige Beschreibung");}
        if(jahrgang < 0) {throw new InvalidProductAttributeException("Ungültiger Jahrgang");}
        if(preis < 0){throw new InvalidProductAttributeException("Ungültiger Preis");}
        if(lieferzeit < 0){throw new InvalidProductAttributeException("Ungültige Lieferzeit");}
        if(mengenbestand < 0){throw new InvalidProductAttributeException("Ungültiger Mengenbestand");}

        String seriennummer = String.format("%02d", index)+String.format("%03d", liste.size()+1);
        ProduktTyp produkt = createProdukt(seriennummer, name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
        addProdukt(produkt);
        Main.getProduktkatalog().addProdukt(produkt);
        return produkt;
    }

    /**
     * @param suche Der Suchbegriff auf dem basierend der Namen und Beschreibung des Produktes untersucht werden
     * @return Eine Liste, aller Produkte dessen Name und Beschreibung zutreffen
     */
    public List<ProduktTyp> sucheProduktNachEingabe(String suche){
        List<ProduktTyp> fund = new ArrayList<>();
        for(ProduktTyp objekte : liste){
            Produkt produkt = objekte;
            if (produkt.getName().contains(suche) || produkt.getBeschreibung().contains(suche)) {
                fund.add(objekte);
            }
        }
        return fund;
    }

    public ProduktTyp sucheProduktNachSeriennummer(String seriennummer){
        for(ProduktTyp produkte : liste){
            if(produkte.getSeriennummer().equals(seriennummer)){
                return produkte;
            }
        }
        return null;
    }
    // Sortieren nach Name
    public void sortierenNachNamen() {Collections.sort(liste, Comparator.comparing(Produkt::getName));}

    // Sortieren nach Preis
    public void sortierenNachPreis() {Collections.sort(liste, Comparator.comparing(Produkt::getPreis));}

    // Sortieren nach Mengenbestand
    public void sortierenNachMenge() {Collections.sort(liste, Comparator.comparing(Produkt::getMengenbestand));}

    // Sortieren nach Seriennummer
    public void sortierenNachSeriennummer() {Collections.sort(liste, Comparator.comparing(Produkt::getSeriennummer));}

    // Sortieren nach Lieferzeit
    public void sortierenNachLieferzeit() {Collections.sort(liste, Comparator.comparing(Produkt::getLieferzeit));}

    // Sortieren nach Angebot (imAngebot)
    public void sortierenNachAngebot() {
        Collections.sort(liste, Comparator.comparing(Produkt::isImAngebot));
        Collections.reverse(liste);
    }

    // Sortieren nach Jahrgang
    public void sortierenNachJahrgang() {Collections.sort(liste, Comparator.comparing(Produkt::getJahrgang));}

    protected void setIndex(int index){this.index = index;}
    public int getIndex(){return index;}

    /**
     * @return Gibt die Liste des {@link ProduktTyp} zurück
     */
    public List<ProduktTyp> getListe() {return liste;}

    public void setListe(List<ProduktTyp> liste) {this.liste = liste;}
}
