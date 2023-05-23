package oop;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ProduktKatalog produktKatalog = new ProduktKatalog();

        System.out.println("Das Programm wird gestartet...");


        Scanner scanner = new Scanner(System.in);
        boolean schleife = true;
        while(schleife) {
            System.out.println("1. Neues Produkt anlegen");
            System.out.println("2. Bestehendes Produkt überarbeiten (Work in Progress)");
            System.out.println("3. Vorhandende Produkte anzeigen");
            System.out.println("4. Exit");
            System.out.println("Bitte Nummer eingeben von 1 bis 4!");

            int eingabe = Integer.parseInt(scanner.nextLine());
            scanner.nextLine();

            switch (eingabe) {
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
                    schleife = false;
                    break;
                default:
                    System.out.println("Falsche Eingabe! Bitte eine Nummer von 1 bis 4 eingeben!");
            }
        }
        scanner.close();
    }
}
