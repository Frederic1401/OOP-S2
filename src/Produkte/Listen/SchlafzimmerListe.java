package src.Produkte.Listen;

import src.Produkte.Kategorien.SchlafzimmerProdukt;
import src.Produkte.Produkt;
import src.Produkte.Verwaltungsliste;

/**
 * Package 'src.Produkte.Listen'
 *
 * Zweck: Fachklasse einer Verwaltungsliste zum Verwalten der vorhanden Objekte.
 * @author: Till Eulich
 * @version: 01.06.2023
 * Historie: 01.06.2023, Erstellung der Klasse
 */
public class SchlafzimmerListe extends Verwaltungsliste<SchlafzimmerProdukt> {

    public SchlafzimmerListe() {
        setIndex(4);
    } //Der Index der Kategorie wird auf 4 gesetzt.

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
     * @return Gibt ein Objekt der Klasse SchlafzimmerProdukt zurück.
     */
    protected SchlafzimmerProdukt createProdukt(String seriennummer, String name, String beschreibung, Produkt kaufempfehlung, int jahrgang, int lieferzeit, int mengenbestand, double preis, boolean imAngebot) {
        return new SchlafzimmerProdukt(seriennummer, name, beschreibung, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
    }
}
