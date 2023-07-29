package src;

import src.GraphicalUserInterfaces.MainFrame;
import src.Produkte.Listen.*;
import src.Produkte.Produktkatalog;

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
        produktkatalog = new Produktkatalog();

        elektronikListe = new ElektronikListe();
        kuecheListe = new KuecheListe();
        badezimmerListe = new BadezimmerListe();
        schlafzimmerListe = new SchlafzimmerListe();
        wohnzimmerListe = new WohnzimmerListe();
        sonstigesListe = new SonstigesListe();

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
