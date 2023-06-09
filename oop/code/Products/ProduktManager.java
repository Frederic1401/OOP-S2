package oop.code.Products;

import java.util.HashMap;

public class ProduktManager {

    private final HashMap<Integer, Produkt> produktListe;

    public ProduktManager() {
        produktListe = new HashMap<>();
    }

    /**
     * Wandelt eine Produkt-Kategorie in einen Integer-Wert um. Dies dient dem Nutzen der JComboBox aus dem {@link code.GraphicalUserInterfaces.ProductCreatorFrame}
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
            return 10;
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
        for (Produkt produkte : produktListe.values()) {
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
        for (Produkt produkte : produktListe.values()) {
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
    public HashMap<Integer, Produkt> getProduktListe() {
        return produktListe;
    }
}
