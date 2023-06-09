package src.Products;

import java.util.ArrayList;
import java.util.List;

/**
 * Package 'code.Products'
 *
 * Zweck: Produktkatalog, der vorhanden Objekte der Fachklasse Produkt verwaltet
 * @author: Till Eulich
 * @version: 21.05.2023
 * Historie: 21.05.2023, Erstellung der Klasse
 */
public class Produktkatalog {

    private final ArrayList<Produkt> produktListe; //Liste, zu der alle Produkte, die im Katalog existieren sollen, hinzugefügt werden.

    /**
     * Initialisiert die Liste aller Produkte
     */
    public Produktkatalog() {
        produktListe = new ArrayList<>();
    }

    /**
     * @param produkt Das Produkt, das zum Katalog hinzugefügt werden soll.
     */
    public void addProdukt(Produkt produkt){produktListe.add(produkt);}

    /**
     * @param produkt Das Produkt, das aus dem Katalog entfernt werden soll.
     */
    public void removeProdukt(Produkt produkt){produktListe.remove(produkt);}

    /**
     * @param suche Das gesuchte Stichwort oder Phrase.
     * @return Gibt eine Liste aller Produkte zurück, auf die die gesuchte Eingabe hinsichtlich ihres Namens oder Beschreibung zutrifft.
     */
    public List<Produkt> suchProdukte(String suche){
        List<Produkt> fund = new ArrayList<>();
        for(Produkt produkte : produktListe){
            if(produkte.getName().equalsIgnoreCase(suche) || produkte.getBeschreibung().contains(suche)){
                fund.add(produkte);
            }
        }
        return fund;
    }

    /**
     * @return Den Inhalt des Produktkataloges. Dabei wird jedes Produkt in einer neuen Zeile ausgegeben.
     */
    public String toString() {
        String output = "";
        output = "Produktkatalog: \n";
        for(int i=0; i<produktListe.size(); i++){
            output = output + produktListe.get(i).toString() + (i==produktListe.size()-1 ? null : "\n");
        }
        return output;
    }

    /**
     * Wandelt eine Produkt-Kategorie in einen Integer-Wert um. Dies dient dem Nutzen der JComboBox aus dem {@link src.GraphicalUserInterfaces.ProductCreatorFrame}
     *
     * @param kategorie Die Kategorie eines Produktes, die in einen Integer-Wert umgewandelt werden soll
     * @return Der umgewandelte Integer-Wert für die Kategorie (1 für "Elektronik", 2 für "Küche", 3 für "Badezimmer", 4 für "Schlafzimmer", 5 für "Wohnzimmer", 10 für "Sonstiges")
     */
    public int transformKategorieIntoInteger(String kategorie) {
        if (kategorie.equals("Elektronik")) {
            return 1;
        } else if (kategorie.equals("Küche")) {
            return 2;
        } else if (kategorie.equals("Badezimmer")) {
            return 3;
        } else if (kategorie.equals("Schlafzimmer")){
            return 4;
        } else if (kategorie.equals("Wohnzimmer")) {
            return 5;
        } else if (kategorie.equals("Sonstiges")) {
            return 6;
        }
        return 0;
    }

    /**
     * Gibt das Produkt mit der angegebenen Seriennummer zurück.
     *
     * @param seriennummer Die Seriennummer des gesuchten Produkts
     * @return Das Produkt mit der angegebenen Seriennummer oder null, wenn kein Produkt gefunden wurde
     */
    public Produkt getProduktBySeriennummer(int seriennummer) {
        for (Produkt produkte : produktListe) {
            if (produkte.getSeriennummer() == seriennummer) {
                return produkte;
            }
        }
        return null;
    }

    /**
     * Gibt das Produkt mit dem angegebenen Namen zurück.
     *
     * @param name Der Name des gesuchten Produkts
     * @return Das Produkt mit dem angegebenen Namen oder null, wenn kein Produkt gefunden wurde
     */
    public Produkt getProduktByName(String name) {
        for (Produkt produkte : produktListe) {
            if (produkte.getName().equalsIgnoreCase(name)) {
                return produkte;
            }
        }
        return null;
    }

    /**
     * Gibt die Liste aller Produkte zurück.
     *
     * @return Die Liste aller Produkte
     */
    public ArrayList<Produkt> getProduktListe() {
        return produktListe;
    }
}
