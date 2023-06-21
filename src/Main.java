package src;

import src.GraphicalUserInterfaces.MainFrame;
import src.Products.Listen.*;
import src.Products.Produktkatalog;
import src.Products.Verwaltungsliste;

import javax.swing.*;

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

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        mainFrame = new MainFrame();
    }

    public static Verwaltungsliste getKategorieNachNamen(String eingabe){
        if (eingabe.equals("Elektronik")) {
            return elektronikListe;
        } else if (eingabe.equals("Küche")) {
            return kuecheListe;
        } else if (eingabe.equals("Badezimmer")) {
            return badezimmerListe;
        } else if (eingabe.equals("Schlafzimmer")){
            return schlafzimmerListe;
        } else if (eingabe.equals("Wohnzimmer")) {
            return wohnzimmerListe;
        } else if (eingabe.equals("Sonstiges")) {
            return sonstigesListe;
        }
        return null;
    }

    public static Produktkatalog getProduktkatalog() {return produktkatalog;}
    public static ElektronikListe getElektronikListe() {return elektronikListe;}
    public static KuecheListe getKuecheListe() {return kuecheListe;}
    public static BadezimmerListe getBadezimmerListe() {return badezimmerListe;}
    public static SchlafzimmerListe getSchlafzimmerListe() {return schlafzimmerListe;}
    public static WohnzimmerListe getWohnzimmerListe (){return wohnzimmerListe;}
    public static SonstigesListe getSonstigesListe() {return sonstigesListe;}
    public static MainFrame getMainFrame() {return mainFrame;}
}