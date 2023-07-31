package src.Produkte.Kategorien;

import src.Produkte.Produkt;

/**
 * Package 'src.Produkte.Kategorien'
 *
 * Zweck: Fachklasse eines spezifischen Produktes.
 * @author: Benjamin Adam
 * @version: 01.06.2023
 * Historie: 01.06.2023, Erstellung der Fachklasse
 */
public class SonstigesProdukt extends Produkt {

    /**
     * Konstruktor zur Initialisierung eines Produktobjekts mit den angegebenen Parametern.
     *
     * @param seriennummer   Die Seriennummer des Produkts.
     * @param name           Der Name des Produkts.
     * @param beschreibung   Die Beschreibung Daten des Produkts.
     * @param kaufempfehlung Die Kaufempfehlung für das Produkt.
     * @param jahrgang       Das Jahr, in dem das Produkt hergestellt wurde.
     * @param lieferzeit     Die Lieferzeit für das Produkt in Tagen.
     * @param mengenbestand  Der aktuelle Bestand des Produkts.
     * @param preis          Der Preis des Produkts.
     * @param imAngebot      Gibt an, ob das Produkt im Angebot ist.
     */
    public SonstigesProdukt(String seriennummer, String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) {
        super(seriennummer, "Sonstiges", name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
    }
}
