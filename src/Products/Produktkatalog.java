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
public class Produktkatalog extends Verwaltungsliste<Produkt>{

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
}
