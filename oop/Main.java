package oop;

import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        ProduktKatalog produktKatalog = new ProduktKatalog();
        SwingUtilities.invokeLater(() -> {
            ProductKatalogGUI catalogGUI = new ProductKatalogGUI();
            catalogGUI.setVisible(true);
        });
    
    

        boolean beenden = false;
        Scanner scanner = new Scanner(System.in);

        while (!beenden) {
            System.out.println("1. Neues Produkt anlegen");
            System.out.println("2. Bestehendes Produkt überarbeiten");
            System.out.println("3. Vorhandene Produkte anzeigen");
            System.out.println("4. Exit");
            System.out.println("Bitte Nummer eingeben von 1 bis 4!");

            if (scanner.hasNextInt()) {
                int auswahl = scanner.nextInt();
                scanner.nextLine();

                switch (auswahl) {
                    case 1:
                        produktKatalog.neuesProduktErstellen();
                        break;
                    case 2:
                        produktKatalog.bestehendesProduktBearbeiten();
                        break;
                    case 3:
                        produktKatalog.anzeigenProduktKatalog();
                        break;
                    case 4:
                        beenden = true;
                        break;
                    default:
                        System.out.println("Ungültige Eingabe! Bitte eine Nummer von 1 bis 4 eingeben. \n");
                        break;
                }
            } else {
                System.out.println("Ungültige Eingabe! Bitte eine Nummer von 1 bis 4 eingeben. \n");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
