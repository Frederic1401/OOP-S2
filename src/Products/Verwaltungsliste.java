package src.Products;

import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Verwaltungsliste<ProduktTyp extends Comparable> {

    protected int index;
    public ArrayList<ProduktTyp> liste; //Die Liste des jeweiligen Produkt-Typus

    public Verwaltungsliste() {
        liste = new ArrayList<>();
    }

    /**
     * @param produkt Das Objekt, das der Liste hinzugefügt werden soll
     */
    public void addProdukt(ProduktTyp produkt){liste.add(produkt);}

    /**
     * @param produkt Das Objekt, das aus der Liste entfernt werden soll
     */
    public void removeProdukt(ProduktTyp produkt){liste.remove(produkt);}

    public ProduktTyp sucheProduktNachNamen(String name){
        for (ProduktTyp produktListe : liste){
            if(produktListe instanceof  Produkt){
                Produkt produkte = (Produkt) produktListe;
                if(produkte.getName().equalsIgnoreCase(name)){
                    return (ProduktTyp) produkte;
                }
            }
        }
        return null;
    }

    public ProduktTyp sucheProduktNachSeriennummer(String seriennummer){
        for (ProduktTyp produktListe : liste){
            if(produktListe instanceof  Produkt){
                Produkt produkte = (Produkt) produktListe;
                if(produkte.getSeriennummer().equalsIgnoreCase(seriennummer)){
                    return (ProduktTyp) produkte;
                }
            }
        }
        return null;
    }

    /**
     * @param suche Der Suchbegriff auf dem basierend der Namen und Beschreibung des Produktes untersucht werden
     * @return Eine Liste, aller Produkte dessen Name und Beschreibung zutreffen
     */
    public List<ProduktTyp> sucheProduktNachEingabe(String suche){
        List<ProduktTyp> fund = new ArrayList<>();
        for(ProduktTyp objekte : liste){
            if (objekte instanceof Produkt) {
                Produkt produkt = (Produkt) objekte;
                if (produkt.getName().contains(suche) || produkt.getBeschreibung().contains(suche)) {
                    fund.add(objekte);
                }
            }
        }
        return fund;
    }
/*
    public void sortiereNachNamen(){
        Collections.sort(liste, new Comparator<ProduktTyp>() {
            @Override
            public int compare(ProduktTyp p1, ProduktTyp p2) {
                if(p1 instanceof Produkt && p2 instanceof Produkt){
                    Produkt produkt = (Produkt) p1;
                    Produkt other = (Produkt) p2;
                    return produkt.getName().compareToIgnoreCase(other.getName());
                }
                return 0;
            }
        });
    }

    public void sortiereNachPreis(){
        Collections.sort(liste, new Comparator<ProduktTyp>() {
            @Override
            public int compare(ProduktTyp p1, ProduktTyp p2) {
                if(p1 instanceof Produkt && p2 instanceof Produkt){
                    Produkt produkt = (Produkt) p1;
                    Produkt other = (Produkt) p2;
                    return produkt.compareTo(other);
                }
                return 0;
            }
        });
    }

*/

    protected void setIndex(int index){this.index = index;}
    public int getIndex(){return index;}

    /**
     * @return Gibt die Liste des {@link ProduktTyp} zurück
     */
    public ArrayList<ProduktTyp> getListe() {return liste;}
}
