package src;

import src.GraphicalUserInterfaces.MainFrame;
import src.Produkte.Listen.*;
import src.Produkte.Produktkatalog;

/**
 * Package 'src'
 *
 * Zweck: Main Klasse der Anwendung; Dient zum Initialisieren der Verwaltungslisten und der Klasse 'MainFrame'. Des Weiteren wird hier der Umfang der 3. Phase getestet.
 * @author: Maximilian Böhme, Frederic Oetgen
 * @version: 21.05.2023
 * Historie: 21.05.2023, Erstellung der Klasse
 *           16.06.2023, Initialisierung der Klasse 'MainFrame' und entsprechendem Getter
 */
public class Main {

    private static Produktkatalog produktkatalog;
    private static ElektronikListe elektronikListe;
    private static KuecheListe kuecheListe;
    private static BadezimmerListe badezimmerListe;
    private static SchlafzimmerListe schlafzimmerListe;
    private static WohnzimmerListe wohnzimmerListe;
    private static SonstigesListe sonstigesListe;
    private static MainFrame mainFrame;

    public static void main(String[] args) {
        //Die einzelnen Produkt-Listen werden initialisiert.
        produktkatalog = new Produktkatalog();
        elektronikListe = new ElektronikListe();
        kuecheListe = new KuecheListe();
        badezimmerListe = new BadezimmerListe();
        schlafzimmerListe = new SchlafzimmerListe();
        wohnzimmerListe = new WohnzimmerListe();
        sonstigesListe = new SonstigesListe();
        //Die GUI der Anwendung wird initialisiert.
        mainFrame = new MainFrame();
    }
    public static Produktkatalog getProduktkatalog() {
        return produktkatalog;
    }
    public static ElektronikListe getElektronikListe() {return elektronikListe;}
    public static KuecheListe getKuecheListe() {return kuecheListe;}
    public static BadezimmerListe getBadezimmerListe() {return badezimmerListe;}
    public static SchlafzimmerListe getSchlafzimmerListe() {return schlafzimmerListe;}
    public static WohnzimmerListe getWohnzimmerListe() {return wohnzimmerListe;}
    public static SonstigesListe getSonstigesListe() {return sonstigesListe;}
    public static MainFrame getMainFrame() {return mainFrame;}
}
