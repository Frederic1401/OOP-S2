package src.Testklassen;

import src.GraphicalUserInterfaces.MainFrame;
import src.Produkte.Listen.*;
import src.Produkte.Produktkatalog;

public class Testklasse_Phase3 {

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
        //Der JFrame des Programms wird initialisiert.
        mainFrame = new MainFrame();
    }
}
