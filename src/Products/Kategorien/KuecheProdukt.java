package src.Products.Kategorien;

import src.Products.Produkt;

public class KuecheProdukt extends Produkt {

    /**
     * Konstruktor zur Initialisierung eines Produktobjekts mit den angegebenen Parametern.
     *
     * @param seriennummer
     * @param name           Der Name des Produkts
     * @param beschreibung   Die Beschreibung Daten des Produkts
     * @param kaufempfehlung Die Kaufempfehlung für das Produkt
     * @param jahrgang       Das Jahr, in dem das Produkt hergestellt wurde
     * @param lieferzeit     Die Lieferzeit für das Produkt in Tagen
     * @param mengenbestand  Der aktuelle Bestand des Produkts
     * @param preis          Der Preis des Produkts
     * @param imAngebot      Gibt an, ob das Produkt im Angebot ist
     */
    public KuecheProdukt(String seriennummer, String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) {
        super(seriennummer, "Küche", name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
    }
}
