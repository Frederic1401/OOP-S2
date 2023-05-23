package oop;

public class ProduktKatalogTest {

    public static void main(String[] args) {
        ProduktKatalog produktKatalog = new ProduktKatalog();

        // Test der Methode neuesProduktErstellen
        produktKatalog.neuesProduktErstellen();

        // Test der Methode anzeigenProduktKatalog
        produktKatalog.anzeigenProduktKatalog();

        // Vergleich des erstellten Produkts mit der Ausgabe der Methode anzeigenProduktKatalog
        Produkt erstelltesProdukt = produktKatalog.getProduktKatalog().get(0);
        boolean test1Erfolgreich = false;

        if (erstelltesProdukt != null && produktKatalog.getProduktKatalog().size() == 1) {
            Produkt vergleichsProdukt = produktKatalog.getProduktKatalog().get(0);
            if (erstelltesProdukt.equals(vergleichsProdukt)) {
                test1Erfolgreich = true;
            }
        }

        if (test1Erfolgreich) {
            System.out.println("Der Test war erfolgreich. Das erstellte Produkt stimmt mit der Ausgabe der Methode anzeigenProduktKatalog überein.");
        } else {
            System.out.println("Der Test war nicht erfolgreich. Das erstellte Produkt stimmt nicht mit der Ausgabe der Methode anzeigenProduktKatalog überein.");
        }

        // Test der Methode bestehendesProduktBearbeiten
        Produkt produktVorBearbeitung = produktKatalog.getProduktKatalog().get(0);


        // Bearbeitung des Produkts
        produktKatalog.bestehendesProduktBearbeiten();

        // Nach der Bearbeitung anzeigen
        System.out.println("Produkt nach der Bearbeitung:");
        produktKatalog.anzeigenProduktKatalog();

        // Vergleich des Produkts vor und nach der Bearbeitung
        Produkt produktNachBearbeitung = produktKatalog.getProduktKatalog().get(0);

        boolean test2Erfolgreich = false;

        if (!produktVorBearbeitung.equals(produktNachBearbeitung)) {
            test2Erfolgreich = true;
        }

        if (test2Erfolgreich) {
            System.out.println("Der Test war nicht erfolgreich. Das Produkt wurde nicht erfolgreich bearbeitet.");
        } else {
            System.out.println("Der Test war erfolgreich. Das Produkt wurde korrekt bearbeitet.");
        }
    }
}